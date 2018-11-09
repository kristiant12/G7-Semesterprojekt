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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AC
 */
public class TicketController implements Initializable {

    @FXML
    private ListView<?> ticketsListView;
    @FXML
    private TextArea ticketTextArea;
    @FXML
    private ImageView ticketBackArrow;
    @FXML
    private Button createTicketButton;

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

    @FXML
    private void ticketBackArrowClicked(MouseEvent event) throws IOException {
        changeScreen(event, "Support.fxml");
    }

    @FXML
    private void createTicketButtonClicked(ActionEvent event) {
        
    }
    
}
