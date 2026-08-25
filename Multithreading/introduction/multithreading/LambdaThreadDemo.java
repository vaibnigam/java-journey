package introduction.multithreading;
public class LambdaThreadDemo {
    public static void main(String[] args) {

        // Ek hi Runnable (instruction sheet) bana rahe hain.
        // Isko baad mein teeno threads (t1, t2, t3) ko diya jayega —
        // yaad rakho: Runnable sirf "kya karna hai" batata hai,
        // multiple Threads ek hi Runnable share kar sakte hain.
        Runnable r1 = () -> {
            for (int i = 0; i < 10; i++) {
                // Thread.currentThread().getName() batata hai ki
                // YE CODE ABHI KIS THREAD PAR CHAL RAHA HAI.
                // Chahe Runnable same ho, har Thread ki apni ALAG
                // identity (naam) hoti hai — naam Thread se
                // associate hota hai, Runnable se nahi.
                System.out.println("Hello from " + Thread.currentThread().getName());
            }
        };

        // Thread t1 — naam CONSTRUCTOR mein hi diya ja raha hai
        // (Runnable + naam, dono ek saath pass kiye)
        Thread t1 = new Thread(r1, "Name of thread 1");

        // Thread t2 — abhi koi custom naam nahi diya,
        // isliye JVM default naam dega (jaise "Thread-1")
        // jab tak humne khud setName() se change na kiya
        Thread t2 = new Thread(r1);

        // Thread t3 — koi custom naam nahi, JVM default naam
        // dega (jaise "Thread-2") kyunki naam nahi badla gaya
        Thread t3 = new Thread(r1);

        // t1 start hote hi naya thread banta hai aur run() us
        // naye thread par chalta hai — "Name of thread 1" ke naam se
        t1.start();

        // t2 ka naam .start() se PEHLE change kiya ja raha hai —
        // isliye jab t2 actually chalega, naya naam
        // "Name of thread 2" hi use hoga
        t2.setName("Name of thread 2");
        t2.start();

        // t3 ko koi custom naam nahi diya gaya — isliye ye JVM ke
        // default naming convention se chalega (jaise "Thread-2")
        t3.start();

        // NOTE: Teeno threads (t1, t2, t3) EK HI Runnable (r1) use
        // kar rahe hain, lekin teeno INDEPENDENT threads hain —
        // isliye output "interleaved" (mixed order) mein aayega,
        // predictable order guaranteed nahi hai (JVM scheduler
        // decide karta hai kis thread ko kab CPU milega).
    }
}