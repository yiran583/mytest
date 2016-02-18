package Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author jiaotd
 * @since 2015年10月15日 下午3:48:06
 */

class Book {
	// 锁
	static ReadWriteLock lock = new ReentrantReadWriteLock();
	// 文字
	static double value;
	static int count = 0;

	/**
	 * 写入文字
	 */
	public void write(double v) {
		Lock writeLock = lock.writeLock();
		writeLock.lock();
		System.out.println("ReadWriteLockTest to write: " + v + "   " + Thread.currentThread().getName());
		try {
			value += v;
			count++;
		} finally {
			writeLock.unlock();
		}

	}

	/**
	 * 读书
	 */
	public void read() {
		Lock readLock = lock.readLock();
		readLock.lock();
		System.out.println("ReadWriteLockTest to read   " + Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		try {
			System.out.println(value + " : " + count);
		} finally {
			readLock.unlock();
		}
	}

}

public class ReadWriteLockTest {
	public static void main(String[] args) {
		final Book book = new Book();
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new Runnable() {

			public void run() {
				book.write(22.22);
			}
		});
		for (int i = 0; i < 3; i++) {
			service.execute(new Runnable() {

				public void run() {
					book.read();
				}
			});
		}
		service.shutdown();
	}
}
