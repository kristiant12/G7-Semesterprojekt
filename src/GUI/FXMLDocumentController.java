/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IBusiness;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import testclinet.Client;

/**
 *
 * @author nicol
 */
public class FXMLDocumentController implements Initializable {
    
    private static IBusiness business;
    private Client c;
    
    @FXML
    private Label label;
    private TextField test;
    private TextArea area;
    @FXML
    private Button LoginButton;
    @FXML
    private Label lukketIn;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Button createNewAccountButton;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        c = new Client();
    }    
    
    public void injectBusiness(IBusiness business){
        FXMLDocumentController.business = business;
    }

    private void testButton(ActionEvent event) throws IOException {
        area.setText(c.toServer(test.getText()));
        
    }

    @FXML
    private void LoginButtonClicked(ActionEvent event) {
    }

    @FXML
    private void createNewAccountButtonClicked(ActionEvent event) {
    }
    
}
