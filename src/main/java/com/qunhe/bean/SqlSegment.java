/*
 * SqlSegment.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.qunhe.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author duiliu
 * @date 2019/7/21
 */

@Data
@AllArgsConstructor
public class SqlSegment extends SqlContext implements SqlObject {

	private SqlKey mSqlKey;
	private SqlObject mSqlObject;

	public SqlSegment(){
		super();
	}

	public SqlSegment(String signature) {
		super(signature);
	}

}
