/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IAT;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Message;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class IATController implements Initializable {

    @FXML
    private AnchorPane AnchorMessage;
    @FXML
    private JFXButton sendButton;
    @FXML
    private JFXTextField messageTextField;
    @FXML
    private ComboBox<String> wilaya;
     ObservableList<String> combos=FXCollections.observableArrayList("Oran","Alger"," ","Adrar" ,"Chlef","Laghouat" ,"Oum El Baouaghi","Batna" ,
            "DAAG","DAAJ" ,"DAAK","DAAL" ,"DAAM","DAAN" ,"DAAP","DAAQ" ,"DAAS"
                ,"Bijaia" ,"Biskra","BÃ©char" ,"Blida","Bouira" ,"Tamanrasset","TÃ©bassa" ,"Tlemcen","Tiaret" 
                ,"Tizi Ouzou","Alg" ,"Djelfa","Jijel" ,"SÃ©tife","Saida" ,"Skikda",
            "Sidi Bel AbbÃ©ss","Annaba" ,"Guelma","Constantine" ,"MÃ©dÃ©a","Mostaganem" ,"M'Sila","Ouargla" ,"Oran"
                ,"El Bayadh" ,"Ilizi","Bourdj Bou Arrerridj" ,"BoumerdÃ©s","El Taref" ,"Tindouf","Tissemsilte" ,"El Oued","Khenchela" 
                ,"Souk Ahras","Tipaza" ,"Mila","Ain Defla" ,"Naama","Ain Temouchenet","Ghardaia","Relizan");
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         wilaya.setItems(combos);
        wilaya.setValue("Oran");
        // TODO
    }    

    @FXML
    private void retourMessage(MouseEvent event) throws IOException {
          AnchorPane pane =FXMLLoader.load(getClass().getResource("/Administrateur/admin.fxml"));
     ((Stage)AnchorMessage.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void sendMessage(ActionEvent event) {
        String message = messageTextField.getText();
        Date date = new Date(System.currentTimeMillis());
        
        DBConnection conn = new DBConnection();
        conn.insertMessage(new Message(1, 2, message, date));
    }
   
}
