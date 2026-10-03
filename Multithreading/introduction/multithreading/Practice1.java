package introduction.multithreading;

public class Practice1 {
	public static void main(String[] args) throws InterruptedException {
//		Thread th = new Thread();
//		th.start();
//		th.run();
		Task1 task1 = new Task1();
		task1.setName("task1");
		task1.start();
//		task1.run();
		Task2 task2 = new Task2();
		task2.setName("task2");
//		task1.join();

		task2.start();
//		task2.run();
		Task3 task3 = new Task3();
		task3.setName("task3");

		task3.start();
//		task2.join();
//		task3.run();
	}

}
class Task1 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("task1 running");
			System.out.println("Thread name :" + Thread.currentThread().getName());
		}
		
	}
}
class Task2 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("task2 running");
			System.out.println("Thread name :" + Thread.currentThread().getName());
		}
	}
}
class Task3 extends Thread{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("task3 running");
			System.out.println("Thread name :" + Thread.currentThread().getName());
		}
	}
}