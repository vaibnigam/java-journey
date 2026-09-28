package introduction.multithreading;

import java.util.concurrent.CountDownLatch;

public class ThreadLifecycleDemo {

    /*
     * Shared object used to demonstrate BLOCKED and WAITING states.
     */
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========== JAVA THREAD LIFE CYCLE ==========\n");

        demonstrateNew();
        demonstrateRunnable();
        demonstrateBlocked();
        demonstrateWaiting();
        demonstrateTimedWaiting();
        demonstrateTerminated();

        System.out.println("\n========== DEMO COMPLETED ==========");
    }

    // =========================================================
    // 1. NEW STATE
    // =========================================================

    private static void demonstrateNew() {

        System.out.println("\n1. NEW STATE");

        /*
         * Creating a Thread object does not start its execution.
         *
         * Thread is in NEW state until start() is called.
         */

        Thread t = new Thread(() ->
                System.out.println("Thread executing")
        );

        System.out.println("Thread state: " + t.getState());

        // Output: NEW

        /*
         * Lifecycle:
         *
         * new Thread() ---> NEW
         * start()      ---> RUNNABLE
         */
    }

    // =========================================================
    // 2. RUNNABLE STATE
    // =========================================================

    private static void demonstrateRunnable() throws InterruptedException {

        System.out.println("\n2. RUNNABLE STATE");

        CountDownLatch started = new CountDownLatch(1);
        CountDownLatch finish = new CountDownLatch(1);

        Thread t = new Thread(() -> {

            /*
             * CountDownLatch signals that execution has started.
             */
            started.countDown();

            try {
                /*
                 * Thread remains actively executing while waiting
                 * on this loop.
                 *
                 * This is an intentional busy loop for demonstration.
                 */
                while (finish.getCount() > 0) {
                    // Keep executing
                }

            } finally {
                System.out.println("Runnable thread finishing");
            }
        });

        t.start();

        started.await();

        /*
         * Thread is actively executing.
         *
         * Java reports this as RUNNABLE.
         *
         * Note:
         * RUNNABLE includes both ready-to-run and currently-running.
         */

        System.out.println("Thread state: " + t.getState());

        // Expected: RUNNABLE

        finish.countDown();

        t.join();
    }

    // =========================================================
    // 3. BLOCKED STATE
    // =========================================================

    private static void demonstrateBlocked() throws InterruptedException {

        System.out.println("\n3. BLOCKED STATE");

        CountDownLatch lockAcquired = new CountDownLatch(1);

        Thread t;

        /*
         * Main thread acquires LOCK first.
         *
         * Another thread attempting to enter this synchronized
         * block must wait until the lock becomes available.
         */

        synchronized (LOCK) {

            t = new Thread(() -> {

                System.out.println("Worker trying to acquire lock");

                synchronized (LOCK) {

                    /*
                     * This code executes only after the worker
                     * successfully acquires the monitor lock.
                     */
                    System.out.println("Worker acquired lock");
                }
            });

            t.start();

            /*
             * Wait until worker has started and is attempting
             * to acquire the lock.
             */
            Thread.sleep(200);

            System.out.println("Thread state: " + t.getState());

            // Expected: BLOCKED

            /*
             * Main thread exits synchronized block here.
             * LOCK is released.
             */
        }

        t.join();

        /*
         * BLOCKED means waiting to acquire a monitor lock.
         */
    }

    // =========================================================
    // 4. WAITING STATE
    // =========================================================

    private static void demonstrateWaiting() throws InterruptedException {

        System.out.println("\n4. WAITING STATE");

        CountDownLatch ready = new CountDownLatch(1);

        Thread t = new Thread(() -> {

            synchronized (LOCK) {

                try {
                    System.out.println("Worker is going to wait");

                    ready.countDown();

                    /*
                     * wait() releases the monitor lock and
                     * places the thread in WAITING state.
                     *
                     * It waits until notification, interruption,
                     * or a spurious wakeup.
                     */
                    LOCK.wait();

                    System.out.println("Worker received notification");

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        t.start();

        ready.await();

        /*
         * Wait until worker actually enters WAITING.
         * This avoids checking too early.
         */
        waitForState(t, Thread.State.WAITING);

        System.out.println("Thread state: " + t.getState());

        // Expected: WAITING

        /*
         * Notify the waiting thread.
         *
         * The worker must reacquire LOCK before continuing.
         */
        synchronized (LOCK) {
            LOCK.notify();
        }

        t.join();

        /*
         * Important:
         * wait() releases the object's monitor lock.
         * sleep() does not release monitor locks.
         */
    }

    // =========================================================
    // 5. TIMED_WAITING STATE
    // =========================================================

    private static void demonstrateTimedWaiting() throws InterruptedException {

        System.out.println("\n5. TIMED_WAITING STATE");

        CountDownLatch started = new CountDownLatch(1);

        Thread t = new Thread(() -> {

            try {
                System.out.println("Worker going to sleep");

                started.countDown();

                /*
                 * sleep(5000) puts the thread into TIMED_WAITING.
                 *
                 * It waits for approximately 5 seconds unless
                 * interrupted.
                 *
                 * sleep() does not release monitor locks.
                 */
                Thread.sleep(5000);

                System.out.println("Worker woke up");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t.start();

        started.await();

        waitForState(t, Thread.State.TIMED_WAITING);

        System.out.println("Thread state: " + t.getState());

        // Expected: TIMED_WAITING

        /*
         * Interrupt the thread so the demonstration does not
         * need to wait for the entire 5 seconds.
         */
        t.interrupt();

        t.join();
    }

    // =========================================================
    // 6. TERMINATED STATE
    // =========================================================

    private static void demonstrateTerminated() throws InterruptedException {

        System.out.println("\n6. TERMINATED STATE");

        Thread t = new Thread(() -> {

            System.out.println("Thread executing task");

            /*
             * Once run() completes, the thread terminates.
             */
        });

        t.start();

        /*
         * join() makes the main thread wait until t completes.
         */
        t.join();

        System.out.println("Thread state: " + t.getState());

        // Expected: TERMINATED

        /*
         * A terminated thread cannot be restarted.
         *
         * Calling t.start() again throws:
         * IllegalThreadStateException
         */
    }

    // =========================================================
    // HELPER METHOD
    // =========================================================

    private static void waitForState(
            Thread thread,
            Thread.State expectedState
    ) throws InterruptedException {

        /*
         * Thread states can change very quickly.
         *
         * This helper waits until the expected state is observed.
         *
         * It is only for this demonstration, not a recommended
         * production synchronization technique.
         */

        while (thread.getState() != expectedState) {
            Thread.sleep(1);
        }
    }
}