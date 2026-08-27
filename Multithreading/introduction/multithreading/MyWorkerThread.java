package introduction.multithreading;

public class MyWorkerThread {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.setName("V");
		mt.start();
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("MyWorkerThread running - " + Thread.currentThread().getName());
		}
	}
}
