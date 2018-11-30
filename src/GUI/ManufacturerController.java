/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.Case;
import Business.Customer;
import Business.Manufacturer;
import static GUI.Gruppe_7_semesterprojekt.business;
import java.io.IOException;
import java.net.URL;
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
public class ManufacturerController implements Initializable {

    @FXML
    private ImageView auctionImage;
    @FXML
    private ImageView casesImage;
    @FXML
    private ImageView profileImage;
    @FXML
    private AnchorPane auctionPane;
    @FXML
    private ImageView auctionBackArrow;
    @FXML
    private AnchorPane casesPane;
    @FXML
    private ImageView casesBackArrow;
    @FXML
    private AnchorPane profilePane;
    @FXML
    private Button saveProfileButton;
    @FXML
    private ImageView logOutImage;
    @FXML
    private TextField firmNameTextField;
    @FXML
    private TextField firmNumberTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField newPasswordTextField;
    @FXML
    private TextField repeatPasswordTextField;
    @FXML
    private TextField firmAddressTextField;
    @FXML
    private ImageView profilePaneBackArrow;
    @FXML
    private TextField auctionSearchTextField;
    @FXML
    private ImageView auctionSearchImage;
    @FXML
    private ListView<?> casesListView;
    @FXML
    private ListView<Case> auctionCasesListView;
    @FXML
    private ImageView bidBackArrow;
    @FXML
    private TextArea informationTextArea;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField budgetTextField;
    @FXML
    private TextField deadlineTextField;
    @FXML
    private TextField ComponentTextField;
    @FXML
    private TextField bidAmountTextField;
    @FXML
    private Button bidOnCase;
    @FXML
    private Button bidButton;
    @FXML
    private AnchorPane BidPane;
    private Case defaultCase;
    ObservableList<Case> relevantcases;
    ObservableList<Case> relevantcasesSearch = FXCollections.observableArrayList();
    @FXML
    private Button openCaseButton;
    @FXML
    private TextArea caseTextArea;
    @FXML
    private TextField titleTextfield;
    @FXML
    private TextField caseIdTextfield;
    @FXML
    private TextField budgetTextfield;
    @FXML
    private TextField deadlineTextfield;
    @FXML
    private TextField bidTextfield;
    @FXML
    private TextField componentTextfield;
    @FXML
    private AnchorPane viewCaseInfoPane;
    @FXML
    private Button seeCasesButton;
    
    private ObservableList<Case> cases;
    @FXML
    private ImageView viewCaseInfoBackArrow;
    @FXML
    private AnchorPane panelPane;

    /**
     * Initializes the controller class.
     */
    
        private void changeScreen(MouseEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }
    
    private void change(AnchorPane a, AnchorPane b, AnchorPane c, AnchorPane d, AnchorPane e) {
            a.setDisable(false);
            a.setVisible(true);
            b.setVisible(false);
            b.setDisable(true);
            c.setVisible(false);
            c.setDisable(true);
            d.setVisible(false);
            d.setDisable(true);
            e.setVisible(false);
            e.setDisable(true);
            
          
    } 
    private void changeTwo(AnchorPane a, AnchorPane b){
        
        a.setDisable(true);
        a.setVisible(false);
        b.setDisable(false);
        b.setVisible(true);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void auctionImageClicked(MouseEvent event) throws IOException, ClassNotFoundException {
        if(event.getTarget()== auctionImage){
            change(auctionPane, casesPane, profilePane, BidPane, viewCaseInfoPane);
       try{
            relevantcases = FXCollections.observableArrayList(business.getEvaluatetList());
            auctionCasesListView.setItems(relevantcases);
            }
      catch(Exception e){
                
        }
        }
    }

    @FXML
    private void casesImageClicked(MouseEvent event) {
        if(event.getTarget()== casesImage){
            change(casesPane, auctionPane, profilePane, BidPane, viewCaseInfoPane);
        }
    }

    @FXML
    private void profileImageClicked(MouseEvent event) {
        if(event.getTarget()== profileImage){
            change(profilePane, auctionPane, casesPane, BidPane, viewCaseInfoPane);
            firmNumberTextField.setText(business.getManufactor().getNumber()+"");
            newPasswordTextField.setText(business.getManufactor().getPassword());
            firmAddressTextField.setText(business.getManufactor().getFirmaddress());
            firmNameTextField.setText(business.getManufactor().getFirmaName());
            emailTextField.setText(business.getManufactor().getFirmaMail());
            
        }
    }

    @FXML
    private void auctionBackArrowClicked(MouseEvent event) {
//                if(event.getTarget()== auctionBackArrow){
//            change(profilePane, casesPane, BidPane,auctionPane, viewCaseInfoPane);
//        }
    }

    @FXML
    private void casesBackArrowClicked(MouseEvent event) {
//        if(event.getTarget()== casesBackArrow){
//            change(profilePane, casesPane, BidPane,auctionPane, viewCaseInfoPane);
//        }
    }

    @FXML
    private void saveProfileButtonClicked(ActionEvent event) throws IOException {
       if(newPasswordTextField.getText().equalsIgnoreCase(repeatPasswordTextField.getText())){
     // virker ikke lige nu 
        int number = Integer.parseInt(firmNumberTextField.getText());
       business.updateManufactor(new Manufacturer(repeatPasswordTextField.getText(), business.getUser().getUserName(), firmAddressTextField.getText(), number, firmNameTextField.getText(),emailTextField.getText()));
       }
    }

    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "FXMLDocument.fxml");
    }


    @FXML
    private void profilePaneBackArrowClicked(MouseEvent event) {
    }

    @FXML
    private void auctionSearchImageClicked(MouseEvent event) {
//        for(int i = 0; i < relevantcases.lastIndexOf(defaultCase); i++){
//            boolean equalsIgnoreCase = relevantcases.get(i).getCaseTitle().equalsIgnoreCase(auctionSearchTextField.getText());
//            if (equalsIgnoreCase = true){
//                relevantcasesSearch.add(relevantcases.get(i));
//            }
//        }
//        auctionCasesListView.getItems().clear();
//        auctionCasesListView.setItems(relevantcasesSearch);
    }

    @FXML
    private void bidBackArrowClicked(MouseEvent event) {
        changeTwo(BidPane, auctionPane);
    }

    @FXML
    private void bidOnCaseClicked(ActionEvent event) throws IOException {
               business.registerBid(defaultCase, Double.valueOf(budgetTextField.getText()));
               
    }

    @FXML
    private void clickedBidButton(ActionEvent event) {
        change(BidPane, auctionPane, casesPane, profilePane, viewCaseInfoPane);
        Case selected = auctionCasesListView.getSelectionModel().getSelectedItem();
        informationTextArea.setText(selected.getFreeText());
        titleTextField.setText(selected.getCaseTitle());
        deadlineTextField.setText(selected.getDeadline());
        budgetTextField.setText(selected.getCaseBudget());
        componentTextfield.setText(selected.getComponent());
        
        //defaultCase = selected;
        
    }

    @FXML
    private void openCaseButtonClicked(ActionEvent event) {
         
        changeTwo(casesPane, viewCaseInfoPane);
        panelPane.setDisable(true);
    }

    @FXML
    private void seeCasesButtonClick(ActionEvent event) {
        
        try{
             cases = FXCollections.observableArrayList();
            auctionCasesListView.setItems(cases);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    private void viewCaseInfoBackArrowClicked(MouseEvent event) {
        changeTwo(viewCaseInfoPane, casesPane);
        panelPane.setDisable(false);
    }


  
}
