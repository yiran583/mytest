package Thread;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年11月1日 下午1:23:48
 */

class Numbers {
	static int i = 0;

	public static synchronized void inc() {
		System.out.println(Thread.currentThread().getName() + "  " + (++i));
	}

	public static synchronized void dec() {
		System.out.println(Thread.currentThread().getName() + "  " + (--i));
	}
}

class Inc implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			Numbers.inc();
		}
	}
}

class Dec implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			Numbers.dec();
		}
	}
}

public class IncAndDec {
	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			Thread t1 = new Thread(new Inc());
			Thread t2 = new Thread(new Dec());
			t1.start();
			t2.start();
		}
	}
}
