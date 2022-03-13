/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genie;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import model.produit;

public class LogController implements Initializable {
    
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label label;
    @FXML
    private JFXTextField idUsername;
    @FXML
    private JFXTextField idPassword;
    @FXML
    private JFXComboBox<String> comboUser;
       ObservableList<produit> produit = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
             comboUser.getItems().addAll("Vendeur","Administrateur");
       
    }  
    private void OnLogin(ActionEvent event) throws SQLException {
         if (!idUsername.getText().matches("[a-zA-Z0-9_]{4,}")) {
            return;
        }
        if (idPassword.getText().isEmpty()) {
            return;
        }
        
        if(comboUser.getSelectionModel().getSelectedItem() == null)
            return;

        boolean isAdmin = comboUser.getSelectionModel().getSelectedItem().equalsIgnoreCase("Administrateur");
        
        int status = DBConnection.checkLogin(idUsername.getText().trim().toLowerCase(), idPassword.getText(), isAdmin);
        
        switch (status) {
            case 0: {
                try {
                    Stage stage = (Stage) idUsername.getScene().getWindow();
                    String userType;
                    if(isAdmin)
                        userType = "/administrateur/admin.fxml";
                    else
                        userType = "/vendeur/vendeur.fxml";
                        
                    Parent root = FXMLLoader.load(getClass().getResource(userType));
                    rootPane.getChildren().setAll(root);
                    stage.setScene(new Scene(root));
                } catch (IOException ex) {
                    Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
