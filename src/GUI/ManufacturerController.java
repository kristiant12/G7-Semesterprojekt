/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.Case;
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
    private Button confirmButton;
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
    private void auctionImageClicked(MouseEvent event) {
        if(event.getTarget()== auctionImage){
            change(auctionPane, casesPane, profilePane, BidPane);
        }
    }

    @FXML
    private void casesImageClicked(MouseEvent event) {
        if(event.getTarget()== casesImage){
            change(casesPane, auctionPane, profilePane, BidPane);
        }
    }

    @FXML
    private void profileImageClicked(MouseEvent event) {
        if(event.getTarget()== profileImage){
            change(profilePane, auctionPane, casesPane, BidPane);
        }
    }

    @FXML
    private void auctionBackArrowClicked(MouseEvent event) {
    }

    @FXML
    private void casesBackArrowClicked(MouseEvent event) {
    }

    @FXML
    private void saveProfileButtonClicked(ActionEvent event) {
    }

    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "FXMLDocument.fxml");
    }

    @FXML
    private void confirmButtonClicked(ActionEvent event) {
    }

    @FXML
    private void profilePaneBackArrowClicked(MouseEvent event) {
    }

    @FXML
    private void auctionSearchImageClicked(MouseEvent event) {
    }

    @FXML
    private void bidBackArrowClicked(MouseEvent event) {
    }

    private void bidOnCaseClicked(ActionEvent event, Case cs) throws IOException {
                cs.setBid(Double.valueOf(budgetTextField.getText()));
                business.sendCase(cs);
    }

    @FXML
    private void clickedBidButton(ActionEvent event) {
        change(BidPane, auctionPane, casesPane, profilePane);
        Case selected = auctionCasesListView.getSelectionModel().getSelectedItem();
        informationTextArea.setText(selected.getFreeText());
        titleTextField.setText(selected.getCaseTitle());
        deadlineTextField.setText(selected.getDeadline());
        
        defaultCase = selected;
        
    }

    @FXML
    private void bidOnCaseClicked(ActionEvent event) {
        
    }
    
}
