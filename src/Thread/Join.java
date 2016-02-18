package Thread;
/**
 * 
 * @author Yiran583
 *
 */
class MyThread extends Thread {
	int i;

	public MyThread(int i) {
		this.i = i;
		start();
	}

	@Override
	public void run() {
		System.out.println(currentThread().getName() + ":" + i);
	}
}

public class Join {
	public static void main(String[] args) throws Exception {
		MyThread t1 = new MyThread(1);
		t1.join();
		MyThread t2 = new MyThread(2);
		t2.join();
		MyThread t3 = new MyThread(3);
		t3.join();
	}
}
