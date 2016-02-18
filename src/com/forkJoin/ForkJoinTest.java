package com.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class ForkJoinTest extends RecursiveTask<Long> {

	public final static int THRESHOLD = 2000000;
	private int start;
	private int end;

	public ForkJoinTest(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	protected Long compute() {
		long sum = 0L;
		boolean devide = (end - start) <= THRESHOLD;
		if (devide) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			int mid = (start + end) >> 1;
			ForkJoinTest leftTask = new ForkJoinTest(start, mid);
			ForkJoinTest rightTask = new ForkJoinTest(mid + 1, end);
			leftTask.fork();
			rightTask.fork();
			sum += leftTask.join();
			sum += rightTask.join();
		}
		return sum;
	}

	private long cal(int start, int end) {
		long sum = 0L;
		for (int i = start; i <= end; i++) {
			sum += i;
		}
		return sum;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int end = 1000000000;
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinTest task = new ForkJoinTest(1, end);
		Future<Long> future = forkJoinPool.submit(task);
		long t1 = System.currentTimeMillis();
		System.out.println("forkjoin:" + future.get());
		long t2 = System.currentTimeMillis();
		System.out.println("other:" + task.cal(1, end));
		long t3 = System.currentTimeMillis();

		System.out.println("1:" + (t2 - t1));
		System.out.println("2:" + (t3 - t2));
	}
}