
import java.io.IOException;
import java.util.concurrent.Semaphore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Main extends Application {
    
    static boolean one = true, two = true;
    static Semaphore mainSemaphore = new Semaphore(2);
    static Semaphore booleanTwoSemaphore = new Semaphore(1);
    static Semaphore booleanOneSemaphore = new Semaphore(1);
    
    
    
    
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      
       Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
launch(args);
//        Plane[] data = new Plane[5];
//        for (int i = 0; i < 5; i++) {
//            data[i] = new Plane(i);
//            data[i].start();
//        }
    }}
//class Plane extends Thread{
//    int currentPiste , id;
//    public Plane(int id) {
//        this.id = id;
//    }
//
//    @Override
//    public void run() {
//
//        try {
//            
//            System.out.println("Plane "+ id +" is Waiting");
//            Thread.sleep(5000);
//            System.out.println("Plane "+ id +"  want to Fly.");
//            Main.mainSemaphore.acquire();
//            Main.booleanOneSemaphore.acquire();
//            if(Main.one) {
//                Main.one = false;
//                currentPiste = 1;
//                Main.booleanOneSemaphore.release();
//                System.out.println("The Piste One is Empty.");
//                
//            }else {
//                Main.booleanOneSemaphore.release();
//                Main.booleanTwoSemaphore.acquire();
//                Main.two = false;
//                currentPiste = 2;
//                Main.booleanTwoSemaphore.release();
//                System.out.println("The Piste Two is Empty.");
//                
//            }
//            System.err.println("Plane "+ id +" is Flying in "+currentPiste+" piste!!!!!");
//            Thread.sleep(5000);
//            System.err.println("Plane "+ id +" in this air");
//            if (currentPiste == 1) {
//                Main.booleanOneSemaphore.acquire();
//                Main.one = true;
//                Main.booleanOneSemaphore.release();
//            }else {
//                Main.booleanTwoSemaphore.acquire();
//                Main.two = true;
//                Main.booleanTwoSemaphore.release();
//            }
//            Main.mainSemaphore.release();
//
//
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Plane.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
//
//    

