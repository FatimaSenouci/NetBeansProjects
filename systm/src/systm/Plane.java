package systm;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Plane extends Thread {

   
    int currentPiste , id;
    public Plane(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        try {
            System.out.println("Plane "+ id +" is Waiting");
            Thread.sleep(5000);
            System.out.println("Plane "+ id +"  want to Fly.");
            Main.mainSemaphore.acquire();
            Main.booleanOneSemaphore.acquire();
            if(Main.one) {
                
              Main.one = false;
                currentPiste = 1;
                Main.booleanOneSemaphore.release();
                System.out.println("The Piste One is Empty.");
                
            }else {
                Main.booleanOneSemaphore.release();
                Main.booleanTwoSemaphore.acquire();
                Main.two = false;
                currentPiste = 2;
                Main.booleanTwoSemaphore.release();
                System.out.println("The Piste Two is Empty.");
                
            }
            System.err.println("Plane "+ id +" is Flying in "+currentPiste+" piste!!!!!");
            Thread.sleep(5000);
            System.err.println("Plane "+ id +" in this air");
            if (currentPiste == 1) {
                Main.booleanOneSemaphore.acquire();
                Main.one = true;
                Main.booleanOneSemaphore.release();
            }else {
                Main.booleanTwoSemaphore.acquire();
               Main.two = true;
                Main.booleanTwoSemaphore.release();
            }
            Main.mainSemaphore.release();


        } catch (InterruptedException ex) {
            Logger.getLogger(Plane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
