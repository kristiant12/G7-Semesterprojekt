/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Acquaintance.ICase;
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
import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.ListAdapter;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class BrugerController implements Initializable {

    @FXML
    private AnchorPane costumerScreen;
    @FXML
    ListView<ICase> userCaseListView = new ListView<>();
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

    ObservableList<ICase> cases;
            
    ObservableList<ICase> caseList = FXCollections.observableArrayList ();
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
    private TextField seeTitleTextfield;
    @FXML
    private TextField seeBudgetTextField;
    @FXML
    private TextField seeDeadlineTextfield;
    @FXML
    private TextField seeComponentTextField;
    @FXML
    private TextArea seeFreeTextTextField;
    @FXML
    private ImageView seeCaseBackArrow;
    
    /**
     * Initializes the controller class.
     */
    @Override
public void initialize(URL url, ResourceBundle rb) {
   rand = new Random();
    }    

/**
 * changes screen between the panes, forexample, if you want to access another pane, this method should be used.
 * @param event is a mouseevent
 * @param a is a String
 * @throws IOException thrown when an IOException occurs
 */

 private void changeScreen(MouseEvent event, String a) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(screen);
        window.show();
    }
 
 /**
  * changes panes between panes, by changing their boolean values
  * @param a one anchorpane
  * @param b another anchorpane
  */
 
  public void changePane(AnchorPane a, AnchorPane b){
         a.setDisable(true);
         a.setVisible(false);
         b.setDisable(false);
         b.setVisible(true);
     }
  /**
   * changes pane when this button is clicked
   * @param event is a mouseevent
   */
  
    @FXML
    private void createCaseImageClicked(MouseEvent event) {
        changePane(costumerScreen, createCasePane);
    }
    /**
     * sets the listview to null, and changes screen
     * @param event mouseevent
     * @throws IOException thrown when IOException occurs
     */

    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException {
        userCaseListView = null;
        changeScreen(event, "FXMLDocument.fxml");
          }

    /**
     * changes screen to support.fxml
     * @param event is a mouseevent
     * @throws IOException thrown when IOException occurs
     */
    
    @FXML
    private void helpImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "Support.fxml");
    }
    
    /**
     * edits  case when this button is clicked
     * @param event is an actionevent
     * @throws IOException thrown when IOException occurs
     */
    
    @FXML
    private void editCasesButtonClick(ActionEvent event) throws IOException {
        business.setCase(userCaseListView.getSelectionModel().getSelectedItem());
        caseIdLabel.setText(business.getCase().getId());
        seeBudgetTextField.setText(business.getCase().getCaseBudget());
        seeComponentTextField.setText(business.getCase().getComponent());
        seeDeadlineTextfield.setText(business.getCase().getDeadline());
        seeFreeTextTextField.setText(business.getCase().getFreeText());
        seeTitleTextfield.setText(business.getCase().getCaseTitle());
        changePane(costumerScreen, seeCasePane);

}
    /**
     * deletes the selected items in the listview
     * @param event is an actionevent
     * @throws IOException thrown when an IOexception occurs
     */
   
    @FXML
    private void deleteCasesButtonClick(ActionEvent event) throws IOException {

        business.deleteCase( userCaseListView.getSelectionModel().getSelectedItem());
        cases.remove(userCaseListView.getSelectionModel().getSelectedItem());
        userCaseListView.setItems(cases);
       
        
    }
    
    /**
     * changes screen
     * @param event is a mouseevent
     */

    @FXML
    private void createCaseBackArrowClicked(MouseEvent event) {
        
        changePane(createCasePane, costumerScreen);
        SagOprettet.setText("");
    }
    /**
     * attaches, doesnt work.
     * @param event 
     */

    @FXML
    private void attachFileImageClicked(MouseEvent event) {
        
        if(attachFileImage.isPressed()){
             final FileChooser filechooser = new FileChooser();
        File file  = filechooser.showOpenDialog(null);
        
        if(file != null){
            try{
                openFile(file);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        }
        
    }

     private void openFile(File file) throws Exception{
        Desktop.getDesktop().open(file);
    }
     /**
      * Changes screen to support screen
      * @param event is a mouseevent
      * @throws IOException when exception
      */
    private void supportButtonClick(MouseEvent event) throws IOException {
        changeScreen(event, "Support.fxml");
    }

    /**
     * Creates case using businessfacade method and clears all textfields. 
     * @param event actionevent
     * @throws IOException thrown when IOException occurs.
     */

    @FXML
    private void createCaseButtonClick(ActionEvent event) throws IOException {
          business.createCase(titleTextField.getText(),"Case ID "+rand.nextInt(10000),budgetTextField.getText(), deadlineTextField.getText(), componentTextField.getText(),false, informationTextArea.getText());

        titleTextField.clear();
        budgetTextField.clear();
        deadlineTextField.clear();
        componentTextField.clear();
        informationTextArea.clear();
        SagOprettet.setText("Case created");
        cases.add(business.getCase());
        userCaseListView.setItems(cases);
        
    }
    /**
     * Adds cases for a user to a list
     * @param event is an actionevent
     */
    
    @FXML
    private void testuttonClicked(ActionEvent event) {
            try {
            cases = FXCollections.observableArrayList(business.getUserCaseList(business.getUser()));
            userCaseListView.setItems(cases);
         } catch (Exception ex) {
             ex.printStackTrace();
        }
    }
    /**
     * Saves the data, by the modify method
     * @param event is an actionevent
     * @throws IOException thrown when IOException happens. 
     */

    @FXML
    private void saveDataButtonClicked(ActionEvent event) throws IOException {
       business.modifyCase(seeTitleTextfield.getText(), business.getCase().getId(), seeBudgetTextField.getText(), seeDeadlineTextfield.getText(), seeComponentTextField.getText(), business.getCase().getEvaluated(), seeFreeTextTextField.getText());
    
    }
    /**
     * changes pane to customer screen
     * @param event is a mouseevent
     */

    @FXML
    private void seeCaseBackArrowClicked(MouseEvent event) {
        changePane(seeCasePane, costumerScreen);
    }

    
        
    
    
}
