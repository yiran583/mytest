package com.forkJoin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author jiaotd
 * @since 2015年10月23日 上午9:46:50
 */
@SuppressWarnings("serial")
public class ListTask extends RecursiveTask<Map<String, List<Map<String, String>>>> {

	public final static int THRESHOLD = 25;
	private List<Map<String, String>> list;

	public ListTask() {
	}

	public ListTask(List<Map<String, String>> list) {
		this.list = list;
	}

	protected Map<String, List<Map<String, String>>> compute() {
		Map<String, List<Map<String, String>>> map = new HashMap<>();
		List<Map<String, String>> trueList = new ArrayList<>();
		List<Map<String, String>> errorList = new ArrayList<>();
		if (list.size() > 25) {
			List<List<Map<String, String>>> splitedList = splitList(list);
			ListTask leftTask = new ListTask(splitedList.get(0));
			ListTask rightTask = new ListTask(splitedList.get(1));
			leftTask.fork();
			rightTask.fork();
			trueList.addAll(leftTask.join().get("trueList"));
			trueList.addAll(rightTask.join().get("trueList"));
			errorList.addAll(leftTask.join().get("errorList"));
			errorList.addAll(rightTask.join().get("errorList"));
		} else {
			for (Map<String, String> map2 : list) {
				for (String str : map2.keySet()) {
					if (Integer.valueOf(map2.get(str)) % 2 == 0)
						trueList.add(map2);
					else
						errorList.add(map2);
				}
			}
		}

		map.put("trueList", trueList);
		map.put("errorList", errorList);
		return map;
	}

	public static List<List<Map<String, String>>> splitList(List<Map<String, String>> list) {
		List<List<Map<String, String>>> lists = new ArrayList<>();
		List<Map<String, String>> leftList = new ArrayList<>();
		List<Map<String, String>> rightList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i <= list.size() / 2) {
				leftList.add(list.get(i));
			} else {
				rightList.add(list.get(i));
			}
		}
		lists.add(leftList);
		lists.add(rightList);
		return lists;
	}

	public static void main(String[] args) {

		List<Map<String, String>> list = new ArrayList<>();

		for (int i = 1; i <= 101; i++) {
			Map<String, String> map = new HashMap<>();
			map.put(i + "", i + "");
			list.add(map);
		}

		ForkJoinPool pool = new ForkJoinPool();
		ListTask task = new ListTask(list);
		Future<Map<String, List<Map<String, String>>>> result = pool.submit(task);
		try {
			Map<String, List<Map<String, String>>> resultMap = result.get();
			List<Map<String, String>> trueList = resultMap.get("trueList");
			List<Map<String, String>> errorList = resultMap.get("errorList");
			System.out.println(trueList.size());
			System.out.println(errorList.size());
			
			System.out.println(trueList);
			System.out.println(errorList);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
