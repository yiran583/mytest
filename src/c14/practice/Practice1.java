package c14.practice;

/**
 * 从 Thread 继承一个类，并（过载）覆盖 run()方法。在 run()内，打印出一条消息，然后调用 sleep()。 重复三遍这些操作，然后从
 * run()返回。 在构建器中放置一条启动消息，并覆盖 finalize()，打印 一条关闭消息。 创建一个独立的线程类，使它在run()内调用
 * System.gc()和 System.runFinalization()，
 * 并打印一条消息，表明调用成功。创建这两种类型的几个线程，然后运行它们，看看会发生什么。
 * 
 * @author jiaotd
 * @since 2015年10月14日 下午3:48:26
 */

class Repeat3 extends Thread {
	int i;

	public Repeat3(int i) {
		this.i = i;
		this.start();
	}

	public void run() {
		try {
			System.out.println(i + ":::" + Thread.currentThread().getName() + ":打印第一次");
			Thread.sleep(1000);
			System.out.println(i + ":::" + Thread.currentThread().getName() + ":打印第二次");
			Thread.sleep(1000);
			System.out.println(i + ":::" + Thread.currentThread().getName() + ":打印第三次");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(i + ":::" + Thread.currentThread().getName() + ":关闭");
	}
}

class Garbage extends Thread {
	public Garbage() {
		this.start();
	}

	public void run() {
		System.gc();
		System.out.println(Thread.currentThread().getName() + ":gc成功");
		System.runFinalization();
		System.out.println(Thread.currentThread().getName() + ":runFinalization成功");
	}
}

public class Practice1 {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Repeat3(i);
			new Garbage();
		}
	}
}
