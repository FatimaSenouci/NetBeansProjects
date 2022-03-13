
package systm2;

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
            Systm2.mainSemaphore.acquire();
           Systm2.booleanOneSemaphore.acquire();
            if(Systm2.one) {
                Systm2.one = false;
                currentPiste = 1;
               Systm2.booleanOneSemaphore.release();
                System.out.println("The Piste One is Empty.");
                
            }else {
                Systm2.booleanOneSemaphore.release();
               Systm2.booleanTwoSemaphore.acquire();
               Systm2.two = false;
                currentPiste = 2;
               Systm2.booleanTwoSemaphore.release();
                System.out.println("The Piste Two is Empty.");
                
            }
            System.err.println("Plane "+ id +" is Flying in "+currentPiste+" piste!!!!!");
            Thread.sleep(5000);
            System.err.println("Plane "+ id +" in this air");
            if (currentPiste == 1) {
               Systm2.booleanOneSemaphore.acquire();
                Systm2.one = true;
                Systm2.booleanOneSemaphore.release();
            }else {
               Systm2.booleanTwoSemaphore.acquire();
                Systm2.two = true;
               Systm2.booleanTwoSemaphore.release();
            }
         Systm2.mainSemaphore.release();


        } catch (InterruptedException ex) {
            Logger.getLogger(Plane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
