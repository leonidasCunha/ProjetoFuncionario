package javafxmvc.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafxmvc.model.dao.FuncionarioDAO;
import javafxmvc.model.database.Database;
import javafxmvc.model.database.DatabaseFactory;
import javafxmvc.model.domain.Funcionario;
import sun.plugin.javascript.navig.Anchor;

public class FXMLAnchorPaneCadastrosFuncionarioController implements Initializable {

    @FXML
    private TableView<Funcionario> tableViewFuncionario;
    @FXML
    private TableColumn<Funcionario, String> tableColumnFuncionarioNome;
    @FXML
    private TableColumn<Funcionario, String> tableColumnFuncionarioCPF;
    @FXML
    private Button buttonInserir;
    @FXML
    private Button buttonAlterar;
    @FXML
    private Button buttonRemover;
    @FXML
    private Label labelFuncionarioCodigo;
    @FXML
    private Label labelFuncionarioNome;
    @FXML
    private Label labelFuncionarioCPF;
    @FXML
    private Label labelFuncionarioTelefone;

    //e quando a minha clase list fou no banco de dados retorna uma lista
    private List<Funcionario> listFuncionario;
    // por que um compone table view eu  preciso de seta os dados 
    //desse componetnte table view com observa bolist.
    private ObservableList<Funcionario> ObservableListFuncionario;

    //atributos para manipulação de banco de dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connetion = database.conectar();
    private final FuncionarioDAO funcionarioDao = new FuncionarioDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        funcionarioDao.setConnection(connetion);
        carregarTableViewFuncionario();

        //Listeem acionado diante de qualquer alteração na seleção de itens de TableView
        tableViewFuncionario.getSelectionModel().selectedItemProperty().addListener(
                (observable, olderValue, newValue) -> selecionarItemTableViewFuncionario(newValue));
    }

    public void carregarTableViewFuncionario() {
        tableColumnFuncionarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnFuncionarioCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));

        //List<Funcionario> funciona;
        //funciona = Arrays.asList(new Funcionario(1, "testamdp", "123476"));
        listFuncionario =  funcionarioDao.listar();

        //ObservableList<Funcionario> 
        ObservableListFuncionario = FXCollections.observableArrayList(listFuncionario);
        tableViewFuncionario.setItems(ObservableListFuncionario);

    }

    public void selecionarItemTableViewFuncionario(Funcionario funcionario) {
        if (funcionario != null) {
            labelFuncionarioCodigo.setText(String.valueOf(funcionario.getCdFuncionario()));
            labelFuncionarioNome.setText(funcionario.getNome());
            labelFuncionarioCPF.setText(funcionario.getCpf());
            labelFuncionarioTelefone.setText(funcionario.getTelefone());

        } else {
            labelFuncionarioCodigo.setText("");
            labelFuncionarioNome.setText("");
            labelFuncionarioCPF.setText("");
            labelFuncionarioTelefone.setText("");

        }
    }
    @FXML
    public void handleButtonInserir() throws IOException {
        Funcionario funcionario = new Funcionario();
        boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosFuncionarioDalog(funcionario);
            if(buttonConfirmarClicked){
                funcionarioDao.inserir(funcionario);
                carregarTableViewFuncionario();
            }
        }
    @FXML
    public void handleButtonAlterar() throws IOException {
        Funcionario funcionario = tableViewFuncionario.getSelectionModel().getSelectedItem();
        if(funcionario != null){
            boolean buttonConfirmarClicked = showFXMLAnchorPaneCadastrosFuncionarioDalog(funcionario);
                if(buttonConfirmarClicked){
                    funcionarioDao.alterar(funcionario);
                    carregarTableViewFuncionario();
                }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um funcionario na Tabela! ");
            alert.show();
        }
    }
    
    @FXML
    public void handleButtonRemover() throws IOException{
        Funcionario funcionario = tableViewFuncionario.getSelectionModel().getSelectedItem();
            if(funcionario != null){
                funcionarioDao.remover(funcionario);
                carregarTableViewFuncionario();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Por Favor, escolha um funcionario na tabela! ");
                alert.show();
            }
        
    }
    public boolean showFXMLAnchorPaneCadastrosFuncionarioDalog(Funcionario funcionario) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneCadastrosFuncionarioDalogController.class.getResource("/javafxmvc/view/FXMLAnchorPaneCadastrosFuncionarioDalog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Stage dialogStage = new Stage();
        dialogStage.setTitle("cadastro de Funcionario");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        
        FXMLAnchorPaneCadastrosFuncionarioDalogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setFuncionario(funcionario);
        
        // fica de espera ate que usuario feche
        
        dialogStage.showAndWait();
        
        return controller.isButtonConfirmarClicked();
        
    }
    
    

}
