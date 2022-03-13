import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import dao.DBConnection;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



public class LoginController implements Initializable {
    
    JFXSnackbar errorMsg;
    
    @FXML
    private AnchorPane rightBox;
    @FXML
    private JFXTextField Username;
    @FXML
    private JFXPasswordField Password;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
           errorMsg= new JFXSnackbar(rightBox);
        
    }    

    @FXML
    private void BtnLogin(ActionEvent event) {
        if(Username.getText().isEmpty()){
            errorMsg.show("Username is emty!!",1600);
          if(!Username.getText().matches("[a-zA-Z0-9]{5,}")){  
            return;
        }
         if(Password.getText().isEmpty()){
            errorMsg.show("Password is emty!!",1600);
            return;
        }
        System.out.println("Username:"+Username.getText());
        System.out.println("Password:"+Password.getText());
        
         errorMsg.show("success", 1800);
    }
int status =DBConnection.checkLogin(Username.getText().trim().toLowerCase(), Password.getText());

       switch (status){
         case 0:{
          Stage stage =(Stage) Username.getScene().getWindow();
          
          
       //  Parent root=null;
            try {
               Parent root = FXMLLoader.load(getClass().getResource("/menu/menu.fxml"));
               
              
             
           // if(root==null) System.out.println("Root is null !");
            
             stage.setScene(new Scene(root));
            } catch (IOException ex) {
                
                ex.printStackTrace(); 
                
                //Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
}
break;

case -1:JOptionPane.showMessageDialog(null,"Connection Failed"); break;
case 1:JOptionPane.showMessageDialog(null,"Username Or Password Wrong"); break;

}
    }

    @FXML
      private void BtnExit(ActionEvent event) {
        Platform.exit();
        
    }
    
}
