/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private ListView<?> auctionCasesListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void auctionImageClicked(MouseEvent event) {
    }

    @FXML
    private void casesImageClicked(MouseEvent event) {
    }

    @FXML
    private void profileImageClicked(MouseEvent event) {
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
    private void logOutImageClicked(MouseEvent event) {
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
    
}
