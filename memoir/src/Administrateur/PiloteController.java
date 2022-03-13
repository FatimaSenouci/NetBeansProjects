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
import model.Pilotemodel;
import model.Volmodel;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class PiloteController implements Initializable {
          @FXML
    private AnchorPane rootPane3;

        @FXML
    private JFXTextField idname;

    @FXML
    private JFXTextField idprenom;

    @FXML
    private JFXTextField idnaiss;

    @FXML
    private JFXTextField idphone;

    @FXML
    private JFXTextField idnational;

    @FXML
    private JFXTextField idpilot;
     @FXML
    private TableView<Pilotemodel> idTab;
    @FXML
    private TableColumn<Pilotemodel, Integer> idpilotT;
    @FXML
    private TableColumn<Pilotemodel, String> idnameT;
    @FXML
    private TableColumn<Pilotemodel, String> idprenomT;
    @FXML
    private TableColumn<Pilotemodel, String> idnaissT;
    @FXML
    private TableColumn<Pilotemodel, Integer> idphoneT;
    @FXML
    private TableColumn<Pilotemodel,String> idnationalT;
    
     ObservableList<Pilotemodel> pilots = FXCollections.observableArrayList();
    @FXML
    private JFXDatePicker idnaiss1;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idpilot.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\d*"));{
            idpilot.setText(newValue.replaceAll("[^\\d]", ""));
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
        idnational.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\D*"));{
            idnational.setText(newValue.replaceAll("[^\\D]", ""));
        }}
        });
        try{
            
            Connection con = null;
            
            String sql = "Select * from pilote ";
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                pilots.add(new Pilotemodel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
            }
//            con.close();
            
            
        }catch(Exception e){
            
        }
          
        idpilotT.setCellValueFactory(new PropertyValueFactory<Pilotemodel,Integer>("idpilote"));
       idnameT.setCellValueFactory(new PropertyValueFactory<Pilotemodel,String>("nom"));
       idprenomT.setCellValueFactory(new PropertyValueFactory<Pilotemodel,String>("prenom"));
        idnaissT.setCellValueFactory(new PropertyValueFactory<Pilotemodel,String>("ddn"));
        idphoneT.setCellValueFactory(new PropertyValueFactory<Pilotemodel,Integer>("telephone"));
        idnationalT.setCellValueFactory(new PropertyValueFactory<Pilotemodel,String>("nationalité"));
        
        
        
     idTab.setItems(pilots);
        // TODO
    }    

    @FXML
    private void retour3(MouseEvent event) throws IOException {
                   AnchorPane pane =FXMLLoader.load(getClass().getResource("admin.fxml"));
     ((Stage)rootPane3.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void OninsertPilot(ActionEvent event) {
         idnaiss.setText(idnaiss1.getValue().toString());
        
         Pilotemodel pilotemodel = new Pilotemodel();
         
          pilotemodel.setIdpilot(Integer.parseInt(idpilot.getText())); 
          pilotemodel.setIdname(idname.getText());
          pilotemodel.setIdprenom(idprenom.getText());
          pilotemodel.setIdnaiss(idnaiss.getText());
          pilotemodel.setIdphone(Integer.parseInt(idphone.getText()));
          pilotemodel.setIdnational(idnational.getText());
           pilots.clear();
          new  DBConnection().insertPilote(pilotemodel);
       
    }

    @FXML
    private void OndeletePilot(ActionEvent event) {
         Pilotemodel pilotemodel = new Pilotemodel();
          pilotemodel.setIdpilot(Integer.parseInt(idpilot.getText())); 
            pilots.clear();
          new  DBConnection().deletePilote(pilotemodel);
    }

    @FXML
    private void OnModifyPilot(ActionEvent event) {
          Pilotemodel pilotemodel = new Pilotemodel();
         
          pilotemodel.setIdpilot(Integer.parseInt(idpilot.getText())); 
          pilotemodel.setIdname(idname.getText());
          pilotemodel.setIdprenom(idprenom.getText());
          pilotemodel.setIdnaiss(idnaiss.getText());
          pilotemodel.setIdphone(Integer.parseInt(idphone.getText()));
          pilotemodel.setIdnational(idnational.getText());
           pilots.clear();
          new  DBConnection().updatePilote(pilotemodel);
    }

    @FXML
    private void Displaypilote(MouseEvent event) {
              Pilotemodel person= idTab.getSelectionModel().getSelectedItem();
        if ( person==null){
          idpilotT.setText("NULL");
           idnameT.setText("null");
           idprenomT.setText("NULL");
            idnaissT.setText("NULL");
          idphoneT.setText("null");
           idnationalT.setText("NULL");
         
        }
        else{
             int  idpilotT=person.getIdpilot();
             String idnameT=person.getIdname();
              String idprenomT=person.getIdprenom();
               String idnaissT=person.getIdnaiss();
              int idphoneT=person.getIdphone();
               String idnationalT=person.getIdnational();
          
          
             
             
             idpilot.setText(""+idpilotT);
             idname.setText(""+idnameT);
            idprenom.setText(""+idprenomT);
             idnaiss.setText(""+idnaissT);
            idphone.setText(""+idphoneT);
             idnational.setText(""+idnationalT);
          
            
        }
    }
    
}
