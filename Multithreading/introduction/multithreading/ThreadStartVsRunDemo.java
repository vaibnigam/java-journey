package introduction.multithreading;
public class ThreadStartVsRunDemo {

    public static void main(String[] args) {

        // ============================================
        // RUNNABLE r1 — "Instruction Sheet" for Thread 1
        // ============================================
        // Runnable ek interface hai jisme sirf EK method hota hai: run()
        // Ye batata hai "kaam kya karna hai" — lekin khud koi thread nahi hai.
        // Yahan anonymous class use kiya hai Runnable implement karne ke liye.
        Runnable r1 = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {

                    // Thread.currentThread().getName() batata hai
                    // ki YE CODE ABHI KIS THREAD PAR CHAL RAHA HAI.
                    // Isse hum confirm kar sakte hain naya thread bana ya nahi.
                    System.out.println("Thread 1 running" + Thread.currentThread().getName());

                    try {
                        // Thread ko 500 milliseconds ke liye "pause" karta hai.
                        // Isse doosre thread ko CPU par chalne ka chance milta hai
                        // (agar ye asli thread hota .start() se banaya hua).
                        //
                        // Thread.sleep() ek CHECKED EXCEPTION throw karta hai
                        // (InterruptedException) — isliye try-catch zaroori hai,
                        // warna code compile hi nahi hoga.
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        // Agar koi is sleeping thread ko beech mein "interrupt"
                        // kare, to ye error yahan catch hoga.
                        e.printStackTrace();
                    }
                }
            }
        };

        // ============================================
        // RUNNABLE r2 — "Instruction Sheet" for Thread 2
        // ============================================
        // Bilkul r1 jaisa structure, bas print statement alag hai.
        Runnable r2 = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2 running" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        // ============================================
        // THREAD OBJECTS — "Actual Workers"
        // ============================================
        // Thread object banane se ABHI koi naya execution path nahi banta.
        // Ye sirf ek Java object hai memory mein, jise "instruction sheet"
        // (Runnable) di gayi hai. Kaam shuru karne ke liye .start() chahiye.
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        // t1.start();   // <-- Agar ye use karte, to NAYA THREAD banta,
                          //     aur run() us naye thread par chalta,
                          //     independently/concurrently main thread ke saath.

        // ============================================
        // EXPERIMENT: .run() vs .start()
        // ============================================
        // .run() ko DIRECTLY call karna == ek NORMAL METHOD CALL hai.
        // Koi naya thread create NAHI hota.
        // Ye code CURRENT thread (yahan "main" thread) par hi,
        // SYNCHRONOUSLY (ek ke baad ek, sequentially) chalega.
        //
        // Isliye:
        // - t1.run() poora khatam hone tak (5 iterations + sleeps) t2.run()
        //   shuru hi nahi hoga — koi interleaving nahi hogi.
        // - Thread.currentThread().getName() print karega "main" (dono
        //   Runnables ke liye), NAHI ki "Thread-0" ya "Thread-1".
        t1.run();
        t2.run();

        // t2.start();   // <-- Ye bhi comment hai — agar use karte to
                          //     naya (dusra) thread banta.
    }
}