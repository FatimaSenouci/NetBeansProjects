
package Administrateur;

import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import model.Pistemodel;


public class AvionController implements Initializable {
    
    @FXML
    private AnchorPane rootPane4;
    @FXML
    private JFXTextField idavion;
    @FXML
    private JFXTextField idcapacité;
    @FXML
    private JFXTextField idNom_avion;
    @FXML
    private TableView<Avionmodel> idTable;
    @FXML
    private TableColumn<Avionmodel, Integer> idavionT;
    @FXML
    private TableColumn<Avionmodel, String> idNom_avionT;
    @FXML
    private TableColumn<Avionmodel, Integer> idCapacitéT;
    
     ObservableList<Avionmodel> avions = FXCollections.observableArrayList();

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            idavion.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\d*"));{
           idavion.setText(newValue.replaceAll("[^\\d]", ""));
        }}
        });
               idNom_avion.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\D*"));{
            idNom_avion.setText(newValue.replaceAll("[^\\D]", ""));
        }}
        });
        idcapacité.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\d*"));{
            idcapacité.setText(newValue.replaceAll("[^\\d]", ""));
        }}
        });
        
        try{
            
            Connection con = null;
            
            String sql = "Select * from avion ";
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                avions.add(new Avionmodel(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
//            con.close();
            
            
        }catch(Exception e){
            
        }
      
        
        idavionT.setCellValueFactory(new PropertyValueFactory<Avionmodel,Integer>("idavion"));
        idNom_avionT.setCellValueFactory(new PropertyValueFactory<Avionmodel,String>("nom_avion"));
        idCapacitéT.setCellValueFactory(new PropertyValueFactory<Avionmodel,Integer>("capacité"));
        
        
     idTable.setItems(avions);
    }    

    @FXML
    private void retour4(MouseEvent event) throws IOException {
                   AnchorPane pane =FXMLLoader.load(getClass().getResource("admin.fxml"));
     ((Stage)rootPane4.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void OnInsertAvion()throws SQLException {
          
         Avionmodel avionmodel = new Avionmodel();
        avionmodel.setIdavion(Integer.parseInt(idavion.getText()));
        avionmodel.setNom_avion(idNom_avion.getText());
        avionmodel.setCapacité(Integer.parseInt(idcapacité.getText()));

        new  DBConnection().insertAvion(avionmodel);
        avions.clear();
        //         Connection con = DBConnection.con;
        
        
    }

    @FXML
    private void OnSupAvion(ActionEvent event) {
          Avionmodel avionmodel = new Avionmodel();
        avionmodel.setIdavion(Integer.parseInt(idavion.getText()));
         new  DBConnection().deleteAvion(avionmodel);
        avions.clear();
    }

    @FXML
    private void OnModifierAvion(ActionEvent event) {
           Avionmodel avionmodel = new Avionmodel();
          avionmodel.setIdavion(Integer.parseInt(idavion.getText()));
        avionmodel.setNom_avion(idNom_avion.getText());
        avionmodel.setCapacité(Integer.parseInt(idcapacité.getText()));
        avions.clear();
//        System.out.println(pistemodel.getIdpiste() + " " + pistemodel.getType() + " " + pistemodel.getNombre());
        
        new DBConnection().updateAvion(avionmodel);
    }

    @FXML
    private void Displayavion(MouseEvent event) {
               Avionmodel person= idTable.getSelectionModel().getSelectedItem();
        if ( person==null){
          idavionT.setText("NULL");
           idNom_avionT.setText("null");
           idCapacitéT.setText("NULL");
         
        }
        else{
             int idavionT=person.getIdavion();
             String idNom_avionT=person.getNom_avion();
              int idCapacitéT=person.getCapacité();
          
          
             
             
            idavion.setText(""+idavionT);
             idNom_avion.setText(""+idNom_avionT);
            idcapacité.setText(""+idCapacitéT);
          
            
        }
    }
    
}
