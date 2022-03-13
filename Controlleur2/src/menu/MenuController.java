
package menu;


import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
//import com.sun.javaws.Main;
import dao.DBConnection;
import static dao.DBConnection.con;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
// CODE de semaphor

public class MenuController implements Initializable {
    private final static MenuController instance = new MenuController();
    public static MenuController getInstance() {
        return instance;
        
        
      
        
        
    }


    @FXML
    private AnchorPane landing;
    @FXML
    private AnchorPane liftoff;
    @FXML
    private AnchorPane theflights;
    @FXML
    private AnchorPane tracks;
    @FXML
    private AnchorPane control;
    @FXML
    private AnchorPane pere;
    @FXML
    private JFXButton btn_landing;
    @FXML
    private JFXButton btn_liftoff;
    @FXML
    private JFXButton btn_theflights;
    @FXML
    private JFXButton btn_tracks;
    @FXML
    private JFXButton btn_control;
    @FXML
    private JFXButton bnt_all;
    private Object btn_all;
    @FXML
    private JFXTextField flightn;
    @FXML
    private JFXTextField plann;
    
    @FXML
    private JFXTextField trackid;
    @FXML
    private JFXTextField idtype;
    @FXML
    private TableView<TableMenu1> idTable;
    @FXML
    private TableColumn<TableMenu1, Integer> trackidT;
    @FXML
    private TableColumn<TableMenu1, String> typeidT;
    
   
    
      ObservableList<TableMenu1> list = FXCollections.observableArrayList();
     ///pichr 
  
    @FXML private DatePicker dp;
    @FXML private Label lblDate;
    @FXML
    private TableView<TableLoad> tableViewF;
    @FXML
    private TableColumn<TableLoad, String> DateT;
    @FXML
    private TableColumn<TableLoad,String > FlightT;
    @FXML
    private TableColumn<TableLoad, String> PlaneT;
    @FXML
    private TableColumn<TableLoad, String> PisteT;
    @FXML
    private TableColumn<TableLoad,String> HT;
    @FXML
    private TableColumn<TableLoad,String> CT;
    
    ObservableList<TableLoad> load = FXCollections.observableArrayList();
    @FXML
    private JFXTextField SearchField;
    
    @FXML
    private void getDate(){
        
      //Suite1Controller.date =  dp.getValue().toString();
    }

     public DatePicker getDp() {
        return dp;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
     for(int i=0;i< 10; i++){
             
            list.add(new TableMenu1(i, "Landing"));
             
        }
        
//                 try{
//            
//            Connection con = null;
//            
//            String sql = "SELECT * FROM piste "; 
//            con = DBConnection.con;
//            
//            PreparedStatement ps = con.prepareStatement(sql);
//            
//            ResultSet rs = ps.executeQuery();
//            
//            while(rs.next()){
//                
//                list.add(new TableMenu1(rs.getInt(1),rs.getString(2)));
//            }
////           con.close();   
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//       trackidT.setCellValueFactory(new PropertyValueFactory<TableMenu1,Integer>("trackidT"));
//       typeidT.setCellValueFactory(new PropertyValueFactory<TableMenu1,String>("typeidT"));
//      
//     idTable.setItems(list);
//     
     
     //table LOad
     
     try{
            
            Connection con = null;
            
            String sql = "SELECT * FROM information "; 
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                load.add(new TableLoad(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
//           con.close();   
        }catch(Exception e){
            e.printStackTrace();
        }
     
    
     DateT.setCellValueFactory(new PropertyValueFactory<TableLoad,String>("DateT"));
     FlightT.setCellValueFactory(new PropertyValueFactory<TableLoad,String>("FlightT"));
     PlaneT.setCellValueFactory(new PropertyValueFactory<TableLoad,String>("PlaneT"));
     PisteT.setCellValueFactory(new PropertyValueFactory<TableLoad,String>("PistT"));
     HT.setCellValueFactory(new PropertyValueFactory<TableLoad,String>("HT"));
     CT.setCellValueFactory(new PropertyValueFactory<TableLoad,String>("CT"));
     
     tableViewF.setItems(load);
     
    }

    @FXML
    private void onClose(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
 
        if(event.getSource()==btn_all){
            pere.toFront();
        }
        else  if(event.getSource()==btn_landing){
            landing.toFront();
        }
        
         else  if(event.getSource()==btn_control){
           control.toFront();
        }
         else  if(event.getSource()==btn_liftoff){
         liftoff.toFront();
        }
         else  if(event.getSource()==btn_tracks){
            tracks.toFront();
        }
         else  if(event.getSource()==btn_theflights){
            theflights.toFront();
        }
    
    }

    @FXML
    private void go1(MouseEvent event) throws IOException {
        AnchorPane pane =FXMLLoader.load(getClass().getResource("suite1.fxml"));
            ((Stage)landing.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
        String flightn_Text=flightn.getText();
        String plann_Text=plann.getText();
        String lblDate_Text=lblDate.getText();
        
                
     
        FXMLLoader Loader= new FXMLLoader();
        Loader.setLocation(getClass().getResource("suite1.fxml"));
        try{
            Loader.load();
            
        }catch(IOException ex){
           ex.printStackTrace();
           
//           lblDate.setText(dp.getValue().toString());
           
          
            
//         Logger.getLogger(MenuController.class.getName().Log(Level.SEVERE,null,ex));
        }
        
       Suite1Controller display=Loader.getController();
        display.setText(flightn_Text,plann_Text,lblDate_Text);
       
        Parent p = Loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();
        
    }

    @FXML
    private void btnAdd(ActionEvent event) throws SQLException {
        TableMenu1 tablemenu1=new TableMenu1();
        tablemenu1.setTrackidT(Integer.parseInt(trackid.getText()));
        tablemenu1.setTypeidT(idtype.getText());
        
        // list.clear();
        
         
         new  DBConnection().insertPiste(tablemenu1);
         
        
        
}

    @FXML
    private void BtnRemove(ActionEvent event) {
         TableMenu1 tablemenu1=new TableMenu1();
        tablemenu1.setTrackidT(Integer.parseInt(trackid.getText()));
       // list.clear();
        new  DBConnection().deletePiste(tablemenu1);
    }

    @FXML
    private void Confirm(ActionEvent event) {
        lblDate.setText(dp.getValue().toString());
    }

    @FXML
    private void BtnLoadData(ActionEvent event) {
        
//    try{
//         String query= "SELECT * FROM information(Date,Idpiste,FlightN,PlaneN,Hangar,Control) VALUES (?,?,?,?,?,?);";
//           PreparedStatement prest = con.prepareStatement(query);
//         prest.setString(1,DateT.getText());
//          prest.setString(2,FlightT.getText());
//          prest.setString(3,PlaneT.getText());
//           prest.setString(4,PisteT.getText());
//           prest.setString(5,HT.getText());
//           prest.setString(6,CT.getText());
//           
//           
//           
//           Alert alert=new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("information of vol");
//            alert.setHeaderText(null);
//            alert.setContentText("The Flight has been regested!");
//            alert.showAndWait();
//            
//           
//           prest.execute();
//           prest.close();
//           
//           
//       }catch(Exception ex){
//           ex.printStackTrace();
//       }
//           //new  DBConnection().SaveData(VolSetter);
    }

    @FXML
    private void BtnSearch(ActionEvent event) {
    }
    
  FilteredList<TableLoad> filtredData= new FilteredList(load,e ->true);
  
  
    @FXML
    private void SearchField(KeyEvent event) {
        
        SearchField.textProperty().addListener((observableValue,oldValue, newValue) ->{
       
            
            filtredData.setPredicate((Predicate<? super TableLoad> ) (TableLoad std)->{
                
                if(newValue== null || newValue.isEmpty()){
                     return true;
                     
                     
                 }else if(std.getDateT().contains(newValue)){
                     return true;
                 }
                
                
                
                return false;
                
                 });
    });
           
      SortedList sort=new SortedList(filtredData);
      sort.comparatorProperty().bind(tableViewF.comparatorProperty());
       
      tableViewF.setItems(sort);
      
    }}
        
        
        
    


       
   
    
