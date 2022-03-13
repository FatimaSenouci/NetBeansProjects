/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrateur;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.reservation;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Reservation1Controller implements Initializable {
     ObservableList<ReservationSetter> reservs = FXCollections.observableArrayList();
 JFXSnackbar errorMsg;
    @FXML
    private JFXTextField Bprenom;
    @FXML
    private JFXComboBox<String> ComboEtat;
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
    private JFXComboBox<String> ComboClass;
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
      ObservableList<String> combo=FXCollections.observableArrayList("Economic","Premium", "Economy","Businus" ," Premier");
    ObservableList<String> comboEtat=FXCollections.observableArrayList("Adult","Child", "Baby");
    @FXML
    private JFXTextField DateD1;
    @FXML
    private JFXTextField ComboEtat1;
    @FXML
    private JFXTextField DateR1;
    @FXML
    private JFXTextField ComboClass1;
 ObservableList<ReservationSetter> reserve = FXCollections.observableArrayList();
    @FXML
    private AnchorPane rootPane;
    @FXML
    private AnchorPane idreserve;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ComboClass.setItems(combo);
        ComboClass.setValue("Economic");
        ComboEtat.setItems(comboEtat);
           ComboEtat.setValue("Adult");
            
        // TODO
     Bpassport.textProperty().addListener(new ChangeListener<String>() { // TextField Accept only Number
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    Bpassport.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        NbValise.textProperty().addListener(new ChangeListener<String>() { // TextField Accept only Number
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                   NbValise.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
       Code.textProperty().addListener(new ChangeListener<String>() { // TextField Accept only Number
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                   Code.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
       Bnom.textProperty().addListener(new ChangeListener<String>() { // TextField Accept only Number
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\D*")) {
                    Bnom.setText(newValue.replaceAll("[^\\D]", ""));
                }
            }
        });
        Bprenom.textProperty().addListener(new ChangeListener<String>() { // TextField Accept only Number
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\D*")) {
                    Bprenom.setText(newValue.replaceAll("[^\\D]", ""));
                }
            }
        });
        
        
         String[] possiblewordsSet = {" ","Adrar" ,"Chlef","Laghouat" ,"Oum El Baouaghi","Batna" ,
            "DAAG","DAAJ" ,"DAAK","DAAL" ,"DAAM","DAAN" ,"DAAP","DAAQ" ,"DAAS"
                ,"Bijaia" ,"Biskra","BÃ©char" ,"Blida","Bouira" ,"Tamanrasset","TÃ©bassa" ,"Tlemcen","Tiaret" 
                ,"Tizi Ouzou","Alg" ,"Djelfa","Jijel" ,"SÃ©tife","Saida" ,"Skikda",
            "Sidi Bel AbbÃ©ss","Annaba" ,"Guelma","Constantine" ,"MÃ©dÃ©a","Mostaganem" ,"M'Sila","Ouargla" ,"Oran"
                ,"El Bayadh" ,"Ilizi","Bourdj Bou Arrerridj" ,"BoumerdÃ©s","El Taref" ,"Tindouf","Tissemsilte" ,"El Oued","Khenchela" 
                ,"Souk Ahras","Tipaza" ,"Mila","Ain Defla" ,"Naama","Ain Temouchenet","Ghardaia","Relizan" };
            TextFields.bindAutoCompletion(Vdarrive, possiblewordsSet);
        
        String[] possiblewordsSet2 = {" ","Adrar" ,"Chlef","Laghouat" ,"Oum El Baouaghi","Batna" ,
            "DAAG","DAAJ" ,"DAAK","DAAL" ,"DAAM","DAAN" ,"DAAP","DAAQ" ,"DAAS"
                ,"Bijaia" ,"Biskra","BÃ©char" ,"Blida","Bouira" ,"Tamanrasset","TÃ©bassa" ,"Tlemcen","Tiaret" 
                ,"Tizi Ouzou","Alg" ,"Djelfa","Jijel" ,"SÃ©tife","Saida" ,"Skikda",
            "Sidi Bel AbbÃ©ss","Annaba" ,"Guelma","Constantine" ,"MÃ©dÃ©a","Mostaganem" ,"M'Sila","Ouargla" ,"Oran"
                ,"El Bayadh" ,"Ilizi","Bourdj Bou Arrerridj" ,"BoumerdÃ©s","El Taref" ,"Tindouf","Tissemsilte" ,"El Oued","Khenchela" 
                ,"Souk Ahras","Tipaza" ,"Mila","Ain Defla" ,"Naama","Ain Temouchenet","Ghardaia","Relizan" };
            TextFields.bindAutoCompletion(Vdepart, possiblewordsSet2);
    
                try{
            
            Connection con = null;
            
            String sql = "SELECT * FROM reservation "; 
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rss = ps.executeQuery();
            
            while(rss.next()){
                
                reserve.add(new ReservationSetter(rss.getString(1),rss.getString(2),rss.getString(3),rss.getString(4),rss.getString(5),rss.getString(6),rss.getString(7),rss.getString(8),rss.getString(9),rss.getString(10)));
            }
//           con.close();   
        }catch(Exception e){
            e.printStackTrace();
        }
       
        errorMsg= new JFXSnackbar(rootPane);
    
    
    
    
    }    

    @FXML
    private void OnReserve(ActionEvent event) {
        ComboEtat1.setText(ComboEtat.getValue().toString());
           ComboClass1.setText(ComboClass.getValue().toString());
           DateD1.setText(DateD.getValue().toString());
          DateR1.setText(DateR.getValue().toString());
           reservation reserve = new reservation();
        
        reserve.setBnom(Bnom.getText());
         reserve.setBprenom(Bprenom.getText());
          reserve.setComboEtat1(ComboEtat1.getText());
           reserve.setComboClass1(ComboClass1.getText());
            reserve.setNbValise(NbValise.getText());
             reserve.setVdarrive(Vdarrive.getText());
              reserve.setVdepart(Vdepart.getText());
              reserve.setBpassport(Bpassport.getText());
               reserve.setDateD1(DateD1.getText());
                reserve.setDateR1(DateR1.getText());
                 new  DBConnection().insertReserve(reserve);
        reservs.clear();
    }

    @FXML
    private void retour3(MouseEvent event) throws IOException {
          AnchorPane pane =FXMLLoader.load(getClass().getResource("admin.fxml"));
     ((Stage)rootPane.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void Onprint(ActionEvent event) {
        print(idreserve);
    }
      private void print(Node node) {

    javafx.print.PrinterJob job = javafx.print.PrinterJob.createPrinterJob();
    if (job != null) {

      boolean printed = job.printPage(node);
      if (printed) {
        job.endJob();
      } else {
      }
    } else {
    }
     } 
}
