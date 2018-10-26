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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class BrugerController implements Initializable {

    @FXML
    private ImageView createCaseImage;
    @FXML
    private ImageView logOutImage;
    @FXML
    private ImageView helpImage;
    @FXML
    private ListView<?> userCaseListView;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createCaseImageClicked(MouseEvent event) {
    }

    @FXML
    private void logOutImageClicked(MouseEvent event) {
    }

    @FXML
    private void helpImageClicked(MouseEvent event) {
    }

    @FXML
    private void createCaseBackArrowClicked(MouseEvent event) {
    }

    @FXML
    private void attachFileImageClicked(MouseEvent event) {
    }
    
}
