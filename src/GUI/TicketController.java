 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Acquaintance.ICustomer;
import Acquaintance.ITicket;
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
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.List;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.rand = new Random();
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
    private void createTicketButtonClicked(ActionEvent event) throws IOException  {
        
        ticket.add((ITicket)business.createTicket(ticketTextArea.getText(),tickerIdLabel.getText(),(ICustomer) business.getUser()));
        ticketsListView.setItems(ticket);
             //   business.sendTicket(new Ticket(ticketTextArea.getText()));    
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
    

    @FXML
    private void seeTicketsButtonAction(ActionEvent event) {
         try {
            ticket = FXCollections.observableArrayList((ITicket)business.getAllSpecifikCustumerTicket((ICustomer) business.getUser()));
            ticketsListView.setItems(ticket);
        
         } catch (Exception ex) {

        }
    }

    @FXML
    private void seeInformationBackButtonClicked(ActionEvent event) {
        changePane(seeInformationPane, MainTicketPane);
    }

    @FXML
    private void seeTicketInformationButtonClicked(ActionEvent event) {
        ITicket a = ticketsListView.getSelectionModel().getSelectedItem();
        tickerIdLabel.setText(a.getIssuenumber());
        InformationTextarea.setText(a.getIssueDescription());
        changePane(MainTicketPane, seeInformationPane);
    }
    
    public void changePane(AnchorPane a,AnchorPane b){
        a.setDisable(true);
        a.setVisible(false);
        b.setDisable(false);
        b.setVisible(true);
    }
}
