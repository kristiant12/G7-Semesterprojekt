/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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
    private ListView<?> showCasesListView;
    @FXML
    private ListView<?> imageBankListView;
    @FXML
    private TextField imageBankSearchField;
    @FXML
    private ImageView imageBankSearchButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openValidateCasePaneClicked(MouseEvent event) {
        if(event.getTarget() == validateCaseImage){
            validateCasePane.setVisible(true);
        }
    }

    @FXML
    private void openTicketsPaneClicked(MouseEvent event) {
        if(event.getTarget() == ticketsImage){
            ticketsPane.setVisible(true);
        }
    }

    @FXML
    private void openImageBankPaneClicked(MouseEvent event) {
    }

    @FXML
    private void openCreateManufacturerPaneClicked(MouseEvent event) {
    }

    @FXML
    private void backArrowTicketsClicked(MouseEvent event) {
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
    
}
