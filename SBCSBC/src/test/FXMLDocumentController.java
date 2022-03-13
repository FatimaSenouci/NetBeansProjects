/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.RegleModel;
import model.faitModel;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class FXMLDocumentController implements Initializable {

private Label label;
    @FXML
    private AnchorPane trtm;
    @FXML
    private JFXButton ButtonC;
    @FXML
    private Button ButtonTR;
    @FXML
    private AnchorPane pere;
    @FXML
    private AnchorPane trait;
    @FXML
    private AnchorPane cnsc;
    @FXML
    private JFXTextField idFait;
    @FXML
    private TableView<faitModel> idTableFait;
    @FXML
    private TableColumn<faitModel, String> idTFait;
    @FXML
    private JFXTextField C1;
    @FXML
    private JFXTextField C2;
    @FXML
    private TableView<RegleModel> idTable;
    @FXML
    private TableColumn<RegleModel, String> C1T;
    @FXML
    private TableColumn<RegleModel, String> C2T;
    
     ObservableList<faitModel> faits = FXCollections.observableArrayList();
     ObservableList<RegleModel> regles = FXCollections.observableArrayList();
    @FXML
    private void handleButtonAction(ActionEvent event) {
           if(event.getSource()==ButtonTR){
            trait.toFront();
        }
        else  if(event.getSource()== ButtonC){
            cnsc.toFront();
        }
//        System.out.println("You clicked me!");
//        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         idTFait.setCellValueFactory(new PropertyValueFactory<faitModel,String>("fait"));
          idTableFait.setItems(faits);
    }   
    
    @FXML
    private void OnsaisiFait(ActionEvent event) {
          faitModel faitmodel = new faitModel();
       
        faitmodel.setFait(idFait.getText());
        faits.clear();
    }
    @FXML
    private void DisplayPiste(MouseEvent event) { 
          faitModel faitt= idTableFait.getSelectionModel().getSelectedItem();
        if ( faitt==null){
          idTFait.setText("NULL");
          
         
        }
        else{
             
             String idTFait=faitt.getFait();
       
             idFait.setText(""+idTFait);
        
        }
    }
    @FXML
    private void OnSaisiRegle(ActionEvent event) {
         RegleModel reglemodel = new RegleModel();
       
        reglemodel.setChamp1(C1.getText());
         reglemodel.setChamp2(C2.getText());
        regles.clear();
    }
    
    
}
