/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IUser;

import Business.Employee;

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

    @FXML
    private void createEmployeeButtonClicked(ActionEvent event) throws IOException {
//        Employee a = new Employee(usernameTextField.getText(),passwordTextField.getText()); 
//        business.sendUser(a);
//        user.add(a)
//        usersListView.setItems(user);
//Fix det her, functionalitet skal flyttes til business facaden
        
         

    }

    private void changeScreen(MouseEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }
    
        private void change(AnchorPane a, AnchorPane b) {
            a.setDisable(false);
            a.setVisible(true);
            b.setVisible(false);
            b.setDisable(true);
    } 

    @FXML
    private void deleteUserButtonClicked(ActionEvent event) throws IOException {
       business.deleteUser( usersListView.getSelectionModel().getSelectedItem());
       user.remove(usersListView.getSelectionModel().getSelectedItem());
       usersListView.setItems(user);
    }

    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "FXMLDocument.fxml");
    }

    @FXML
    private void createEmployeeImageClicked(MouseEvent event) {
        change(createEmployeePane, deleteUserPane);
    }

    @FXML
    private void deleteUserImageClicked(MouseEvent event) {
            try {
                //virker nok ikke og skal laves om i client/server delen
          user = FXCollections.observableArrayList((IUser)business.getUserFromServer());
            usersListView.setItems(user);
         } catch (Exception ex) {

        }
            change(deleteUserPane, createEmployeePane);
    }

 

    
}
