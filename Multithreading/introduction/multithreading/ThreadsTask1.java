package introduction.multithreading;
import java.util.Iterator;

public class ThreadsTask1 {
	public static void main(String[] args) {
		Runnable r1 = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Hi Thread1" + Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Runnable r2 = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("Hi Thread2" + Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t1 = new Thread(r1, "One");
		Thread t2 = new Thread(r2, "Two");
		
		t1.start();
		t2.start();
	}
}
