/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbc;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP-Elitebook
 */
public class LoController implements Initializable {
   @FXML
    private AnchorPane Root;

    @FXML
    private Pane ROOt1;

    @FXML
    private Label Labell;

    @FXML
    private Label lbl2;

    @FXML
    private TextField textpre;

    @FXML
    private TextField txetcon;

    @FXML
    private Button botns;

    @FXML
    private TextField TextDN;
//    @FXML
//    void toSaisires() throws IOException{
//       
//
//Stage stage = new Stage();
//  stage.setTitle("Artificial  Intelligence ");
//
//
//
//                Parent root = FXMLLoader.load(getClass().getResource("Lo.fxml"));
//
//                Scene scene = new Scene(root);
//
//
//                stage.setScene(scene);
//                stage.show();        
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
