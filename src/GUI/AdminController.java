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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author AC
 */
public class AdminController implements Initializable {

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
    private void createEmployeeButtonClicked(ActionEvent event) {
    }

    @FXML
    private void deleteUserButtonClicked(ActionEvent event) {
    }

    @FXML
    private void logOutImageClicked(MouseEvent event) {
    }

    @FXML
    private void createEmployeeImageClicked(MouseEvent event) {
    }

    @FXML
    private void deleteUserImageClicked(MouseEvent event) {
    }
    
}
