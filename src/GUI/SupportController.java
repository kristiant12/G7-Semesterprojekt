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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import Business.BusinessFacade;
import Business.Ticket;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import static GUI.Gruppe_7_semesterprojekt.business;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class SupportController implements Initializable {

    @FXML
    private ImageView supportBackArrow;
    @FXML
    private Button createTicketButton;
    
    private BusinessFacade ticket;
    @FXML
    private TextArea issueTextArea;
    
    private Ticket tick;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
         private void changeScreen(MouseEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }
         
         private void changeScreen(ActionEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }

    @FXML
    private void supportBackArrowClicked(MouseEvent event) throws IOException {
        changeScreen(event, "Customer.fxml");
    }

    @FXML
    private void createTicketButtonClicked(ActionEvent event) throws IOException {
        changeScreen(event, "Ticket.fxml");


//        business.sendTicket(new Ticket(issueTextArea.getText()));      
//        issueTextArea.clear();
//        createTicketButton.setOnAction(new EventHandler<ActionEvent>() {
//    public void handle(ActionEvent event)  {
//        Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("Thankyou.fxml"));
//            Stage stage = new Stage();
//            stage.setTitle("My New Stage Title");
//            stage.setScene(new Scene(root, 450, 450));
//            stage.show();
//            // Hide this current window (if this is what you want)
//            ((Node)(event.getSource())).getScene().getWindow().hide();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        
//    }
//        });
                }

}

   
    
    
        
    
    

