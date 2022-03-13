/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid19;

import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CvdController implements Initializable {
   
             private TableView<cvdModel> IdTable;
    private TableColumn<cvdModel, Integer>  idwilaya;
    private TableColumn<cvdModel, Integer> idNumber;
    private TableColumn<cvdModel, Integer> IdPercentage;
    @FXML
    private JFXTextField idSearch;
 ObservableList<cvdModel> load = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
  FilteredList<cvdModel> filtredData= new FilteredList(load,e ->true);

   @FXML
    private void SearchField(KeyEvent event) {
         idSearch.textProperty().addListener((observableValue,oldValue, newValue) ->{
       
            
            filtredData.setPredicate((Predicate<? super cvdModel> ) (cvdModel std)->{
                
                if(newValue== null || newValue.isEmpty()){
                     return true;
                     
                     
                 }else 
//                    if(std.getIdwilaya().contains(newValue)){
//                     return true;
//                 }
                
                
                
                return false;
                
                 });
    });
           
      SortedList sort=new SortedList(filtredData);
      sort.comparatorProperty().bind(IdTable.comparatorProperty());
       
      IdTable.setItems(sort);
      
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try{
            
            Connection con = null;
            
            String sql = "SELECT * FROM covid "; 
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                load.add(new cvdModel(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
            }
//           con.close();   
        }catch(Exception e){
            e.printStackTrace();
        }
     
    
     idwilaya.setCellValueFactory(new PropertyValueFactory<cvdModel,Integer>("Num_wilaya"));
      idNumber.setCellValueFactory(new PropertyValueFactory<cvdModel,Integer>("nombre"));
   IdPercentage.setCellValueFactory(new PropertyValueFactory<cvdModel,Integer>("pourcentage"));
    
     
     IdTable.setItems(load);
    FilteredList<cvdModel> filtredData= new FilteredList(load,e ->true);
    
  
        // TODO
    }    
    
}
