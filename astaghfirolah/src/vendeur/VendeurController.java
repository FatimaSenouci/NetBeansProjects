/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendeur;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Produit;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class VendeurController implements Initializable {
    ObservableList<Produit> produit = FXCollections.observableArrayList();
    @FXML
    private TableView<Produit> TableV;
    @FXML
    private TableColumn<Produit, Integer> IdT;
    @FXML
    private TableColumn<Produit, String> TypeT;
    @FXML
    private TableColumn<Produit, Integer> ComptitéT;
    @FXML
    private TableColumn<Produit, Integer> PrixT;
    @FXML
    private TableColumn<Produit, Integer> TotaleT;
    @FXML
    private JFXTextField fieldPrix;
    @FXML
    private JFXComboBox<Produit> fieldType;
    @FXML
    private JFXTextField fieldId;
    @FXML
    private JFXTextField fieldComptité;

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb){
            try{
            Connection con = null;
            
            String sql = "Select * from produit ";
            con = DBConnection.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
               produit.add(new Produit(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)));
            }
            con.close();
            
            
        }catch(Exception e){
            
        }
            
        
        IdT.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("Id"));
        TypeT.setCellValueFactory(new PropertyValueFactory<Produit,String>("Type"));
        ComptitéT.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("Comptité"));
        PrixT.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("Prix"));
//        TotaleT.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("Totale"));
        
        
        TableV.setItems(produit);
          
        // TODO
    }    

    @FXML
    private void ONmodif(ActionEvent event) {
        
    }

    @FXML
    private void OnSup(ActionEvent event) {
 
    }

    @FXML
    private void onInsert(ActionEvent event) {
       Produit produit = new Produit();
      produit.setId(Integer.parseInt(fieldId.getText()));
      produit.setType(fieldType.getTypeSelector());
      produit.setComptité(Integer.parseInt(fieldComptité.getText()));
       produit.setPrix(Integer.parseInt(fieldPrix.getText()));
      


        
        new DBConnection().insertProduit(produit);
        
    }
}

