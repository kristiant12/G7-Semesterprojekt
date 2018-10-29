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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AC
 */
public class AdminController implements Initializable {

    private static IBusiness business;
    
    @FXML
    private AnchorPane createEmployeePane;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button createEmployeeButton;
    @FXML
    private AnchorPane deleteUserPane;
    @FXML
    private ListView<?> usersListView;
    @FXML
    private Button deleteUserButton;
    @FXML
    private ImageView logOutImage;
    @FXML
    private ImageView createEmployeeImage;
    @FXML
    private ImageView deleteUserImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void createEmployeeButtonClicked(ActionEvent event) throws IOException {

        createEmployeePane.setVisible(true);
        business.createEmployee(passwordTextField.getText(), usernameTextField.getText());
        
         

    }

    private void changeScreen(MouseEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }

    @FXML
    private void deleteUserButtonClicked(ActionEvent event) {
       deleteUserPane.setVisible(true);
       
    }

    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "FXMLDocumentController.java");
    }

    
}
