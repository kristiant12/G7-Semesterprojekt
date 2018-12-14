/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.IBusiness;
import Business.Admin;
import Business.Customer;
import Business.Employee;
import Business.Manufacturer;

// vi skal se på disse import de bruger 3 lags
//import Business.Employee;





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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author nicol
 */
public class FXMLDocumentController implements Initializable {
    
    private static IBusiness business;
    
    @FXML
    private Label label;
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
    }    
    
        /**
 * changes screen between the panes, forexample, if you want to access another pane, this method should be used.
 * @param event
 * @param a 
 * @throws IOException thrown when an IOException occurs
 */
       private void changeScreen(ActionEvent event, String a) throws IOException{ 
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(screen);
        window.show();
    }
       /**
        * injects business so we can use the methods. 
        * @param business business parameter from IBusiness class
        */
       
    public void injectBusiness(IBusiness business){
        FXMLDocumentController.business = business;
    }

    /**
     * checks if u can login using the instanceof method.
     * @param event
     * @throws ClassNotFoundException thrown when a classnotfound
     * @throws IOException thrown when IOException occurs. 
     */

    @FXML
    private void LoginButtonClicked(ActionEvent event) throws ClassNotFoundException, IOException {
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
        boolean  test = business.logintest(username, password);
        if(test == true){
           if(business.getUser() instanceof Employee){
               changeScreen(event, "Employee.fxml");
           }else if(business.getUser() instanceof Manufacturer){
               changeScreen(event, "Manufacturer.fxml");
           }else if(business.getUser() instanceof Admin){
               changeScreen(event, "Admin.fxml");
           }else if(business.getUser() instanceof Customer){
               changeScreen(event, "Customer.fxml");
           }else{
                         System.out.println("fejl");

           }
        }
        
        
            
        
       
    }

    @FXML
    private void createNewAccountButtonClicked(ActionEvent event) throws IOException {
        changeScreen(event, "Opret.fxml");
    }
    
}
