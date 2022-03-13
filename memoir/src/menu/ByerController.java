/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class ByerController implements Initializable {

    @FXML
    private JFXTextField Bprenom;
    @FXML
    private JFXComboBox<?> ComboEtat;
    @FXML
    private JFXTextField NbValise;
    @FXML
    private JFXTextField Vdarrive;
    @FXML
    private JFXDatePicker DateR;
    @FXML
    private JFXTextField Bnom;
    @FXML
    private JFXTextField Bpassport;
    @FXML
    private JFXComboBox<?> ComboClass;
    @FXML
    private JFXTextField Vdepart;
    @FXML
    private JFXDatePicker DateD;
    @FXML
    private JFXCheckBox Espace;
    @FXML
    private JFXCheckBox CB;
    @FXML
    private JFXCheckBox Visa;
    @FXML
    private JFXCheckBox Check;
    @FXML
    private Label typepayer;
    @FXML
    private JFXTextField Code;
    private AnchorPane panePlane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CheckEvent3(ActionEvent event) {
    }

    @FXML
    private void BtnReserver(ActionEvent event) {
    }

    @FXML
    private void BtnImprimer(ActionEvent event) {
    }

    private void retourPlan(MouseEvent event) throws IOException {
         AnchorPane pane =FXMLLoader.load(getClass().getResource("/Administrateur/admin.fxml"));
            ((Stage)panePlane.getScene().getWindow()).setScene(new Scene(pane));
    }
    
}
