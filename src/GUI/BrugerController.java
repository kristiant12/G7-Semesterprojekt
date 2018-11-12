/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.Case;
import Business.Customer;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static GUI.Gruppe_7_semesterprojekt.business;
import java.util.ArrayList;
import java.util.Collection;
import jdk.nashorn.internal.runtime.ListAdapter;
import java.lang.Object;
import java.util.Observable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class BrugerController implements Initializable {

    @FXML
    private AnchorPane costumerScreen;
    @FXML
    //private ListView<String> userCaseListView;
    ListView<Case> userCaseListView = new ListView<>();
    @FXML
    private ImageView createCaseImage;
    @FXML
    private ImageView logOutImage;
    @FXML
    private ImageView helpImage;
    @FXML
    private Button editCasesButton;
    @FXML
    private Button deleteCasesButton;
    @FXML
    private AnchorPane createCasePane;
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
    private ImageView createCaseBackArrow;
    @FXML
    private ImageView attachFileImage;
    
    ListAdapter adapter;
    ArrayList<Object> caseArray;

    ObservableList<Case> caseList =FXCollections.observableArrayList ();
    @FXML
    private Button createCaseButton;
    
    private Random rand;
    @FXML
    private Label SagOprettet;
    @FXML
    private AnchorPane seeCasePane;
    @FXML
    private Label caseIdLabel;
    
    @FXML
    private Button backButton;
    @FXML
    private TextField seeTitleTextfield;
    @FXML
    private TextField seeBudgetTextField;
    @FXML
    private TextField seeDeadlineTextfield;
    @FXML
    private TextField seeComponentTextField;
    @FXML
    private TextArea seeFreeTextTextField;
    
    /**
     * Initializes the controller class.
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
//        try {
//            ObservableList<Case> cases = FXCollections.observableArrayList(business.getUserCaseList(business.getUser()));
//            userCaseListView.setItems(cases);
//         } catch (Exception ex) {
//
//        }
//    
    
    rand = new Random();
    }    
 private void changeScreen(MouseEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }
  public void changePane(AnchorPane a, AnchorPane b){
         a.setDisable(true);
         a.setVisible(false);
         b.setDisable(false);
         b.setVisible(true);
     }
  
    @FXML
    private void createCaseImageClicked(MouseEvent event) {
        changePane(costumerScreen, createCasePane);
//        costumerScreen.setVisible(false);
//        createCasePane.setVisible(true);
//        userCaseListView.setItems(caseList);
    }

    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException {
//         userCaseListView.setItems(null);
//         business.setUser(null);
        userCaseListView = null;
        changeScreen(event, "FXMLDocument.fxml");
          }

    @FXML
    private void helpImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "Support.fxml");
    }
//
//    private void createCaseButtonClick(ActionEvent event) throws IOException {
//        String caseTitle = titleTextField.getText();
//        String caseBudget = budgetTextField.getText();
//        String component = componentTextField.getText();
//        String deadline = deadlineTextField.getText();
//        String freeText = informationTextArea.getText();
//        int caseIDint = (int)(Math.random() * 50 + 1);
//        String caseID = Integer.toString(caseIDint);
//
//        business.createCase(caseTitle, caseID, caseBudget, deadline, component, true, freeText);
//        
//    }

    @FXML
    private void editCasesButtonClick(ActionEvent event) throws IOException {
        // DET HER SKAL LAVES OM SÅDAN AT DEN TAGER FRA EDIT CASE SKÆRMEN
        
        Case test = userCaseListView.getSelectionModel().getSelectedItem();
        caseIdLabel.setText(test.getId());
        seeBudgetTextField.setText(test.getCaseBudget());
        seeComponentTextField.setText(test.getComponent());
        seeDeadlineTextfield.setText(test.getDeadline());
        seeFreeTextTextField.setText(test.getFreeText());
        seeTitleTextfield.setText(test.getCaseTitle());
        changePane(costumerScreen, seeCasePane);

        
//        String caseTitle = titleTextField.getText();
//        String caseBudget = budgetTextField.getText();
//        String component = componentTextField.getText();
//        String deadline = deadlineTextField.getText();
//        String freeText = informationTextArea.getText();
//        int caseIDint = (int)(Math.random() * 50 + 1);
//        String caseID = Integer.toString(caseIDint);
//        
//        business.modifyCase(caseTitle, caseID, caseBudget, deadline, component, true, freeText);
    }

    @FXML
    private void deleteCasesButtonClick(ActionEvent event) throws IOException {

        business.deleteCase((Case) userCaseListView.getSelectionModel().getSelectedItem());
        caseList.remove(userCaseListView.getSelectionModel().getSelectedItem());
        userCaseListView.getItems().clear();
        userCaseListView.setItems(caseList);
        
    }

    @FXML
    private void createCaseBackArrowClicked(MouseEvent event) {
        
        changePane(createCasePane, costumerScreen);
        SagOprettet.setText("");
    }

    @FXML
    private void attachFileImageClicked(MouseEvent event) {
    }

    private void supportButtonClick(MouseEvent event) throws IOException {
        changeScreen(event, "Support.fxml");
    }


    @FXML
    private void createCaseButtonClick(ActionEvent event) throws IOException {

        business.sendMapOfUserAndCases(new Case(titleTextField.getText(),"Case ID "+rand.nextInt(10000),budgetTextField.getText(), deadlineTextField.getText(), componentTextField.getText(),false, informationTextArea.getText()));
        titleTextField.clear();
        budgetTextField.clear();
        deadlineTextField.clear();
        componentTextField.clear();
        informationTextArea.clear();
        SagOprettet.setText("Case created");
        
    }
    @FXML
    private void testuttonClicked(ActionEvent event) {
            try {
            ObservableList<Case> cases = FXCollections.observableArrayList(business.getUserCaseList2((Customer) business.getUser()));
            userCaseListView.setItems(cases);
         } catch (Exception ex) {

        }
//    
    }

    @FXML
    private void seeCaseBackButtonClicked(ActionEvent event) {
        changePane(seeCasePane, costumerScreen);
    }

    @FXML
    private void saveDataButtonClicked(ActionEvent event) throws IOException {
        business.modifyCase(new Case(seeTitleTextfield.getText(), caseIdLabel.getText(), seeBudgetTextField.getText(), seeDeadlineTextfield.getText(), seeComponentTextField.getText(), false, seeFreeTextTextField.getText()));
    
    }
    
    
    
    
   
}
