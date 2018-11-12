/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Business.Picture;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import static GUI.Gruppe_7_semesterprojekt.business;

/**
 * FXML Controller class
 *
 * @author rober
 */
public class UploadPicturesController implements Initializable {

    @FXML
    private AnchorPane browsePicturesButton;
    @FXML
    private TextField uploadPicsTextfield;
    @FXML
    private Button uploadButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        // TODO
        
       
        
        
    }    

    @FXML
    private void browsePicturesButtonClick(ActionEvent event) {
        
         final FileChooser filechooser = new FileChooser();
        File file  = filechooser.showOpenDialog(null);
        
        if(file != null){
            try{
                openFile(file);
            }catch(Exception e){
                e.printStackTrace();
            }
        
        }
        uploadPicsTextfield.setText(file.getAbsolutePath());
    }
    private void openFile(File file) throws Exception{
        Desktop.getDesktop().open(file);
    }

    @FXML
    private void uploadButtonClick(ActionEvent event) throws IOException {
        business.SendPicture(new Picture());
    }
    
    
    
}
