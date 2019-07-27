/*
 * SqlKey.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.qunhe.bean;

/**
 * @author duiliu
 * @date 2019/7/21
 */
public enum SqlKey {

	// 基本关键字
	SELECT("select"),
	FROM("from"),
	WHERE("where"),

	// 作用域关键字
	LEFT_BRACKET("("),
	RIGHT_BRACKET(")"),

	//逻辑运算关键字
	GT(">"),
	LT("<"),
	GTE(">="),
	LTE("<=");


	String keyWord;

	SqlKey(final String keyWord) {
		this.keyWord = keyWord;
	}

	/**
	 * 通过比较keyword获取实例对象
	 */
	public static SqlKey getInstance(String key) {
		for (SqlKey sqlKey : SqlKey.values()) {
			if (key.toLowerCase().equals(sqlKey.keyWord)) {
				return sqlKey;
			}
		}
		return null;
	}


	public static boolean isKeyWord(String token) {
		return getInstance(token) != null;
	}
}
