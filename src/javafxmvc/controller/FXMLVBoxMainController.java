
package javafxmvc.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;


public class FXMLVBoxMainController implements Initializable {
    @FXML
    private MenuItem menuItemCadastrosFuncionario;
    @FXML
    private MenuItem menuItemProcessosFuncoes;
    @FXML
    private MenuItem menuItemRelatoriosFuncionario;
    @FXML
    private AnchorPane anchrPane;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    public void handleMenuItemCadastrosFuncionario() throws IOException{
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/javafxmvc/view/FXMLAnchorPaneCadastrosFuncionario.fxml"));
        System.out.println(a);
        
        
        anchrPane.getChildren().setAll(a);
        
    
    }
    
}