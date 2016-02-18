package com.lock;

/**
 * @author jiaotd
 * @since 2015年10月13日 上午10:52:36
 */

class Common {
	public static final String A = "A";
	public static final String B = "B";
}

class classA implements Runnable {

	public void run() {
		System.out.println(String.format("线程%s准备争夺资源%s", Thread.currentThread().getName(), Common.A));
		synchronized (Common.A) {
			System.out.println(String.format("线程%s已得到资源%s", Thread.currentThread().getName(), Common.A));
			System.out.println(String.format("线程%s准备争夺资源%s", Thread.currentThread().getName(), Common.B));
			synchronized (Common.B) {
				System.out.println(String.format("线程%s已得到资源%s", Thread.currentThread().getName(), Common.B));
			}
		}
	}

}

class classB implements Runnable {

	public void run() {
		System.out.println(String.format("线程%s准备争夺资源%s", Thread.currentThread().getName(), Common.B));
		synchronized (Common.B) {
			System.out.println(String.format("线程%s已得到资源%s", Thread.currentThread().getName(), Common.B));
			System.out.println(String.format("线程%s准备争夺资源%s", Thread.currentThread().getName(), Common.A));
			synchronized (Common.A) {
				System.out.println(String.format("线程%s已得到资源%s", Thread.currentThread().getName(), Common.A));
			}
		}
	}

}

public class DeadLock {
	public static void main(String[] args) {
		new Thread(new classA()).start();
		new Thread(new classB()).start();
	}
}
