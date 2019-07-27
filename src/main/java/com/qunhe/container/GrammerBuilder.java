package com.qunhe.container;

import static com.qunhe.constant.SymbolConstant.BLANK;

import com.qunhe.bean.SqlContext;
import com.qunhe.bean.SqlKey;
import com.qunhe.bean.SqlSegment;
import com.qunhe.exception.NotFoundRightBracketException;
import java.util.List;

/**
 * @author: duiliu
 * @date 2019/7/22
 */
public class GrammerBuilder {

	public static SqlContext build(SqlContext sqlContext) throws NotFoundRightBracketException {
		SqlContext sc = buildSubExpressionByBracket(sqlContext);
		return sc;
	}

	/**
	 * 通过连续关键字构建子句
	 */
	private static SqlContext buildChildSqlByContinuousKeyWord(SqlContext sqlContext){
		SqlContext newSqlContext = new SqlContext(sqlContext.getSignature());
		List<SqlContext> sqlContexts = sqlContext.getChildrenSql();
		int len = sqlContexts.size();
		for (int i = 0; i < len; i++) {
//			 if
		}
		return null;
	}


	/**
	 * 通过括号匹配构建子查询
	 */
	private static SqlContext buildSubExpressionByBracket(SqlContext sqlContext)
		  throws NotFoundRightBracketException {
		SqlContext newSqlContext = new SqlSegment(sqlContext.getSignature());
		List<SqlContext> sqlContexts = sqlContext.getChildrenSql();
		int len = sqlContexts.size();
		for (int i = 0; i < len; i++) {
			SqlSegment sc = (SqlSegment) sqlContexts.get(i);
			if (sc.getMSqlKey().equals(SqlKey.LEFT_BRACKET)) {
				SqlSegment subExpression = new SqlSegment();
				StringBuilder sb = new StringBuilder();
				do {
					i++;
					if (i >= len) {
						throw new NotFoundRightBracketException("未找到可匹配的右括号!");
					}
					sc = (SqlSegment) sqlContexts.get(i);
					if (sc.getMSqlKey().equals(SqlKey.RIGHT_BRACKET)) {
						break;
					}
					subExpression.addChildSql(sc);
					sb.append(sc.getSignature() + BLANK);

				} while (true);
				subExpression.setSignature(sb.toString());
				sc = (SqlSegment)buildSubExpressionByBracket(subExpression);
			}
			newSqlContext.addChildSql(sc);
		}

		return newSqlContext;
	}

}
