package bd7;

import bd7.models.Person;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField fieldId, fieldNom, fieldPrenom, fieldDate,  fieldPromo;

    
     @FXML
    private TableView<Person> tableV;

    @FXML
    private TableColumn<Person, Integer> idTab;

    @FXML
    private TableColumn<Person, String> namet;

    @FXML
    private TableColumn<Person, String> prenamet;

    @FXML
    private TableColumn<Person, String> ddat;

    @FXML
    private TableColumn<Person, Integer> promot;

    @FXML
    private TextField search;
    


    
    ObservableList<Person> persons = FXCollections.observableArrayList();
    
    
    
    @FXML
    private void searchA(){
        
        search.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(search.textProperty().get().isEmpty()){
                    tableV.setItems(persons);
                    return;
                }
                ObservableList<Person> items = FXCollections.observableArrayList();
                ObservableList<TableColumn<Person,?>> column = tableV.getColumns();
                
                for(int row = 0;row < persons.size(); row++){
                    for(int col = 0;col < column.size();col++){
                        TableColumn tabVar = column.get(col);
                        String cellData = tabVar.getCellData(persons.get(row)).toString();
                        cellData = cellData.toLowerCase();
                        
                        if(cellData.contains(search.getText().toLowerCase()) && cellData.startsWith(search.getText().toLowerCase())){
                            items.add(persons.get(row));
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
            
            String sql = "Select * from etudiant ";
            con = DBConnection.getConnection();
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                persons.add(new Person(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
            }
            con.close();
            
            
        }catch(Exception e){
            
        }
        
        idTab.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
        namet.setCellValueFactory(new PropertyValueFactory<Person,String>("nom"));
        prenamet.setCellValueFactory(new PropertyValueFactory<Person,String>("prenom"));
        ddat.setCellValueFactory(new PropertyValueFactory<Person,String>("dateNaiss"));
        promot.setCellValueFactory(new PropertyValueFactory<Person,Integer>("promo"));
        
        
        tableV.setItems(persons);
    }
    
    @FXML
    private void onInsert() {
        Person person = new Person();
        person.setId(Integer.parseInt(fieldId.getText()));
        person.setNom(fieldNom.getText());
        person.setPrenom(fieldPrenom.getText());
        person.setDateNaiss(fieldDate.getText());
        person.setPromo(Integer.parseInt(fieldPromo.getText()));
        
        new DBConnection().insertPerson(person);
    }


    
}



