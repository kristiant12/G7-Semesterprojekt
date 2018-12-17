/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IUser;


import static GUI.Gruppe_7_semesterprojekt.business;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author AC
 */
public class AdminController implements Initializable {

    
      ObservableList<IUser> user;
    
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
    private ListView<IUser> usersListView;
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
    /**
     * Creates an employee with the values from textfields
     * @param event is an actionevent
     * @throws IOException when exception
     */
    @FXML
    private void createEmployeeButtonClicked(ActionEvent event) throws IOException {
         business.createEmployee(usernameTextField.getText(), passwordTextField.getText());
        user.add(business.getTing());
        usersListView.setItems(user);

    }
    /**
     * Changes screen method
     * @param event is a mouseevent
     * @param a is a string
     * @throws IOException when exception
     */
    private void changeScreen(MouseEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }
    /**
     * Changes between two panes method
     * @param a is an anchorphane
     * @param b is an anchorpane
     */
        private void change(AnchorPane a, AnchorPane b) {
            a.setDisable(false);
            a.setVisible(true);
            b.setVisible(false);
            b.setDisable(true);
    } 

    /**
     * deletes a user with the click of a button
     * @param event is an actionevent
     * @throws IOException thrown when an IOException occurs
     */
        
    @FXML
    private void deleteUserButtonClicked(ActionEvent event) throws IOException {
       business.deleteUser(usersListView.getSelectionModel().getSelectedItem());
       user.remove(usersListView.getSelectionModel().getSelectedItem());
       usersListView.setItems(user);
    }

    /**
     * logs out with the help of the changeScreen method
     * @param event is a mouseevent
     * @throws IOException thrown when IOException occurs
     */
    
    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "FXMLDocument.fxml");
    }
    
    /**
     * creates an employee also with the help of changin panes 
     * @param event  is a mouseevent
     */

    @FXML
    private void createEmployeeImageClicked(MouseEvent event) {
        change(createEmployeePane, deleteUserPane);
    }
    
    /**
     * deletes a user, tries to get user from the server and sets the new user on the listview again
     * @param event is a mouseevent
     */
    

    @FXML
    private void deleteUserImageClicked(MouseEvent event) {
            try {
          user = FXCollections.observableArrayList(business.getUserFromServer());
            usersListView.setItems(user);
         } catch (Exception ex) {

        }
            change(deleteUserPane, createEmployeePane);
    }

 

    
}
