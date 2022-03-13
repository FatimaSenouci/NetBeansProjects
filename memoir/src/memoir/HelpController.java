/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoir;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class HelpController implements Initializable {

    @FXML
    private AnchorPane rootHelp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void retourlogin(MouseEvent event) throws IOException {
         AnchorPane pane =FXMLLoader.load(getClass().getResource("/memoir/FXMLDocument.fxml"));
            ((Stage)rootHelp.getScene().getWindow()).setScene(new Scene(pane));

    }

    @FXML
    private void help1(MouseEvent event) throws IOException {
         AnchorPane pane =FXMLLoader.load(getClass().getResource("help1.fxml"));
     ((Stage)rootHelp.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void help2(MouseEvent event) throws IOException {
           AnchorPane pane =FXMLLoader.load(getClass().getResource("help2.fxml"));
     ((Stage)rootHelp.getScene().getWindow()).setScene(new Scene(pane));
    }
    
}
