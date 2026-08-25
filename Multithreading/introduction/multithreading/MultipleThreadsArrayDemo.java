package introduction.multithreading;
public class MultipleThreadsArrayDemo {

    public static void main(String[] args) {

        // Step 1: 3 Thread objects ko store karne ke liye Thread array banaya
        Thread[] threads = new Thread[3];

        // Step 2: 3 threads create karne ke liye loop
        for (int i = 0; i < 3; i++) {

            // Current thread ka number save kiya
            // Lambda is variable ko access/capture karega
            int threadNumber = i;

            /*
             * Lambda expression:
             *
             * ()     -> parameters
             *          Runnable ke run() method mein koi parameter nahi hai,
             *          isliye () hai.
             *
             * ->     -> Lambda operator
             *          "In parameters ke saath ye code execute karo."
             *
             * { }    -> Lambda body
             *          Actual code jo execute hoga.
             *
             * Ye lambda Runnable ke run() method ka implementation hai.
             *
             * Lambda ka equivalent:
             *
             * new Runnable() {
             *     @Override
             *     public void run() {
             *         System.out.println(...);
             *     }
             * }
             */

            threads[i] = new Thread(() -> {

                // Lambda body
                // threadNumber ko lambda ne surrounding scope se capture kiya
                System.out.println(
                    "Thread number " + threadNumber
                    + " running - "
                    + Thread.currentThread().getName()
                );

            });

        }

        // Step 5: Ab saare created threads ko start kar rahe hain
        for (int i = 0; i < 3; i++) {

            threads[i].start();

        }
    }
}