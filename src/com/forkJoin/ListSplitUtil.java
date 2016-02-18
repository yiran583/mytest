package com.forkJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListSplitUtil {
	/**
	 * 切分List
	 * 
	 * @param list
	 * @param pageSize
	 * @return
	 */
	public static List<List<Map<String, Object>>> splitList(List<Map<String, Object>> list, int pageSize) {
		int listSize = list.size(); // list的大小
		int page = (listSize + (pageSize - 1)) / pageSize;// 页数
		List<List<Map<String, Object>>> listArray = new ArrayList<List<Map<String, Object>>>();// 创建list数组
																								// ,用来保存分割后的list
		for (int i = 0; i < page; i++) { // 按照数组大小遍历
			List<Map<String, Object>> subList = new ArrayList<Map<String, Object>>(); // 数组每一位放入一个分割后的list
			for (int j = 0; j < listSize; j++) {// 遍历待分割的list
				int pageIndex = ((j + 1) + (pageSize - 1)) / pageSize;// 当前记录的页码(第几页)
				if (pageIndex == (i + 1)) {// 当前记录的页码等于要放入的页码时
					subList.add(list.get(j)); // 放入list中的元素到分割后的list(subList)
				}
				if ((j + 1) == ((j + 1) * pageSize)) {// 当放满一页时退出当前循环
					break;
				}
			}
			listArray.add(subList);// 将分割后的list放入对应的数组的位中
		}
		return listArray;

	}

}
