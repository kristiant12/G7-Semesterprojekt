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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static GUI.Gruppe_7_semesterprojekt.business;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author AC
 */
public class BidController implements Initializable {

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
    private void bidBackArrowClicked(MouseEvent event) throws IOException {
        changeScreen(event, "Manufacturer.fxml");
    }
    private void bidOncase(MouseEvent event, Case cs) throws IOException {
        cs.setBid(Double.valueOf(budgetTextField.getText()));
        business.sendCase(cs);
    }

    @FXML
    private void bidOnCaseClicked(ActionEvent event) {
    }
}
