/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author AC
 */
public class ValidateCaseController implements Initializable {

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
    private ImageView validateCaseBackArrow;
    @FXML
    private ImageView declineCaseImage;
    @FXML
    private ImageView approveCaseImage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        private void changeScreen(ActionEvent event, String a) throws IOException{ 
        Parent parent = FXMLLoader.load(getClass().getResource(a));
        Scene screen = new Scene(parent);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(screen);
        window.show();
    }
    

    @FXML
    private void validateCaseBackArrowClicked(MouseEvent event) {
    }

    @FXML
    private void declineCaseImageClicked(MouseEvent event) {
    }

    @FXML
    private void approveCaseImageClicked(MouseEvent event) {
    }
    
}
