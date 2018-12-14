/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static GUI.Gruppe_7_semesterprojekt.business;

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
    private ImageView createAccountBackArrow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createAccountButtonClicked(ActionEvent event) throws IOException {
//        Customer a = new Customer(usernameTextField.getText(), passwordTextField.getText(), addressTextField.getText(), Integer.parseInt(phoneNumberTextField.getText()), emailTextField.getText(), fullNameTextField.getText());
//        business.sendUser(a);
//        changeScreen1(event, "FXMLDocument.fxml");
// indsæt funktionaliteten i business facaden 
    }
    
    /**
     * changes pane to fxmldocument.fxml
     * @param event
     * @throws IOException thrown when IOException occurs 
     */

    @FXML
    private void createAccountBackArrowClicked(MouseEvent event) throws IOException {
        changeScreen(event, "FXMLDocument.fxml");
            
    }
     private void changeScreen(MouseEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }
     private void changeScreen1(ActionEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }
     
    
}
