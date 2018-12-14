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
    /**
 * changes screen between the panes, forexample, if you want to access another pane, this method should be used.
 * @param event
 * @param a 
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
      * changes pane to createCasePane when the image is clicked
      * @param event
      * @throws IOException thrown when a IOException happens
      */

    @FXML
    private void createCaseImageClicked(MouseEvent event) throws IOException {
        
        changePane(costumerScreen, createCasePane);
        
//        costumerScreen.setVisible(false);
//        createCasePane.setVisible(true);
        
    }
    /**
     * CHanges screen to FXMLDocument.fxml
     * @param event
     * @throws IOException thrown when IOException happens
     */

    @FXML
    private void logOutImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "FXMLDocument.fxml");
    }
    /**
     * changes screeen to support.fxml
    * @param event
    * @throws IOException thrown when IOException occurs.
    */
    @FXML
    private void helpImageClicked(MouseEvent event) throws IOException {
        changeScreen(event, "Support.fxml");
    }
    /**
     * changes pane to customerscreen
     * @param event 
     */

    @FXML
    private void createCaseBackArrowClicked(MouseEvent event) {
        changePane(createCasePane, costumerScreen);
 
    }
    /**
     * in order  to attach file, use the filechooser class and pick showopendialog method, which opens a window u can choose the file in.
     * @param event 
     */
    
    @FXML
    private void attachFileImageClicked(MouseEvent event) {
        
        File inFile = fileChooser.showOpenDialog(null);
        
        
        
    }
    
}
