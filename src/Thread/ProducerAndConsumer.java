package Thread;

/**
 * 多个生产者，3个消费者 仓库最多能够容纳3个苹果
 * 
 * @author jiaotd
 * @since 2015年10月15日 下午4:33:09
 */

class Apple {
	public int count = 3;
	// 初始化时仓库空
	public boolean flag = true;

	public synchronized void produce() {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count--;
		// 仓库最多放3个,停止生产
		if (count == 0)
			flag = !flag;
		System.out.println(Thread.currentThread().getName() + " 生产后剩余位置:" + count);
		notifyAll();
	}

	public synchronized void consume() {
		System.out.println("消费者"+flag);
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		count++;
		if (count == 3)
			flag = !flag;
		System.out.println(Thread.currentThread().getName() + " 消费后剩余位置:" + count);
		notifyAll();
	}
}

class Producer extends Thread {

	Apple apple;

	public Producer(Apple apple, String id) {
		super(id);
		this.apple = apple;
		this.start();
	}

	public void run() {
		apple.produce();
	}
}

class Consumer extends Thread {

	Apple apple;

	public Consumer(Apple apple, String id) {
		super(id);
		this.apple = apple;
		this.start();
	}

	public void run() {
		apple.consume();
	}
}

public class ProducerAndConsumer {
	public static void main(String[] args) {
		Apple apple = new Apple();
		for (int i = 0; i < 10; i++) {
			new Producer(apple, "生产者" + i);
		}
		for (int i = 0; i < 3; i++) {
			new Consumer(apple, "消费者" + i);
		}
	}
}
