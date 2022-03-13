/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Administrateur;

import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.TableLoad;
import model.guicherLoad;

/**
 * FXML Controller class
 *
 * @author fatima
 */
public class GuicherByerController implements Initializable {

    @FXML
    private JFXTextField TxtFieldSearch;
 
    
    
    ObservableList<GuichéSetter> guiche= FXCollections.observableArrayList();
    @FXML
    private AnchorPane rootPane33;
    private TableColumn<GuichéSetter,String> VilleDt;
    private TableColumn<GuichéSetter,String> TypeT;
//    @FXML
//    private TableColumn<?, ?> NpassportG;
//    @FXML
//    private TableColumn<?, ?> VilleDt;
//    @FXML
//    private TableColumn<?, ?> VilleDrv;
//    @FXML
//    private TableColumn<?, ?> ClassId;
//    @FXML
//    private TableColumn<?, ?> EtatId;
//    @FXML
//    private TableColumn<?, ?> NvaliseG;
//    @FXML
//    private TableColumn<?, ?> TypeT;
//    @FXML
//    private TableColumn<?, ?> Code;

    
    ObservableList<guicherLoad> load = FXCollections.observableArrayList();
     @FXML
    private TableView<guicherLoad> TableGuiché;
    @FXML
    private TableColumn<guicherLoad,String> Bnom;
    @FXML
    private TableColumn<guicherLoad,String> Bprenom;
    @FXML
    private TableColumn<guicherLoad,String> ComboEtat1;
    @FXML
    private TableColumn<guicherLoad,String> ComboClass1;
    @FXML
    private TableColumn<guicherLoad,String> NbValise;
    @FXML
    private TableColumn<guicherLoad,String> Vdarrive;
    @FXML
    private TableColumn<guicherLoad,String> Vdepart;
    @FXML
    private TableColumn<guicherLoad,String> NpassportG;
    @FXML
    private TableColumn<guicherLoad,String> DateD1;
    @FXML
    private TableColumn<guicherLoad,String> DateR1;
    @FXML
    private JFXTextField Bnom1;
    @FXML
    private JFXTextField Bprenom1;
    private JFXTextField Bpassport1;
    private JFXTextField ComboEtat11;
    @FXML
    private JFXTextField ComboClass11;
    private JFXTextField NbValise1;
    private JFXTextField Vdepart1;
    private JFXTextField Vdarrive1;
    private JFXTextField DateD11;
    private JFXTextField DateR11;
    @FXML
    private AnchorPane carte;
    @FXML
    private JFXTextField Bnom11;
    @FXML
    private JFXTextField Bprenom11;
    private JFXTextField Bpassport11;
    private JFXTextField Bpassport2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //load data 
       
       try{
            
            Connection con = null;
            
            String sql = "SELECT * FROM reservation "; 
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
               load.add(new guicherLoad(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
            }
//           con.close();   
        }catch(Exception e){
            e.printStackTrace();
        }
  
     Bnom.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("Bnom"));
    Bprenom.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("Bprenom"));
    ComboEtat1.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("ComboEtat1"));
     ComboClass1.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("ComboClass1"));
    NbValise.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("NbValise"));
    Vdarrive.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("Vdarrive"));
     Vdepart.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("Vdepart"));
//      ClassId.setCellValueFactory(new PropertyValueFactory<GuichÃ©Setter,String>("ClassId"));
//       EtatId.setCellValueFactory(new PropertyValueFactory<GuichÃ©Setter,String>("EtatId"));
        NpassportG.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("Bpassport"));
         DateD1.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("DateD1"));
     DateR1.setCellValueFactory(new PropertyValueFactory<guicherLoad,String>("DateR1"));
        
       
     
     
     TableGuiché.setItems(load);
     
    } 
    
 FilteredList<GuichéSetter> filtredData= new FilteredList(guiche,e ->true);
 
    ObservableList<guicherLoad> list = FXCollections.observableArrayList();
  @FXML
    private void searchGQ(ActionEvent e) { //Search in General Quantity Table

        TxtFieldSearch.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (TxtFieldSearch.textProperty().get().isEmpty()) {
                    TableGuiché.setItems(list);
                    return;
                }
                ObservableList<guicherLoad> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<guicherLoad, ?>> column = TableGuiché.getColumns();

                for (int row = 0; row < list.size(); row++) {
                    for (int col = 0; col < column.size(); col++) {
                        TableColumn tabVar = column.get(col);
                        String cellData = tabVar.getCellData(list.get(row)).toString();
                        cellData = cellData.toLowerCase();

                        if (cellData.contains(TxtFieldSearch.getText().toLowerCase()) && cellData.startsWith(TxtFieldSearch.getText().toLowerCase())) {
                            items.add(list.get(row));
                            break;
                        }
                    }

                }
                TableGuiché.setItems(items);
            /*TableGuiché*/       }
        });
    }
    

 
 
 
 
   public void FiltreSearch2(KeyEvent event) {
          TxtFieldSearch.textProperty().addListener((observableValue,oldValue, newValue) ->{
        
            filtredData.setPredicate((Predicate<? super GuichéSetter> ) (GuichéSetter std)->{
                
                if(newValue== null || newValue.isEmpty()){
                     return true;
                      
                 }else if(std.NpassportG.contains(newValue)){
                     return true;
                 }
                return false;
                
                 });
    });
           
      SortedList sort=new SortedList(filtredData);
      sort.comparatorProperty().bind(TableGuiché.comparatorProperty());
       
      TableGuiché.setItems(sort);
        
    }

    @FXML
   public void Gotohome(MouseEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getResource("admin.fxml"));
            ((Stage)rootPane33.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    public void DisplaySelected(MouseEvent event) {
       guicherLoad person= TableGuiché.getSelectionModel().getSelectedItem();
        if ( person==null){
            Bnom.setText("NULL");
            Bprenom.setText("null");
//            ComboEtat1.setText("NULL");
            ComboClass1.setText("null");
//             NbValise.setText("NULL");
//            Bpassport.setText("null");
//             DateD1.setText("NULL");
//          DateR1.setText("null");
//            Vdepart.setText("NULL");
//            Vdarrive.setText("null");
            
        }
        else{
            String Bnom=person.getBnom();
             String Bprenom=person.getBprenom();
             String  ComboClass1=person.getComboClass1();
//             String  ComboEtat1=person.getComboEtat1();
//             String NbValise=person.getNbValise();
//             String  Bpassport=person.getBpassport();
//             String DateD1=person.getDateD1();
//             String DateR1=person.getDateR1();
//              String  Vdepart=person.getVdepart();
//             String Vdarrive=person.getVdarrive();
             
             
             Bnom1.setText(""+Bnom);
             Bnom11.setText(""+Bnom);
             Bprenom1.setText(""+Bprenom);
              Bprenom11.setText(""+Bprenom);
             ComboClass11.setText(""+ComboClass1);
//             ComboEtat11.setText(""+ComboEtat1);
//             NbValise1.setText(""+NbValise);
//             Bpassport1.setText(""+Bpassport);
//              Bpassport11.setText(""+Bpassport);
//             DateD11.setText(""+DateD1);
//             DateR11.setText(""+DateR1);
//             Vdepart1.setText(""+Vdepart);
//             Vdarrive1.setText(""+Vdarrive);
//             Bpassport2.setText(""+Bpassport);
             
        }
         
    }
    
   


    @FXML
    private void Onprint(ActionEvent event) {
        print(carte);
    }
     private void print(Node node) {

    javafx.print.PrinterJob job = javafx.print.PrinterJob.createPrinterJob();
    if (job != null) {

      boolean printed = job.printPage(node);
      if (printed) {
        job.endJob();
      } else {
      }
    } else {
    }
     }
  ObservableList<guicherLoad> persons = FXCollections.observableArrayList();
//    @FXML
//    private void Search(KeyEvent event) {
//              search.textProperty().addListener(new InvalidationListener() {
//            @Override
//            public void invalidated(Observable observable) {
//                if(search.textProperty().get().isEmpty()){
//                    TableGuiché.setItems(persons);
//                    return;
//                }
//                ObservableList<guicherLoad> items = FXCollections.observableArrayList();
//                ObservableList<TableColumn<guicherLoad,?>> column = TableGuiché.getColumns();
//                
//                for(int row = 0;row < persons.size(); row++){
//                    for(int col = 0;col < column.size();col++){
//                        TableColumn tabVar = column.get(col);
//                        String cellData = tabVar.getCellData(persons.get(row)).toString();
//                        cellData = cellData.toLowerCase();
//                        
//                        if(cellData.contains(search.getText().toLowerCase()) && cellData.startsWith(search.getText().toLowerCase())){
//                            items.add(persons.get(row));
//                            break;
//                        }
//                    }
//                    
//                }
//                TableGuiché.setItems(items);
//            }
//        });
//    }
    //    
//        @FXML
//    private void searchA(){
//        

//    }
//    
     
     
     
     
}

