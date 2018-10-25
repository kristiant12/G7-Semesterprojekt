/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class OpretController implements Initializable {

    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextField confirmPasswordTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField fullNameTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private Button createAccountButton;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createAccountButtonClicked(ActionEvent event) {
    }

    @FXML
    private void backButtonClicked(ActionEvent event) {
    }
    
}
