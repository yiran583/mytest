package c14.practice;

/**
 * 创建两个 Thread 子类，第一个的 run()方法用于最开始的启动，并捕获第二个 Thread 对象的句柄，然 后调用 wait()。第二个类的
 * run()应在过几秒后为第一个线程调用 modifyAll()，使第一个线程能打印出一 条消息。
 * 
 * @author jiaotd
 * @since 2015年10月14日 下午7:27:12
 */

class Run1 extends Thread {
	boolean flag = false;
	Run2 run2;

	public Run1(Run2 run2) {
		this.run2 = run2;
	}

	public synchronized void run() {
		try {
			while (!flag) {
				if (null != run2)
					wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Run2 extends Thread {
	public synchronized void run() {
		try {
			Thread.sleep(5000);
			notifyAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Practice4 {
	public static void main(String[] args) {
		Run2 run2 = new Run2();
		Run1 run1 = new Run1(run2);
		run1.start();
		run2.start();
	}
}
