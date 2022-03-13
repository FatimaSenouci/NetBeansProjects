
package Administrateur;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
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
import model.Pistemodel;
import model.Volmodel;


public class VolController implements Initializable {
    
    @FXML
    private AnchorPane rootPane5;
    @FXML
    private JFXTextField idvol;
    @FXML
    private JFXTextField idddd;
    @FXML
    private JFXTextField idhdd;
    @FXML
    private JFXTextField iddda;
    @FXML
    private JFXTextField idhda;
    @FXML
    private TableView<Volmodel> idTab;
    @FXML
    private TableColumn<Volmodel, Integer> idvolT;
    @FXML
    private TableColumn<Volmodel, String> dddT;
    @FXML
    private TableColumn<Volmodel, String> hddT;
    @FXML
    private TableColumn<Volmodel, String> ddaT;
    @FXML
    private TableColumn<Volmodel, String> hdaT;

        ObservableList<Volmodel> vols = FXCollections.observableArrayList();
    @FXML
    private JFXDatePicker idddd1;
    @FXML
    private JFXDatePicker iddda1;
    @FXML
    private JFXTimePicker idhdd1;
    @FXML
    private JFXTimePicker idhda1;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idvol.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\d*"));{
            idvol.setText(newValue.replaceAll("[^\\d]", ""));
        }}
        });
      
    
        try{
            
            Connection con = null;
            
            String sql = "Select * from vol ";
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                vols.add(new Volmodel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2)));
            }
//            con.close();
            
            
        }catch(Exception e){
            
        }
      
        
        idvolT.setCellValueFactory(new PropertyValueFactory<Volmodel,Integer>("idvol"));
        dddT.setCellValueFactory(new PropertyValueFactory<Volmodel,String>("ddd"));
        hddT.setCellValueFactory(new PropertyValueFactory<Volmodel,String>("hdd"));
        ddaT.setCellValueFactory(new PropertyValueFactory<Volmodel,String>("dda"));
        hdaT.setCellValueFactory(new PropertyValueFactory<Volmodel,String>("hda"));
        
        
        
     idTab.setItems(vols);
    }    

    @FXML
    private void retour5(MouseEvent event) throws IOException {
              AnchorPane pane =FXMLLoader.load(getClass().getResource("admin.fxml"));
     ((Stage)rootPane5.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void OnInsertVol(ActionEvent event) {
        
           idddd.setText(idddd1.getValue().toString());
           iddda.setText(iddda1.getValue().toString());
           idhdd.setText(idhdd1.getValue().toString());
           idhda.setText(idhda1.getValue().toString());
        
        Volmodel volmodel = new Volmodel();
        volmodel.setIdvol(Integer.parseInt(idvol.getText()));
          
          volmodel.setDdd(idddd.getText());
          volmodel.setHdd(idhdd.getText());
          volmodel.setDda(iddda.getText());
          volmodel.setHda(idhda.getText());
          
          new  DBConnection().insertVol(volmodel);
        vols.clear();
    }

    @FXML
    private void OnIDeleteVol(ActionEvent event) {
    }

    @FXML
    private void OnModifyVol(ActionEvent event) {
              
        Volmodel volmodel = new Volmodel();
        volmodel.setIdvol(Integer.parseInt(idvol.getText()));
          
          volmodel.setDdd(idddd.getText());
          volmodel.setHdd(idhdd.getText());
          volmodel.setDda(iddda.getText());
          volmodel.setHda(idhda.getText());
          
          new  DBConnection().updateVol(volmodel);
        vols.clear();
    }

    @FXML
    private void Displayvol(MouseEvent event) {
            Volmodel person= idTab.getSelectionModel().getSelectedItem();
        if ( person==null){
          idvolT.setText("NULL");
           dddT.setText("null");
           hddT.setText("NULL");
            ddaT.setText("NULL");
          hdaT.setText("null");
          
         
        }
        else{
             int idvolT=person.getIdvol();
             String  dddT=person.getDdd();
                String hddT=person.getHdd();
                   String  ddaT=person.getDda();
                String  hdaT=person.getHda();
          
          
             
             
             idvol.setText(""+idvolT);
            idddd.setText(""+dddT);
            idhdd.setText(""+hddT);
              iddda.setText(""+ddaT);
            idhda.setText(""+hdaT);
          
            
        }
    }
    
}
