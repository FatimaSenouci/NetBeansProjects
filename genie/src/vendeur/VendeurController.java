/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendeur;

import dao.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.produit;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class VendeurController implements Initializable {
    
    
    @FXML
    private TextField search;
   
    ObservableList<produit> produis = FXCollections.observableArrayList();
    
        @FXML
    private TableView<produit> tableV;
        
    @FXML
    private TextField fieldId;
    @FXML
    private TextField fieldType;
    @FXML
    private TextField fieldComptité;
    @FXML
    private TextField fieldPrix;
    @FXML
    private TableColumn<produit, String> typeT;
    @FXML
    private TableColumn<produit, Integer> comptitéT;
    @FXML
    private TableColumn<produit, Integer> prixT;
        @FXML
    private TableColumn<produit, Integer> idTab;
    
    
    
    @FXML
    private void searchA(){
        
        search.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(search.textProperty().get().isEmpty()){
                    tableV.setItems(produis);
                    return;
                }
                ObservableList<produit> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<produit,?>> column = tableV.getColumns();
                
                for(int row = 0;row < produis.size(); row++){
                    for(int col = 0;col < column.size();col++){
                        TableColumn tabVar = column.get(col);
                        String cellData = tabVar.getCellData(produis.get(row)).toString();
                        cellData = cellData.toLowerCase();
                        
                        if(cellData.contains(search.getText().toLowerCase()) && cellData.startsWith(search.getText().toLowerCase())){
                            items.add(produis.get(row));
                            break;
                        }
                    }
                    
                }
                tableV.setItems(items);
            }
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
        try{
            
            Connection con = null;
            
            String sql = "Select * produit ";
            con = DBConnection.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
               produis.add(new produit(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
            }
            con.close();
            
            
        }catch(Exception e){
            
        }
        
        idTab.setCellValueFactory(new PropertyValueFactory<produit,Integer>("id"));
        typeT.setCellValueFactory(new PropertyValueFactory<produit,String>("type"));
        comptitéT.setCellValueFactory(new PropertyValueFactory<produit,Integer>("comptité"));
         prixT.setCellValueFactory(new PropertyValueFactory<produit,Integer>("prix"));
        
        
        tableV.setItems(produis);
    }
    
   

 @FXML
    void onInsert() throws SQLException {
        produit produit = new produit();
        produit.setId(Integer.parseInt(fieldId.getText()));
       produit.setType(fieldType.getText());
     produit.setComptité(Integer.parseInt(fieldComptité.getText()));
        produit.setPrix(Integer.parseInt(fieldPrix.getText()));
        
        new DBConnection().insertProduit(produit);

    }

    @FXML
    private void onSupp(ActionEvent event) {
    }

    @FXML
    private void onModif(ActionEvent event) {
    }
    

    /**
     * Initializes the controller class.
     */
      
    
}
