/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sbc;

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
           C1T.setCellValueFactory(new PropertyValueFactory<RegleModel,String>("champ1"));
            C2T.setCellValueFactory(new PropertyValueFactory<RegleModel,String>("champ2"));
          idTable.setItems(regles);
    }  
    
    
 ObservableList<faitModel> faits = FXCollections.observableArrayList(
 new faitModel("Hello")
 );
 
 
 
    @FXML
    private void OnsaisiFait(ActionEvent event) {
        String idTFait = idFait.getText();
//       idTable.getItems().add(new faitModel(idFait));
       idTableFait.getItems().add(new faitModel(idTFait));
    }
   ObservableList<RegleModel> regles = FXCollections.observableArrayList(
           new RegleModel("Hello","hi")
   
   
   );
    @FXML
    private void OnSaisiRegle(ActionEvent event) {
            String C1T = C1.getText();
             String C2T = C2.getText();
//       idTable.getItems().add(new faitModel(idFait));
       idTable.getItems().add(new RegleModel(C1T, C2T));
 
    }
  
}
