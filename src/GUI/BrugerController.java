/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.Case;
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

/**
 * FXML Controller class
 *
 * @author sebastian
 */
public class BrugerController implements Initializable {

    @FXML
    private AnchorPane costumerScreen;
    @FXML
    private ListView<?> userCaseListView;
    @FXML
    private ImageView createCaseImage;
    @FXML
    private ImageView logOutImage;
    @FXML
    private ImageView helpImage;
    @FXML
    private Button createCaseButton;
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
    @FXML
    private Button supportButton;

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
    private void createCaseImageClicked(MouseEvent event) {
        costumerScreen.setVisible(false);
        createCasePane.setVisible(true);
    }

    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "FXMLDocument.fxml");
    }

    @FXML
    private void helpImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "Support.fxml");
    }

    @FXML
    private void createCaseButtonClick(ActionEvent event) throws IOException {
        String caseTitle = titleTextField.getText();
        String caseBudget = budgetTextField.getText();
        String component = componentTextField.getText();
        String deadline = deadlineTextField.getText();
        String freeText = informationTextArea.getText();
        int caseIDint = (int)(Math.random() * 50 + 1);
        String caseID = Integer.toString(caseIDint);

        business.createCase(caseTitle, caseID, caseBudget, deadline, component, true, freeText);
        
    }

    @FXML
    private void editCasesButtonClick(ActionEvent event) throws IOException {
        // DET HER SKAL LAVES OM SÅDAN AT DEN TAGER FRA EDIT CASE SKÆRMEN
        String caseTitle = titleTextField.getText();
        String caseBudget = budgetTextField.getText();
        String component = componentTextField.getText();
        String deadline = deadlineTextField.getText();
        String freeText = informationTextArea.getText();
        int caseIDint = (int)(Math.random() * 50 + 1);
        String caseID = Integer.toString(caseIDint);
        
        business.modifyCase(caseTitle, caseID, caseBudget, deadline, component, true, freeText);
    }

    @FXML
    private void deleteCasesButtonClick(ActionEvent event) throws IOException {
//        //adapter skal fixes
//        business.deleteCase((Case) userCaseListView.getSelectionModel().getSelectedItem());
//        caseArray.addAll((Collection<? extends Object>) userCaseListView);
//        caseArray.remove(userCaseListView.getSelectionModel().getSelectedItem());
//        //adapter = new ListAdapter(userCaseListView, Object);
        
    }

    @FXML
    private void createCaseBackArrowClicked(MouseEvent event) {
    }

    @FXML
    private void attachFileImageClicked(MouseEvent event) {
    }

    @FXML
    private void supportButtonClick(MouseEvent event) throws IOException {
        changeScreen(event, "Support.fxml");
    }
   
}
//