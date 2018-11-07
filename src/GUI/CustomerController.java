/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;


/**
 * FXML Controller class
 *
 * @author rober
 */
public class CustomerController implements Initializable {

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
    private AnchorPane costumerScreen;
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
    
    private FileChooser fileChooser;

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
     
     public void changePane(AnchorPane a, AnchorPane b){
         a.setDisable(true);
         a.setVisible(false);
         b.setDisable(false);
         b.setVisible(true);
     }
     

    @FXML
    private void createCaseImageClicked(MouseEvent event) throws IOException {
        
        changePane(costumerScreen, createCasePane);
        
//        costumerScreen.setVisible(false);
//        createCasePane.setVisible(true);
        
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
    private void createCaseBackArrowClicked(MouseEvent event) {
        changePane(createCasePane, costumerScreen);
 
    }

    @FXML
    private void attachFileImageClicked(MouseEvent event) {
        
        File inFile = fileChooser.showOpenDialog(null);
        
        
        
    }
    
}
