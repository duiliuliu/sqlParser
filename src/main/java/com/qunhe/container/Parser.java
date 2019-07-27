/*
 * Parser.java
 * Copyright 2019 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.qunhe.container;

import static com.qunhe.constant.SymbolConstant.BLANK;

import com.qunhe.bean.SqlContext;
import com.qunhe.bean.SqlSegmentBuilder;
import com.qunhe.bean.SqlKey;

import com.qunhe.exception.NotFoundRightBracketException;
import com.qunhe.util.ListUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author duiliu
 * @date 2019/7/21
 */
public class Parser {

	public List<String> buildTokenList(String sql) {
		String blankPattern = "\\s+";
		String symbolPattern = "([\\(\\)])+";
		String newSql = sql.replaceAll(symbolPattern, " $1 ");
		return new ArrayList<>(Arrays.asList(newSql.split(blankPattern)));
	}

	public SqlContext parse(List<String> tokenList)throws NotFoundRightBracketException {
		// TODO 有having count两个连续关键字的情况
		/**
		 * 遇到括号构建子查询
		 */
		return GrammerBuilder.build(buildSqlSegments(tokenList));
	}

	private SqlContext buildSqlSegments(List<String> tokenList) {
		SqlContext sqlContext = new SqlContext(ListUtil.join(tokenList, BLANK));
		SqlSegmentBuilder sqlSegmentBuilder = new SqlSegmentBuilder();
		boolean isFirst = true;
		for (String token : tokenList) {
			if (SqlKey.isKeyWord(token) && !isFirst) {
				sqlContext.addChildSql(sqlSegmentBuilder.build());
				sqlSegmentBuilder = new SqlSegmentBuilder();
			}
			isFirst = false;
			sqlSegmentBuilder.addToken(token);
		}
		sqlContext.addChildSql(sqlSegmentBuilder.build());
		return sqlContext;
	}

	private boolean check() {
		return false;
	}
}
