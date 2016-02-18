package com.forkJoin;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * @author jiaotd
 * @since 2015年10月23日 上午9:22:54
 */
public class CountTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = -5532403011993386387L;

	private static final int THRESHOLD = 3; // 阀值
	private int start;
	private int end;

	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		// 任务小足够小就进行计算
		boolean canCompute = (end - start) <= THRESHOLD;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				try {
					URL url = new URL("http://127.0.0.1:8090/rgsh/index.html");
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.connect();
					connection.getInputStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
				sum += i;
			}
		} else {
			// 任务大于阀值，继续分割
			int middle = (start + end) / 2;
			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);
			// 执行子任务
			leftTask.fork();
			rightTask.fork();

			// 等待子任务执行完，返回结果
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			// 合并子任务
			sum = leftResult + rightResult;
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		// 生成任务计算 1+2+3+4
		CountTask task = new CountTask(1, 10);
		// 执行一个任务
		Future<Integer> result = pool.submit(task);
		try {

			if (task.isCompletedAbnormally()) {
				System.out.println(task.getException());
			}

			System.out.println(result.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
