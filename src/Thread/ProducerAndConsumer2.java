package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个生产者，3个消费者 仓库最多能够容纳3个苹果
 * 
 * 生产者最多生产3个,每次有空余位置就生产,消费者发现有货物就消费
 * 
 */

class Apple2 {
	public int count = 3;

	private Lock lock = new ReentrantLock();
	private Condition first = lock.newCondition();
	private Condition second = lock.newCondition();

	public void produce() {
		lock.lock();
		try {
			// 仓库满，等待消费
			while (count == 0) {
				try {
					System.out.println("仓库满了");
					System.out.println(Thread.currentThread().getName() + " wait");
					first.await();
					System.out.println(Thread.currentThread().getName() + " produce");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (count > 0) {
				// 生产产品，占领仓库
				count--;
				System.out.println(Thread.currentThread().getName() + " 产品:" + (3 - count));
				// 产出唤醒消费者
				second.signal();
			}
		} finally {
			lock.unlock();
		}
	}

	public void consume() {
		lock.lock();
		try {
			// 仓库空时，等待消费
			if (count == 3) {
				try {
					System.out.println("仓库空了");
					System.out.println(Thread.currentThread().getName() + " wait");
					second.await();
					System.out.println(Thread.currentThread().getName() + " consume");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (count < 3) {
				// 消费货物
				count++;
				System.out.println(Thread.currentThread().getName() + " 产品:" + (3 - count));
				first.signal();
			}
		} finally {
			lock.unlock();
		}
	}
}

class Producer2 extends Thread {

	Apple2 apple;

	public Producer2(Apple2 apple, String id) {
		super(id);
		this.apple = apple;
		this.start();
	}

	public void run() {

		for (int i = 1; i <= 4; i++) {
			apple.produce();
		}

	}
}

class Consumer2 extends Thread {

	Apple2 apple;

	public Consumer2(Apple2 apple, String id) {
		super(id);
		this.apple = apple;
		this.start();
	}

	public void run() {

		for (int i = 1; i <= 4; i++) {
			apple.consume();
		}

	}
}

public class ProducerAndConsumer2 {
	public static void main(String[] args) {

		Apple2 apple = new Apple2();
		ExecutorService service = Executors.newScheduledThreadPool(3);

		for (int i = 1; i <= 2; i++) {
			service.execute(new Producer2(apple, "生产者" + i));
			// new Producer2(apple, "生产者" + i);
		}
		for (int i = 1; i <= 1; i++) {
			service.execute(new Consumer2(apple, "消费者" + i));
			// new Consumer2(apple, "消费者" + i);
		}
		// service.shutdown();
	}
}
