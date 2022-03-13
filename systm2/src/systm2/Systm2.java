
package systm2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.concurrent.Semaphore;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Systm2  {
     static boolean one = true, two = true;
    static Semaphore mainSemaphore = new Semaphore(2);
    static Semaphore booleanTwoSemaphore = new Semaphore(1);
    static Semaphore booleanOneSemaphore = new Semaphore(1);
//public Systm2(){
//    setSize(800,700);
//      setLocationRelativeTo(null);
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     // setResizable(true);
//      setVisible(true);
//      setTitle("Aeroport");
//      
//   
//
//
//}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
          Plane[] data = new Plane[5];
        for (int i = 0; i < 5; i++) {
            data[i] = new Plane(i);
            data[i].start();
        }
//        
//          Systm2 T=new Systm2();
//       T.setVisible(true);
        // TODO code application logic here
    }
    
}
