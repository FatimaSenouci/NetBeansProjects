/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbasef;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class BFController implements Initializable {

    @FXML
    private AnchorPane paneBF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
        void retourBR(MouseEvent event) throws IOException {
          AnchorPane pane =FXMLLoader.load(getClass().getResource("BR.fxml"));
            ((Stage)paneBF.getScene().getWindow()).setScene(new Scene(pane));

    }
    
}
