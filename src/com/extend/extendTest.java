package com.extend;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author jiaotd
 * @since 2015年10月22日 下午8:45:30
 */

class Parent {
	protected static ConcurrentLinkedQueue<Map<String, Object>> queue = new ConcurrentLinkedQueue<Map<String, Object>>();

	/**
	 * 生产
	 */
	public void offer(Map<String, Object> map) {
		queue.offer(map);
	}

	/**
	 * 消费
	 */
	public Map<String, Object> pool() {
		return queue.poll();
	}
}

class ChildrenA extends Parent {

}

class ChildrenB extends Parent {

}

public class extendTest {
	public static void main(String[] args) {
		final ChildrenA a = new ChildrenA();
		final ChildrenB b = new ChildrenB();
		Thread threadA = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 10; i++) {
					Map<String, Object> mapA = new HashMap<String, Object>();
					mapA.put("a" + i, "a" + i);
					a.offer(mapA);
				}

			}
		});

		Thread threadB = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 10; i++) {
					Map<String, Object> mapB = new HashMap<String, Object>();
					mapB.put("b" + i, "b" + i);
					b.offer(mapB);
				}

			}
		});

		threadA.start();
		threadB.start();
		System.out.println("a");
		Map map = null;
		while ((map = a.pool()) != null) {
			System.out.println(map);
		}

		System.out.println("-------------------------");
		while ((map = b.pool()) != null) {
			System.out.println(map);
		}
	}
}
