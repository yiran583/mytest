package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年12月24日 下午4:59:42
 */
public class ConcurrentLinkedQueueTest {
	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

	public static void offer(Integer integer) {
		queue.offer(integer);
	}

	public static Integer pool() {
		return queue.poll();
	}

	public static void main(String[] args) {
		for (int i = 1; i <= 1000; i++) {
			offer(i);
		}

		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 1; i <= 50; i++) {
			service.submit(new Runnable() {

				@Override
				public void run() {
					while (!ConcurrentLinkedQueueTest.queue.isEmpty()) {
						System.out.println(ConcurrentLinkedQueueTest.pool());
					}
				}
			});
		}
		service.shutdown();
	}
}
