
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
import model.Pistemodel;
import model.loadpiste;
import org.controlsfx.control.textfield.TextFields;


public class PistesController implements Initializable {
    @FXML
    private AnchorPane rootPane2;
    @FXML
    private JFXTextField idPiste;
    @FXML
    private JFXTextField idType;
    @FXML
    private JFXTextField idNombre;
    @FXML
    private TableView<Pistemodel> idTable;
    @FXML
    private TableColumn<Pistemodel, Integer> idpisteT;
    @FXML
    private TableColumn<Pistemodel, String> typeT;
    @FXML
    private TableColumn<Pistemodel, Integer> nombreT;
    
    ObservableList<Pistemodel> pistes = FXCollections.observableArrayList();

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         String[] possiblewordsSet = {" ","Atterissage" ,"Decollage"  };
            TextFields.bindAutoCompletion(idType, possiblewordsSet);
        
        
        idPiste.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\d*"));{
            idPiste.setText(newValue.replaceAll("[^\\d]", ""));
        }}
        });
         idType.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\D*"));{
           idType.setText(newValue.replaceAll("[^\\D]", ""));
        }}
        });
          idNombre.textProperty().addListener(new ChangeListener<String>(){
        @Override
        public void changed (ObservableValue<? extends String> observable,String oldValue,String newValue){
        if(!newValue.matches("\\d*"));{
            idNombre.setText(newValue.replaceAll("[^\\d]", ""));
        }}
        });
        
       
        try{
            
            Connection con = null;
            
            String sql = "Select * from piste ";
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                pistes.add(new Pistemodel(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
//            con.close();
            
            
        }catch(Exception e){
            
        }
      
        
        idpisteT.setCellValueFactory(new PropertyValueFactory<Pistemodel,Integer>("idpiste"));
        typeT.setCellValueFactory(new PropertyValueFactory<Pistemodel,String>("type"));
        nombreT.setCellValueFactory(new PropertyValueFactory<Pistemodel,Integer>("nombre"));
        
        
     idTable.setItems(pistes);
    }    


      @FXML
    void retour2(MouseEvent event) throws IOException {
         AnchorPane pane =FXMLLoader.load(getClass().getResource("admin.fxml"));
            ((Stage)rootPane2.getScene().getWindow()).setScene(new Scene(pane));

    }

    @FXML
    private void OnInsertPiste(ActionEvent event) {
        Pistemodel pistemodel = new Pistemodel();
        pistemodel.setIdpiste(Integer.parseInt(idPiste.getText()));
        pistemodel.setType(idType.getText());
        pistemodel.setNombre(Integer.parseInt(idNombre.getText()));
        pistes.clear();
        System.out.println(pistemodel.getIdpiste() + " " + pistemodel.getType() + " " + pistemodel.getNombre());
        
        new DBConnection().insertPiste(pistemodel);
         
       
    }

    @FXML
    private void OnModifierPiste(ActionEvent event) {
          Pistemodel pistemodel = new Pistemodel();
        pistemodel.setIdpiste(Integer.parseInt(idPiste.getText()));
        pistemodel.setType(idType.getText());
        pistemodel.setNombre(Integer.parseInt(idNombre.getText()));
        pistes.clear();
//        System.out.println(pistemodel.getIdpiste() + " " + pistemodel.getType() + " " + pistemodel.getNombre());
        
        new DBConnection().updatePiste(pistemodel);
        
        
    }

    @FXML
    private void OnDeletePiste(ActionEvent event) throws SQLException {
         Pistemodel pistemodel = new Pistemodel();
        pistemodel.setIdpiste(Integer.parseInt(idPiste.getText()));
        pistes.clear();
//        pistemodel.setType(idType.getText());
//        pistemodel.setNombre(Integer.parseInt(idNombre.getText()));
//        System.out.println(pistemodel.getIdpiste() + " " + pistemodel.getType() + " " + pistemodel.getNombre());
        
        new DBConnection().deletePiste(pistemodel);
        
        
        
        
    }

    @FXML
    private void DisplayPiste(MouseEvent event) { 
          Pistemodel person= idTable.getSelectionModel().getSelectedItem();
        if ( person==null){
          idpisteT.setText("NULL");
           typeT.setText("null");
           nombreT.setText("NULL");
         
        }
        else{
             int idpisteT=person.getIdpiste();
             String typeT=person.getType();
              int nombreT=person.getNombre();
          
          
             
             
             idPiste.setText(""+idpisteT);
             idType.setText(""+typeT);
            idNombre.setText(""+nombreT);
          
            
        }
    }
    
    
}
 