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
import static dao.DBConnection.con;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.stream.IntStream;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCharacterCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.reservation;
//import model.ReservationSetter;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class ReservationController implements Initializable {
     JFXSnackbar errorMsg;

    @FXML
    private JFXTextField Bprenom;
    //@FXML
    //private JFXComboBox<?> ComboEtat;
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
    private JFXTextField Code;
    @FXML
    private Label typepayer;

    ObservableList<ReservationSetter> reserve = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<String> ComboEtat;
    @FXML
    private JFXComboBox<String> ComboClass;
    private AnchorPane rootPane123;
    private JFXTextField VilleD;
    
    ObservableList<String> combo=FXCollections.observableArrayList("Economic","Premium", "Economy","Businus" ," Premier");
    ObservableList<String> comboEtat=FXCollections.observableArrayList("Adult","Child", "Baby");

    @FXML
    private JFXTextField ComboClass1;
    @FXML
    private JFXTextField ComboEtat1;
    ObservableList<reservation> reservs = FXCollections.observableArrayList();
    @FXML
    private AnchorPane panePlane;
    
    public void initialize(URL url, ResourceBundle rb) {
        ComboClass.setItems(combo);
        ComboClass.setValue("Economic");
        ComboEtat.setItems(comboEtat);
//         ComboClass.getItems().addAll("Admin", "Controller");
//           ComboEtat.getItems().addAll("fffff", "hhhhhh");
        
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
            TextFields.bindAutoCompletion(VilleD, possiblewordsSet2);
        
          
        
        
        
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
       
        errorMsg= new JFXSnackbar(rootPane123);
        
    }
@FXML
    private JFXTextField DateR1;
    @FXML
    private JFXTextField Vdepart;
    @FXML
    private JFXTextField DateD1;
    @FXML
    private void BtnReserver(ActionEvent event) {
         
        
        if(ComboClass.getSelectionModel().getSelectedItem() == null)
            return;
        if(ComboEtat.getSelectionModel().getSelectedItem() == null)
            return;
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





// conditinnel txtfield
       
        
//          if(Bnom.getText().isEmpty()){
//            errorMsg.show("Username is emty!!",1600);
//          if(!Username.getText().matches("[a-zA-Z0-9]{5,}")){  
//            return;
//        }
//         if(Password.getText().isEmpty()){
//            errorMsg.show("Password is emty!!",1600);
//            return;
//        }
//        System.out.println("Username:"+Username.getText());
//        System.out.println("Password:"+Password.getText());
//        
//         errorMsg.show("success", 1800);
//       
        try{
         String query= "INSERT INTO reservation (nom,prenom,passeport,valise,code,Type-P) VALUES (?,?,?,?,?,?);";
           PreparedStatement prest = con.prepareStatement(query);
           
            prest.setString(1, Bnom.getText());
            prest.setString(2, Bprenom.getText());
             prest.setString(3,Bpassport.getText());
              prest.setString(4, NbValise.getText());
//               prest.setString(5, Vdarrive.getText());
               prest.setString(5, Code.getText());
//              String selectedItem = ComboEtat.getSelectionModel().getSelectedItem();
//               String value2=ComboEtat.getSelectionModel().getSelectedItem();
//           prest.setString(7,value2);
//            String value=ComboClass.getSelectionModel().getSelectedItem();
//            prest.setString(8, value);
//            prest.setString(7, VilleD.getText());
            prest.setString(6, typepayer.getText());
               
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("information de reservation");
            alert.setHeaderText(null);
            alert.setContentText("Vous avez reservÃ© avec succÃ©e");
            alert.showAndWait();
            
           
           prest.execute();
           prest.close();
           
           
       }catch(Exception ex){
           ex.printStackTrace();
       }
        // new  DBConnection().SaveData(ReservationSetter);
        
        
        
        
        
    }

    @FXML
    private void BtnImprimer(ActionEvent event) {
    }


    @FXML
    private void CheckEvent3(ActionEvent event) {
        int count3=0;
        String message3="";
        
          if (Espace.isSelected()){
            count3++;
            message3+=Espace.getText()+"\n";
            
        }
            if (CB.isSelected()){
            count3++;
            message3+=CB.getText()+"\n";
            
        }
             if (Visa.isSelected()){
            count3++;
            message3+=Visa.getText()+"\n";
            
        }
              if (Check.isSelected()){
            count3++;
            message3+=Check.getText()+"\n";
            
        }
     
        typepayer.setText(message3);
        
    }
    
    public void cond(KeyEvent e){
    
   
    }

    private void retour922(MouseEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getResource("admin.fxml"));
            ((Stage)rootPane123.getScene().getWindow()).setScene(new Scene(pane));
    }
    
}

