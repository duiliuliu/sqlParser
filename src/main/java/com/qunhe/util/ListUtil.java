package com.qunhe.util;

import java.util.List;

/**
 * @author: duiliu
 * @date 2019/7/22
 */
public class ListUtil {

	public static String join(List<String> stringList, String separator) {
		if (stringList.isEmpty() || stringList == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder(stringList.get(0));
		for (int i = 1; i < stringList.size(); i++) {
			sb.append(separator + stringList.get(i));
		}
		return sb.toString();
	}
}
