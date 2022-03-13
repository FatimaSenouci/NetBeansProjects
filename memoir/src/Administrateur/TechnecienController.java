/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrateur;

import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Avionmodel;
import model.TechnecienModel;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class TechnecienController implements Initializable {
          @FXML
    private AnchorPane rootPane1;
    @FXML
    private JFXTextField idname;
    @FXML
    private JFXTextField idprenom;
    @FXML
    private JFXTextField idnaiss;
    @FXML
    private JFXTextField idphone;
    @FXML
    private JFXTextField idtech;
    @FXML
    private TableView<TechnecienModel> idTable;
    @FXML
    private TableColumn<TechnecienModel, Integer> idtechT;
    @FXML
    private TableColumn<TechnecienModel, String> idnameT;
    @FXML
    private TableColumn<TechnecienModel, String> idprenomT;
    @FXML
    private TableColumn<TechnecienModel, String> idnaissT;
    @FXML
    private TableColumn<TechnecienModel, Integer> idphoneT;
    
    ObservableList<TechnecienModel> techs = FXCollections.observableArrayList();
    @FXML
    private JFXDatePicker idnaiss1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       idtech.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\d*"));{
           idtech.setText(newValue.replaceAll("[^\\d]", ""));
        }}
        });
       idname.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\D*"));{
            idname.setText(newValue.replaceAll("[^\\D]", ""));
        }}
        });
       idprenom.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\D*"));{
            idprenom.setText(newValue.replaceAll("[^\\D]", ""));
        }}
        });
       idphone.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\d*"));{
            idphone.setText(newValue.replaceAll("[^\\d]", ""));
        }}
        });
     
        
        // TODO
        
        
        try{
            
            Connection con = null;
            
            String sql = "Select * from technicien ";
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                techs.add(new TechnecienModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
            }
//            con.close();
            
            
        }catch(Exception e){
            
        }
      
        
        idtechT.setCellValueFactory(new PropertyValueFactory<TechnecienModel,Integer>("idtech"));
        idnameT.setCellValueFactory(new PropertyValueFactory<TechnecienModel,String>("nom"));
        idprenomT.setCellValueFactory(new PropertyValueFactory<TechnecienModel,String>("prenom"));
        idnaissT.setCellValueFactory(new PropertyValueFactory<TechnecienModel,String>("ddn"));
        idphoneT.setCellValueFactory(new PropertyValueFactory<TechnecienModel,Integer>("telephone"));
        
        
     idTable.setItems(techs);
    }    

    @FXML
    private void retour1(MouseEvent event) throws IOException {
                          AnchorPane pane =FXMLLoader.load(getClass().getResource("admin.fxml"));
     ((Stage)rootPane1.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void OninsertTech(ActionEvent event) {
          idnaiss.setText(idnaiss1.getValue().toString());
        
       TechnecienModel technecienmodel = new TechnecienModel();
        technecienmodel.setIdtech(Integer.parseInt(idtech.getText()));
        technecienmodel.setFirstname(idname.getText());
        technecienmodel.setName(idprenom.getText());
        technecienmodel.setNaiss(idnaiss.getText());
        technecienmodel.setPhone(Integer.parseInt(idphone.getText()));

        new  DBConnection().insertTechnecien(technecienmodel);
       techs.clear();
        System.out.println(technecienmodel.getIdtech() + " " + technecienmodel.getFirstname() + " " + technecienmodel.getName()+ " " + technecienmodel.getNaiss());
    }

    @FXML
    private void OndeleteTech(ActionEvent event) {
          TechnecienModel technecienmodel = new TechnecienModel();
            technecienmodel.setIdtech(Integer.parseInt(idtech.getText()));
              new  DBConnection().deleteTechnecien(technecienmodel);
            techs.clear();
        
      //  deletePilote
    }

    @FXML
    private void OnmodifyTech(ActionEvent event) {
          TechnecienModel technecienmodel = new TechnecienModel();
           technecienmodel.setIdtech(Integer.parseInt(idtech.getText()));
        technecienmodel.setFirstname(idname.getText());
        technecienmodel.setName(idprenom.getText());
        technecienmodel.setNaiss(idnaiss.getText());
        technecienmodel.setPhone(Integer.parseInt(idphone.getText()));

        new  DBConnection().updateTechnecien(technecienmodel);
       techs.clear();
    }

    @FXML
    private void DisplayTech(MouseEvent event) {
               TechnecienModel person= idTable.getSelectionModel().getSelectedItem();
        if ( person==null){
          idtechT.setText("NULL");
           idprenomT.setText("null");
           idnameT.setText("NULL");
           idnaissT.setText("NULL");
          idphoneT.setText("null");
           
         
        }
        else{
             int idtechT=person.getIdtech();
             String idprenomT=person.getFirstname();
              String idnameT=person.getName();
               String idnaissT=person.getNaiss();
                int idphoneT=person.getPhone();
              
          
          
             
             
             idtech.setText(""+idtechT);
             idprenom.setText(""+idprenomT);
           idname.setText(""+idnameT);
             idnaiss.setText(""+idnaissT);
           idphone.setText(""+idphoneT);
          
            
        }
    }
    
}
