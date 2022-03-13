package systm;

import java.util.concurrent.Semaphore;

/**
 *
 * @author hp
 */
public class Main {

    static boolean one = true, two = true;
    static Semaphore mainSemaphore = new Semaphore(2);
    static Semaphore booleanTwoSemaphore = new Semaphore(1);
    static Semaphore booleanOneSemaphore = new Semaphore(1);

    public static void main(String[] args) {

        Plane[] data = new Plane[8];
        for (int i = 0; i < 8; i++) {
            data[i] = new Plane(i);
            data[i].start();
        }
    }

}
