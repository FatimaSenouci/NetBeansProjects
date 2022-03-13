
package Synchronized.Synchronisation.Synchro;

import java.util.concurrent.Semaphore;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    
    private static Text waitingText; // this text printed in the left top of the window "File Waiting"
    private static Text releaseText; // this text printed in the left bottom of the window "File Release"
    
    private static ImageView imageAtm; // This the Image of ATM
    static ImageView [] manImage; // This is the man Images
    
    private static Text processesText; // This text printed in the left center of the window "Processes :"
    static TextArea processesTextArea; // This TextArea using to print the status of precess (what happens)
    
    static Button btnStart; // This Button using to start the Thread
    static Button btnReset; // This Button using to initialize the window
    
    static int counterReset; // I use this counter to enable the Button Reset if all proccess finished
    
    private Label numberOfPlaneText; // This Text printed in the right top of the window ("N° Users:")
    private static ComboBox numberOfPlaneComboBox; // I use this Combox for the user choose the number of Thread
    
//    final static String [] manName = {"Man Black", "Man Red", "Man Yellow", "Man Blue", "Man Cyan"}; // This is the name Of the Thread
    
    final static String [] manName = {"plane1", "plane2", "plane3", "plane4", "plane5"};
    
    @Override
    public void start(Stage primaryStage) {
        /* Start Initialize Part */
        
        Pane root = new Pane();
        
        numberOfPlaneText = new Label("N°of Plane:");
        numberOfPlaneText.setLayoutX(210); // Change position X of the element
        
        numberOfPlaneText.setLayoutY(30); // Change position Y of the element
        numberOfPlaneComboBox = new ComboBox();
        numberOfPlaneComboBox.getItems().addAll("1", "2", "3", "4", "5");
        numberOfPlaneComboBox.setLayoutX(230);
        numberOfPlaneComboBox.setLayoutY(60);
        numberOfPlaneComboBox.setValue("4"); // Make the default value 4
        
        counterReset = Integer.parseInt(numberOfPlaneComboBox.getValue().toString());
        
        btnStart = new Button("Start");
        btnStart.setLayoutX(400);
        btnStart.setLayoutY(30);
        
        imageAtm = new ImageView("com/Synchronisation/images/piste.PNG");
        imageAtm.setLayoutX(300);
        imageAtm.setLayoutY(100);
        imageAtm.setFitWidth(500); // Change the Width of the Image
        imageAtm.setFitHeight(170); // Change the Height of the Image
        
        btnReset = new Button("Reset");
        btnReset.setLayoutX(650);
        btnReset.setLayoutY(30);
        btnReset.setDisable(true); // Diable the btnReset => you can't Click of the Button
        
        waitingText = new Text("Plane Waiting");
        waitingText.setLayoutX(10);
        waitingText.setLayoutY(70);
        
        
        manImage = new ImageView[manName.length];
        
        for (int i = 0; i < manImage.length; i++) {
            manImage[i] = new ImageView("com/Synchronisation/images/" + manName[i] + ".jpg");
            manImage[i].setLayoutX(10 + 90 * i);
            manImage[i].setLayoutY(130);
            manImage[i].setFitWidth(60);
            manImage[i].setFitHeight(70);
            manImage[i].setOpacity(0); // Make this Image Invisible => like: setVisible(false)
        }
        
        processesText = new Text("Processes :");
        processesText.setLayoutX(100);
        processesText.setLayoutY(320);
        
        processesTextArea = new TextArea();
        processesTextArea.setLayoutX(10);
        processesTextArea.setLayoutY(350);
        processesTextArea.setPrefSize(350, 170);
        processesTextArea.setEditable(false); // The user can not change the content of this TextArea
        
        releaseText = new Text("The Plane is in The Air");
        releaseText.setLayoutX(500);
        releaseText.setLayoutY(350);
        
        /* End Initialize Part */
        
        /* Start Action Part */
        
        numberOfPlaneComboBox.setOnAction(e -> {
            counterReset = Integer.parseInt(numberOfPlaneComboBox.getValue().toString());
        });
        
        btnStart.setOnAction(e -> {
            
            btnStart.setDisable(true);
            numberOfPlaneComboBox.setDisable(true);
            Semaphore machine = new Semaphore(1);
            Semaphore mutex = new Semaphore(1);
            
            for(int i = 0; i < Integer.parseInt(numberOfPlaneComboBox.getValue().toString()); i++)
                new Avion(machine, manName[i], mutex);
            
        });
        
        btnReset.setOnAction(e -> {
            
            for(int i = 0; i < Integer.parseInt(numberOfPlaneComboBox.getValue().toString()); i++){
                manImage[i].setTranslateX(0);
                manImage[i].setTranslateY(0);
                manImage[i].setOpacity(0);
            }
            
            processesTextArea.setText("");
            counterReset = Integer.parseInt(numberOfPlaneComboBox.getValue().toString());
            numberOfPlaneComboBox.setDisable(false);
            btnReset.setDisable(true);
            btnStart.setDisable(false);
        });
        
        /* End Action Part */
        
        root.getChildren().addAll(waitingText, btnStart, btnReset, imageAtm, processesText, processesTextArea, releaseText, numberOfPlaneComboBox, numberOfPlaneText);
        for(ImageView image : manImage) // Add all man Image to the Scane
            root.getChildren().add(image);
        
        Scene scene = new Scene(root, 800, 530);
        
        scene.getStylesheets().add("Synchronized/Synchronisation/Synchro/style.css");
        primaryStage.setTitle("ATM Simulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}