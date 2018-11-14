/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.Case;
import Business.Customer;
import Business.Ticket;
import static GUI.Gruppe_7_semesterprojekt.business;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class EmployeeController implements Initializable {

    @FXML
    private ImageView validateCaseImage;
    @FXML
    private ImageView ticketsImage;
    @FXML
    private ImageView imageBankImage;
    @FXML
    private ImageView createManufacturerImage;
    @FXML
    private AnchorPane validateCasePane;
    @FXML
    private AnchorPane ticketsPane;
    @FXML
    private AnchorPane imageBankPane;
    @FXML
    private AnchorPane createManufacturerPane;
    @FXML
    private ImageView imageBankBackArrow;
    @FXML
    private ImageView validateCaseBackArrow;
    @FXML
    private ListView<?> showTicketsListView;
    @FXML
    private ListView<Case> showCasesListView;
    @FXML
    private ListView<?> imageBankListView;
    @FXML
    private TextField imageBankSearchField;
    @FXML
    private ImageView imageBankSearchButton;
    @FXML
    private ImageView ticketsBackArrow;
    @FXML
    private ImageView createManufacturerBackArrow;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button createAccountButton;
    @FXML
    private ImageView logOutImage;
    @FXML
    private AnchorPane employeePane;
    @FXML
    private Button editCasesButton;
    @FXML
    private Button deleteCasesButton;
    @FXML
    private Button nextButton;
    @FXML
    private TextArea ticketTextArea;
    @FXML
    private TextArea answerTextArea;
    @FXML
    private Button submitButton;

    /**
     * Initializes the controller class.
     */
    
     /**
     * Method to change between FXML documents(scenes)
     */
      private void changeScreen(MouseEvent event, String a) throws IOException{ 
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(screen);
        window.show();
    }
      
    private void change(AnchorPane a, AnchorPane b, AnchorPane c, AnchorPane d) {
            a.setDisable(false);
            a.setVisible(true);
            b.setVisible(false);
            b.setDisable(true);
            c.setVisible(false);
            c.setDisable(true);
            d.setVisible(false);
            d.setDisable(true);
    } 
    
      
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openValidateCasePaneClicked(MouseEvent event) {
        if(event.getTarget() == validateCaseImage){
            change(validateCasePane, ticketsPane, imageBankPane, createManufacturerPane);
            
               try {
            ObservableList<Case> cases = FXCollections.observableArrayList(business.getNotEvaluatetCase());
            showCasesListView.setItems(cases);
         } catch (Exception ex) {

        }
            
            
        }
    }

    @FXML
    private void openTicketsPaneClicked(MouseEvent event) {
        if(event.getTarget() == ticketsImage){
            change(ticketsPane, validateCasePane, imageBankPane, createManufacturerPane);
        }
    }

    @FXML
    private void openImageBankPaneClicked(MouseEvent event) {
        if(event.getTarget() == imageBankImage){
            change(imageBankPane, validateCasePane, ticketsPane, createManufacturerPane);
        }
    }

    @FXML
    private void openCreateManufacturerPaneClicked(MouseEvent event) {
        if(event.getTarget() == createManufacturerImage){
            change(createManufacturerPane, validateCasePane, imageBankPane, ticketsPane);
        }
    }

    @FXML
    private void backArrowTicketsClicked(MouseEvent event) {
        if(event.getTarget() == ticketsBackArrow){
            //change(employeePane, validateCasePane, ticketsPane, createManufacturerPane, imageBankPane);
        }
    }

    @FXML
    private void backArrowCreateManufacturerClicked(MouseEvent event) {
    }

    @FXML
    private void backArrowImageBankClicked(MouseEvent event) {
    }

    @FXML
    private void backArrowValidateCaseClicked(MouseEvent event) {
    }

    @FXML
    private void imageBankSearchButtonClicked(MouseEvent event) {
    }

    @FXML
    private void createAccountButtonClicked(ActionEvent event) {
        
    }

    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException{
        changeScreen(event, "FXMLDocument.fxml");
    }

    @FXML
    private void createCaseButtonClick(ActionEvent event) {
    }

    @FXML
    private void deleteCasesButtonClick(ActionEvent event) {
    }

    private void nextButtonClick(MouseEvent event) throws IOException {
        
        changeScreen(event, "TicketEmployee.fxml");
    }
    public List<Ticket> getTicket(){
        return showCasesListView.get
    }

    @FXML
    private void submitButtonClick(ActionEvent event) {
    }

    @FXML
    private void nextButtonClick(ActionEvent event) {
    }
    
}
