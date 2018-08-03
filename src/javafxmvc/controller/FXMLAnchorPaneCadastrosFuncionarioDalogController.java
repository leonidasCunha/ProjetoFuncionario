/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxmvc.model.domain.Funcionario;

/**
 * FXML Controller class
 *
 * @author leonidas
 */
public class FXMLAnchorPaneCadastrosFuncionarioDalogController implements Initializable {

    @FXML
    private Label labelFuncionarioNome;

    @FXML
    private Label labelFuncionarioCPF;
    
    @FXML
    private Label labelFuncionarioTelefone;

    @FXML
    private TextField textFieldFuncionarioNome;
    
    @FXML
    private TextField textFieldFuncionarioCPF;

    @FXML
    private TextField textFieldFuncionarioTelefone;
    
    @FXML
    private Button ButtonConfirmar;

    @FXML
    private Button ButtonCancelar;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Funcionario funcionario;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /**
     * @return the dialogStage
     */
    public Stage getDialogStage() {
        return dialogStage;
    }

    /**
     * @param dialogStage the dialogStage to set
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * @return the buttonConfirmarClicked
     */
    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    /**
     * @param buttonConfirmarClicked the buttonConfirmarClicked to set
     */
    public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
        this.buttonConfirmarClicked = buttonConfirmarClicked;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
        this.textFieldFuncionarioNome.setText(funcionario.getNome());
        this.textFieldFuncionarioCPF.setText(funcionario.getCpf());
        this.textFieldFuncionarioTelefone.setText(funcionario.getTelefone());
    }
    @FXML
    public void handleButtonConfirmar(){
        funcionario.setNome(textFieldFuncionarioNome.getText());
        funcionario.setCpf(textFieldFuncionarioCPF.getText());
        funcionario.setTelefone(textFieldFuncionarioTelefone.getText());
        
        buttonConfirmarClicked = true;
        dialogStage.close();
    }
    @FXML
    public void handleButtonCancelar(){
        dialogStage.close();
    
    }
    
    
}
