package c14.example;

public class SimpleThread extends Thread {
	private int countDown = 5;
	private int threadNumber;
	private static int threadCount = 0;

	public SimpleThread() {
		threadNumber = ++threadCount;
		System.out.println("Making " + threadNumber);
	}

	public void run() {
		while (true) {
			System.out.println("Thread " + threadNumber + "(" + countDown + ")");
			if (--countDown == 0)
				return;
		}
	}

	public static void main(String[] args) {
//		for (int i = 0; i < 5; i++)
//			// new SimpleThread().start();
//			System.out.println("All Threads Started");

		Thread thread = new Thread(new A());
		thread.start();
	}
}

class A implements Runnable {
	public int i = 0;

	@Override
	public void run() {
		for (int i = 0; i < 5; i++)
			System.out.println(i);
	}
}