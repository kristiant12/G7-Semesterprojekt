/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Acquaintance.ICase;
import Acquaintance.ITicket;
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
import javafx.scene.control.Label;
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
    private ListView<ITicket> showTicketsListView;
    @FXML
    private ListView<ICase> showCasesListView;
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
    @FXML
    private AnchorPane replyTicketPane;
    @FXML
    private AnchorPane approveCasePane;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField budgetTextField;
    @FXML
    private TextField deadlineTextField;
    @FXML
    private TextField componentTextField;
    @FXML
    private TextArea informationTextArea;
    @FXML
    private ImageView declineCaseImage;
    @FXML
    private ImageView approveCaseImage;
    // dette er ikke godt vi skal finde en løsning måske objekt
    ObservableList<ICase> cases;
    ObservableList<ITicket> ticketList;
    @FXML
    private Label caseIdLabel;
    @FXML
    private Label ManufacturISCreated;
    @FXML
    private AnchorPane panelPane;
    @FXML
    private ImageView approveCaseBackArrow1;
    @FXML
    private ImageView replyTicketBackArrow;
    @FXML
    private Label TicketID;

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
     
      /**
       * changes anchorpanes by setting the boolean values different
       * @param a anchorpane
       * @param b anchorpane
       * @param c anchorpane
       * @param d  anchorpane
       */
      
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
     /**
  * changes panes between panes, by changing their boolean values
  * @param a one anchorpane
  * @param b another anchorpane
  */
 
    
    public void changePane(AnchorPane b, AnchorPane a){
        a.setDisable(false);
        a.setVisible(true);
        b.setDisable(true);
        b.setVisible(false);
        
    }
      
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    /**
     * Someone else 
     * @param event 
     */

    @FXML
    private void openValidateCasePaneClicked(MouseEvent event) {
        if(event.getTarget() == validateCaseImage){
            change(validateCasePane, ticketsPane, imageBankPane, createManufacturerPane);
            
               try {
            cases = FXCollections.observableArrayList(business.getNotEvaluatetCase());
            showCasesListView.setItems(cases);
         } catch (Exception ex) {

        }
            
            
        }
    }
    /**
     * gets the tickets and changes pane when clicked
     * @param event
     * @throws IOException thrown when IOException occurs
     * @throws ClassNotFoundException IOException thrown when ClassnotfoundException occurs 
     */

    @FXML
    private void openTicketsPaneClicked(MouseEvent event) throws IOException, ClassNotFoundException {
        if(event.getTarget() == ticketsImage){
            change(ticketsPane, validateCasePane, imageBankPane, createManufacturerPane);
             ticketList = FXCollections.observableArrayList(business.getTicketFromServer());
             showTicketsListView.setItems(ticketList);

        }
    }
    /**
     * chnaes screen to imagebank pane
     * @param event 
     */
    
    @FXML
    private void openImageBankPaneClicked(MouseEvent event) {
        if(event.getTarget() == imageBankImage){
            change(imageBankPane, validateCasePane, ticketsPane, createManufacturerPane);
        }
    }
    /**
     * changes pane to create manufacturer by the change method
     * @param event 
     */

    @FXML
    private void openCreateManufacturerPaneClicked(MouseEvent event) {
        if(event.getTarget() == createManufacturerImage){
            change(createManufacturerPane, validateCasePane, imageBankPane, ticketsPane);
        }
    }
    /**
     * does nothing because comment 
     * @param event 
     */
    
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
    
    /**
     * uses business method to create a manufacturer, clears password and username textfield, and sets text to inform that a user has been created. 
     * @param event
     * @throws IOException thrown when an IOException is thrown
     * 
     */
    
    @FXML
    private void createAccountButtonClicked(ActionEvent event) throws IOException {
        //Manufacturer a = new Manufacturer(usernameTextField.getText(), passwordTextField.getText(), null, 0, null, null);
       
        //business.sendUser(a);
        business.createManufactur(usernameTextField.getText(), passwordTextField.getText());
        passwordTextField.clear();
        usernameTextField.clear();
        ManufacturISCreated.setText("User is created");
        
    }
    /**
     * changes the screen to fxmldocument.fxml
     * @param event
     * @throws IOException thrown when an IOException is thrown 
     */
    
    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException{
        changeScreen(event, "FXMLDocument.fxml");
    }
    /**
     * creates a case by setting their paramters in the textfield, 
     * @param event 
     */
    
    @FXML
    private void createCaseButtonClick(ActionEvent event) {
        business.setCase(showCasesListView.getSelectionModel().getSelectedItem());
       // Case a = showCasesListView.getSelectionModel().getSelectedItem();
        titleTextField.setText(business.getCase().getCaseTitle());
        budgetTextField.setText(business.getCase().getCaseBudget());
        deadlineTextField.setText(business.getCase().getDeadline());
        componentTextField.setText(business.getCase().getComponent());
        informationTextArea.setText(business.getCase().getFreeText());
        caseIdLabel.setText(business.getCase().getId());
        changePane(validateCasePane, approveCasePane);
        panelPane.setDisable(true);
    }
    /**
     * deletes case, by businessfacade method, and then removes it in the case observablelsit
     * @param event
     * @throws IOException 
     */
    
    @FXML
    private void deleteCasesButtonClick(ActionEvent event) throws IOException {
        business.deleteCase(showCasesListView.getSelectionModel().getSelectedItem());
        cases.remove(showCasesListView.getSelectionModel().getSelectedItem());
        showCasesListView.setItems(cases);
        
        
    }
    // ved ikke lige hvad det her er, men den kan ikke bruges
    private void nextButtonClick(MouseEvent event) throws IOException {
       
        changePane(replyTicketPane, ticketsPane);
    }
    
    /**
     * submits a ticket by creating a ITicket object and then uses employeereplytekst .
     * @param event
     * @throws IOException thrown when IOException is thrown
     */

    @FXML
    private void submitButtonClick(ActionEvent event) throws IOException {
        ITicket t = showTicketsListView.getSelectionModel().getSelectedItem();
        t.setBackMessage(answerTextArea.getText());
        t.setEmployeeName(business.getUser().getUserName());
        business.employeeReplyTekst(t);
        
        
    }
    /**
     * creates an ITicket object which is used to set the text in the textarea, later changes pane to replyticketpane
     * @param event 
     */
    
    @FXML
    private void nextButtonClick(ActionEvent event) {
        ITicket t = showTicketsListView.getSelectionModel().getSelectedItem();
        TicketID.setText(t.getIssuenumber());
        ticketTextArea.setText(t.getIssueDescription());
        changePane(ticketsPane, replyTicketPane);
    }

    private void validateCaseBackArrowClicked(MouseEvent event) {
    }
    
    
    /**
     * WRONG NAMING, APPROVES A CASE. 
     * @param event
     * @throws IOException thrown when an IOException occurs. 
     */
    
    //denne godkender en Case. det er bare ahmet der har givet forket navn
    @FXML
    private void declineCaseImageClicked(MouseEvent event) throws IOException {
        business.Evaluate(showCasesListView.getSelectionModel().getSelectedItem());
        cases.remove(showCasesListView.getSelectionModel().getSelectedItem());
        showCasesListView.setItems(cases);
    }

    @FXML
    private void approveCaseImageClicked(MouseEvent event){
       
    }
    /**
     * sets panes false,true
     * @param event 
     */
    
    @FXML
    private void approveCaseBackArrowClicked(MouseEvent event) {
        approveCasePane.setDisable(true);
        approveCasePane.setVisible(false);
        validateCasePane.setDisable(false);
        validateCasePane.setVisible(true);
        panelPane.setDisable(false);
    }

    @FXML
    private void replyTicketBackArrowClicked(MouseEvent event) {
        changePane(replyTicketPane, ticketsPane);
    }
    
}
