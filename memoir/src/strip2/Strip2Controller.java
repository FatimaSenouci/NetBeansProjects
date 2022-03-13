
package strip2;

import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Stripmodel;
import model.strip2model;


public class Strip2Controller implements Initializable {

    @FXML
    private AnchorPane idPanStrip2;
    @FXML
    private JFXTextField id1;
    @FXML
    private JFXTextField id3;
    @FXML
    private JFXTextField id5;
    @FXML
    private JFXTextField id2;
    @FXML
    private JFXTextField id4;
    @FXML
    private JFXTextField id610;

    ObservableList<strip2model> strip2 = FXCollections.observableArrayList();
    @FXML
    private HBox idStripj;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            try{
            
            Connection con = null;
            
            String sql = "Select * from strip2 ";
            con = DBConnection.con;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                strip2.add(new strip2model(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
            }
//            con.close();
            
            
        }catch(Exception e){
            
        }
        // TODO
    } 
        // TODO
       

//    @FXML
//    private void goStrip2(MouseEvent event) throws IOException {
//         AnchorPane pane =FXMLLoader.load(getClass().getResource("/PlantDeVol/Plant.fxml"));
//     ((Stage)idPanStrip2.getScene().getWindow()).setScene(new Scene(pane));
//    }

    @FXML
    private void Gostrip2(MouseEvent event) throws IOException {
           AnchorPane pane =FXMLLoader.load(getClass().getResource("/PlantDeVol/Plant.fxml"));
     ((Stage)idPanStrip2.getScene().getWindow()).setScene(new Scene(pane));
    }
    
    
       public void setText(String id1,String id2,String id3,String id4,String id5,String id6){
    this.id1.setText(id1);
    this.id2.setText(id2);
    this.id3.setText(id3);
    this.id4.setText(id4); 
    this.id5.setText(id5);
    this.id610.setText(id6);
    
    
}

    @FXML
    private void OnSaveStrip2(ActionEvent event) {
        strip2model  strip2model = new strip2model();
         
        strip2model.setId1(id1.getText());
        strip2model.setId2(id2.getText());
        strip2model.setId3(id3.getText());
        strip2model.setId4(id4.getText());
        strip2model.setId5(id5.getText());
          strip2model.setId6(id610.getText());
       
        strip2.clear();
     //   System.out.println(Stripmodel.getId1() + " " + Stripmodel.getId2() + " " + Stripmodel.getId3()+ " " + Stripmodel.getId4() + " " + Stripmodel.getId5()+ " " + Stripmodel.getId7());
        
        new DBConnection().insertStrip2(strip2model);
    }

    @FXML
    private void OnPrint(ActionEvent event) {
             print(idStripj);
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
}
