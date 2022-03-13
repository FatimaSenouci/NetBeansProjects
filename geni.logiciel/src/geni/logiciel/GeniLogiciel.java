
package geni.logiciel;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class GeniLogiciel extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("genilogiciel/geni.logiciel/genilogiciel.fxml"));
        
        Scene scene = new Scene(root);
        
      stage.setScene(scene);
      stage.show();
       
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
