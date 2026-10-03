package introduction.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ArrayListThreadDemo {

    // Shared ArrayList containing 1000 entries
    private static final List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        // Step 1: Populate ArrayList
        for (int i = 1; i <= 1000; i++) {
            numbers.add(i);
        }

        System.out.println("Initial Size: " + numbers.size());

        // Step 2: Create multiple threads
        Thread t1 = new Thread(() -> readList(), "Thread-1");
        Thread t2 = new Thread(() -> readList(), "Thread-2");
        Thread t3 = new Thread(() -> readList(), "Thread-3");
        Thread t4 = new Thread(() -> readList(), "Thread-4");

        // Step 3: Start threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Step 4: Wait for all threads to complete
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        System.out.println("All threads completed.");
    }

    private static void readList() {

        System.out.println(
                Thread.currentThread().getName()
                        + " reading list. Size: " + numbers.size()
        );

        // Read all elements
        for (Integer number : numbers) {
            // Processing each number
        }

        System.out.println(
                Thread.currentThread().getName()
                        + " completed reading."
        );
    }
}
