/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import Controleur.GuichierSetter;
import Controleur.Seterjaune;
import Controleur.Suite1Controller;
import Synchronized.Synchronisation.Synchro.Main;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Stripmodel;
import model.TableLoad;
import model.TableMenu1;
import model.strip2model;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MenuController implements Initializable {
  ObservableList<String> combos=FXCollections.observableArrayList("Landing","Lift-Of");
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
    
    private TableView<TableMenu1> idTable;
    private TableColumn<TableMenu1, Integer> trackidT;
    private TableColumn<TableMenu1, String> typeidT;
    
   
    
      ObservableList<TableMenu1> list = FXCollections.observableArrayList();
     ///pichr 
  
    @FXML private DatePicker dp;
    @FXML
    private Label lblDate;
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
    private JFXButton GoSynchro;
    @FXML
    private HBox idStripb1;
    @FXML
    private JFXTextField id11;
    @FXML
    private JFXTextField id21;
    @FXML
    private JFXTextField id31;
    @FXML
    private JFXTextField id41;
    @FXML
    private JFXTextField id51;
    @FXML
    private JFXTextField id61;
    @FXML
    private JFXTextField id71;
    @FXML
    private JFXTextField id111;
    @FXML
    private JFXTextField id211;
    @FXML
    private JFXTextField id112;
    @FXML
    private JFXTextField id212;
    @FXML
    private JFXTextField id113;
    @FXML
    private JFXTextField id213;
    @FXML
    private JFXTextField id114;
    @FXML
    private JFXTextField id214;
    @FXML
    private HBox idStripb11;
    @FXML
    private JFXTextField id311;
    @FXML
    private JFXTextField id411;
    @FXML
    private JFXTextField id511;
    @FXML
    private JFXTextField id611;
    @FXML
    private JFXTextField id711;
    @FXML
    private JFXTextField id1111;
    @FXML
    private JFXTextField id2111;
    @FXML
    private JFXTextField id1121;
    @FXML
    private JFXTextField id2121;
    @FXML
    private JFXTextField id1131;
    @FXML
    private JFXTextField id2131;
    @FXML
    private JFXTextField id1141;
    @FXML
    private JFXTextField id2141;
    @FXML
    private HBox idStripb2;
    @FXML
    private JFXTextField id12;
    @FXML
    private JFXTextField id22;
    @FXML
    private JFXTextField id121;
    @FXML
    private JFXTextField id221;
    @FXML
    private JFXTextField id122;
    @FXML
    private JFXTextField id222;
    @FXML
    private JFXTextField id123;
    @FXML
    private JFXTextField id223;
    @FXML
    private JFXTextField id124;
    @FXML
    private JFXTextField id224;
    @FXML
    private JFXTextField id125;
    @FXML
    private JFXTextField id225;
    @FXML
    private JFXTextField id126;
    @FXML
    private JFXTextField id226;
    @FXML
    private JFXTextField id127;
    @FXML
    private JFXTextField id227;
    @FXML
    private JFXTextField id24;
    @FXML
    private JFXTextField id26;
    @FXML
    private JFXTextField id1717;
    @FXML
    private TableView<Stripmodel> tableB;
    ObservableList<Stripmodel>stripB = FXCollections.observableArrayList();
     ObservableList<strip2model>stripJ = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Stripmodel,String> departureT;
    @FXML
    private TableColumn<Stripmodel,String> destinationT;
    @FXML
    private TableColumn<Stripmodel,String> typeT;
    @FXML
    private TableColumn<Stripmodel,String> speedT;
    @FXML
    private TableColumn<Stripmodel,String> idT;
    @FXML
    private TableColumn<Stripmodel,String> timeT;
    @FXML
    private TableColumn<Stripmodel,String> levelT;
    @FXML
    private TableView<strip2model> tableJ;
    @FXML
    private TableColumn<strip2model, String> departurT;
        @FXML
    private TableColumn<strip2model, String> DestinationT;

    @FXML
    private TableColumn<strip2model, String> TypeT;

    @FXML
    private TableColumn<strip2model, String> SpeedT;

    @FXML
    private TableColumn<strip2model, String> IdT;
    @FXML
    private JFXTextField id5;
    @FXML
    private JFXTextField id1;
    @FXML
    private JFXTextField id3;
    @FXML
    private JFXTextField id2;
    @FXML
    private JFXTextField id4;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ComboBox<String> comboland;
    @FXML
    private HBox jaune;
    @FXML
    private HBox bleu;
    public static String selectDepar;
     public static String selectariv;
       public static String selecttype;
         public static String selecspeed;
           public static String selectid;
             public static String selecttime;
               public static String selectlevel;
           
    @FXML
    private void getDate(){
        
      //Suite1Controller.date =  dp.getValue().toString();
    }

     public DatePicker getDp() {
        return dp;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         comboland.setItems(combos);
        comboland.setValue("Landing");
        
                   flightn.textProperty().addListener(new ChangeListener<String>() { // TextField Accept only Number
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                   flightn.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
                   plann.textProperty().addListener(new ChangeListener<String>() { // TextField Accept only Number
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                   plann.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
//         try{
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
//     
//     //table LOad
     
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
     
        // TODO
            try{
            
            Connection con = null;
            
            String sql = "SELECT * FROM stripb "; 
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rss = ps.executeQuery();
            
            while(rss.next()){
                
                stripB.add(new Stripmodel(rss.getString(1),rss.getString(2),rss.getString(3),rss.getString(4),rss.getString(5),rss.getString(6),rss.getString(7)));
            }
//           con.close();   
        }catch(Exception e){
            e.printStackTrace();
        }
     
    
     departureT.setCellValueFactory(new PropertyValueFactory<Stripmodel,String>("id1"));
     destinationT.setCellValueFactory(new PropertyValueFactory<Stripmodel,String>("id2"));
     typeT.setCellValueFactory(new PropertyValueFactory<Stripmodel,String>("id3"));
    speedT.setCellValueFactory(new PropertyValueFactory<Stripmodel,String>("id4"));
      idT.setCellValueFactory(new PropertyValueFactory<Stripmodel,String>("id5"));
    timeT.setCellValueFactory(new PropertyValueFactory<Stripmodel,String>("id6"));
levelT.setCellValueFactory(new PropertyValueFactory<Stripmodel,String>("id7"));
     
     tableB.setItems(stripB);
     
       try{
            
            Connection con = null;
            
            String sql = "SELECT * FROM strip2 "; 
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rss = ps.executeQuery();
            
            while(rss.next()){
                
                stripJ.add(new strip2model(rss.getString(1),rss.getString(2),rss.getString(3),rss.getString(4),rss.getString(5),rss.getString(6)));
            }
//           con.close();   
        }catch(Exception e){
            e.printStackTrace();
        }
     
    
     departurT.setCellValueFactory(new PropertyValueFactory<strip2model,String>("id1"));
   DestinationT.setCellValueFactory(new PropertyValueFactory<strip2model,String>("id2"));
     TypeT.setCellValueFactory(new PropertyValueFactory<strip2model,String>("id3"));
    SpeedT.setCellValueFactory(new PropertyValueFactory<strip2model,String>("id4"));
      IdT.setCellValueFactory(new PropertyValueFactory<strip2model,String>("id5"));
  
     
     tableJ.setItems(stripJ);
    }    
    

    @FXML
    private void onClose(ActionEvent event) {
         Platform.exit();
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
      
    }
    


    @FXML
    private void go1(MouseEvent event) throws IOException {
       
         AnchorPane pane =FXMLLoader.load(getClass().getResource("suite1.fxml"));
            ((Stage)landing.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
//        
        
        
         String flightn_Text=flightn.getText();
        String plann_Text=plann.getText();
        String lblDate_Text=lblDate.getText();
        
                
     
        FXMLLoader Loader= new FXMLLoader();
        Loader.setLocation(getClass().getResource("/Controleur/suite1.fxml"));
        try{
            Loader.load();
            
        }catch(IOException ex){
           ex.printStackTrace();

        }
        
       Suite1Controller display=Loader.getController();
       
     display.setText(flightn_Text,plann_Text,lblDate_Text);
       
        Parent p = Loader.getRoot();
        Stage stage =new Stage();
        stage.setScene(new Scene(p));
        stage.showAndWait();
    }

    @FXML
    private void Confirm(ActionEvent event) {
         lblDate.setText(dp.getValue().toString());
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
    private void Gosynchro(MouseEvent event) throws IOException {
       
       
               
//          AnchorPane pane =FXMLLoader.load(getClass().getResource("//Synchronization.exe"));
//          ((Stage)liftoff.getScene().getWindow()).setScene(new Scene(pane));
//        URL pane =liftoff.getClass().getResource("/Synchronized/Synchronization/Synchro/ATMSimulator.exe");
//        ((Stage)liftoff.getScene().getWindow()).setScene(new Scene(liftoff));
//URL pane = liftoff.getClass().getResource("/Synchronized/Synchronisation/Synchro/Main.java");
//((Stage)liftoff.getScene().getWindow()).setScene(new Scene(liftoff));


    } 
int index=-1;
    @FXML
    
    private void PlayStripB(MouseEvent event) {
        int selectedIndex = tableB.getSelectionModel().getSelectedIndex();
        selectDepar = departurT.getCellData(selectedIndex);
         selectariv = DestinationT.getCellData(selectedIndex);
          selectDepar = TypeT.getCellData(selectedIndex);
           selectDepar = SpeedT.getCellData(selectedIndex);
            selectDepar = IdT.getCellData(selectedIndex);
             selectDepar = timeT.getCellData(selectedIndex);
              selectDepar = levelT.getCellData(selectedIndex);
        
                
        

//  Stripmodel guichier =tableB.getSelectionModel().getSelectedItem();
//        if(tableB==null){
//             String departurT =tableB.getId();
//              String destinationT =tableB.getId();
//               String typeT =tableB.getId();
//               String speedT =tableB.getId();
//               String idT =tableB.getId();
//               String timeT =tableB.getId();
//               String levelT =tableB.getId();
//             
//               
//               
//        id1.setText("Null");
//        id2.setText("Null");
//        id3.setText("Null");
//        id4.setText("Null");
//        id5.setText("Null");
//      
//        
//        id1.setText(""+departurT);
//         id2.setText(""+destinationT);
//         id3.setText(""+typeT);
//         id4.setText(""+speedT);
//         id5.setText(""+idT);
//         }
      
        
    
    
    }
    
    


//  else {
//       
////   String id1 = strip.getId1();
////   String id2 = strip.getId2();
////   String id3 = strip.getId3();
////   String id4 = strip.getId4();
////   String id5 = strip.getId5();
////   String id6 = strip.getId6();
//   
//   }
//        
//    }
//
//    @FXML
//    private void tostripB(ActionEvent event) {
//   
//        
//    }
//    

    @FXML
    private void tablejaune(MouseEvent event) {
        strip2model jaune =tableJ.getSelectionModel().getSelectedItem();
        if(jaune==null){IdT.setText("Null");
        departurT.setText("Null");
        DestinationT.setText("Null");
       TypeT.setText("Null");
        SpeedT.setText("Null");}else{
            String departurT =jaune.getId1();
       String DestinationT =jaune.getId2();
        String TypeT=jaune.getId3();
        String SpeedT=jaune.getId4();
         String IdT=jaune.getId5();  
        
       
        id1.setText(""+departurT);
         id2.setText(""+DestinationT);
         id3.setText(""+TypeT);
         id4.setText(""+SpeedT);
         id5.setText(""+IdT);}
    }

    @FXML
    private void retourlogin(MouseEvent event) throws IOException {
         AnchorPane pane =FXMLLoader.load(getClass().getResource("/memoir/FXMLDocument.fxml"));
    ((Stage)rootPane.getScene().getWindow()).setScene(new Scene(pane));
    }

    @FXML
    private void Onprint(ActionEvent event) {
           print(jaune);
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

    @FXML
    private void OnPrintB(ActionEvent event) {
          print(bleu);
    }
    
}
