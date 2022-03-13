
package Genie_logiciel;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class LoginController extends Application {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXTextField idUsername;
    @FXML
    private JFXTextField idPassword;
    @FXML
    private JFXComboBox<String> ComboUser;

   
    public void initialize(URL url, ResourceBundle rb) {
       ComboUser.getItems().addAll("Vendeur", "Administrateur");
    
     
    }    

    @FXML
    private void OnLogin(ActionEvent event) throws SQLException {
         if (!idUsername.getText().matches("[a-zA-Z0-9_]{4,}")) {
            return;
        }
        if (idPassword.getText().isEmpty()) {
            return;
        }
        
        if(ComboUser.getSelectionModel().getSelectedItem() == null)
            return;

        boolean isAdmin = ComboUser.getSelectionModel().getSelectedItem().equalsIgnoreCase("Admin");
        
        int status = DBConnection.checkLogin(idUsername.getText().trim().toLowerCase(), idPassword.getText(), isAdmin);
        
        switch (status) {
            case 0: {
                try {
                    Stage stage = (Stage) idUsername.getScene().getWindow();
                    String userType;
                    if(isAdmin)
                        userType = "/administrateur/admin.fxml";
                    else
                        userType = "/vendeur1/vendeur.fxml";
                        
                    Parent root = FXMLLoader.load(getClass().getResource(userType));
                    rootPane.getChildren().setAll(root);
                    stage.setScene(new Scene(root));
                } catch (IOException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            break;
            case -1:
                JOptionPane.showMessageDialog(null, "Connection Field");
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Username or password wrong");
                break;
        }
    }

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
 public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    

