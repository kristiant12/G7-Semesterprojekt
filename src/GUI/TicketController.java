 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Acquaintance.ITicket;

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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author AC
 */
public class TicketController implements Initializable {

    @FXML
    private ListView<ITicket> ticketsListView;
    @FXML
    private TextArea ticketTextArea;
    @FXML
    private ImageView ticketBackArrow;
    @FXML
    private Button createTicketButton;
    @FXML
    private Button seeTicketsButton;

    private Random rand;
    ObservableList<ITicket> ticket;
    @FXML
    private AnchorPane MainTicketPane;
    @FXML
    private AnchorPane seeInformationPane;
    @FXML
    private Label tickerIdLabel;
    @FXML
    private TextArea InformationTextarea;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rand = new Random();
        // TODO
    }    
    
    /**
     *  change between to fxml documents 
     * @param event is a mouseEvent
     * @param a is a string 
     * @throws IOException 
     */
        private void changeScreen(MouseEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }

    /**
     * change fxml document to Support.fxml
     * @param event is a mouse event 
     * @throws IOException when exception 
     */   
    @FXML
    private void ticketBackArrowClicked(MouseEvent event) throws IOException {
        changeScreen(event, "Support.fxml");
    }
    
    
    /**
     * assigns the ticket with a random ID and sets the items to the ticket.
     * @param event
     * @throws IOException thrown when IOException occurs. 
     */
    
    @FXML
    private void createTicketButtonClicked(ActionEvent event) throws IOException  {
       business.createTicket("Case ID "+rand.nextInt(10000),ticketTextArea.getText(), business.getCustumer());
       ticket.add(business.getTicket());
        ticketsListView.setItems(ticket);

    }
    
    /**
     * creates a listview with a specific custumers tickets 
     * @param event 
     */

    @FXML
    private void seeTicketsButtonAction(ActionEvent event) {
         try {
            ticket = FXCollections.observableArrayList(business.getAllSpecifikCustumerTicket(business.getCustumer()));
            ticketsListView.setItems(ticket);
        
         } catch (Exception ex) {

        }
    }
    /**
     * changes pane
     * @param event 
     */

    @FXML
    private void seeInformationBackButtonClicked(ActionEvent event) {
        changePane(seeInformationPane, MainTicketPane);
    }
    /**
     * changes pane and sets the issuenumber an gets the item.
     * @param event 
     */

    @FXML
    private void seeTicketInformationButtonClicked(ActionEvent event) {
        ITicket a = ticketsListView.getSelectionModel().getSelectedItem();
        tickerIdLabel.setText(a.getIssuenumber());
        InformationTextarea.setText(a.getIssueDescription());
        changePane(MainTicketPane, seeInformationPane);
    }
    
    /**
     * changes pane
     * @param a anchorpane
     * @param b  anchorpane
     */
    
    public void changePane(AnchorPane a,AnchorPane b){
        a.setDisable(true);
        a.setVisible(false);
        b.setDisable(false);
        b.setVisible(true);
    }
}
