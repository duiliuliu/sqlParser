package com.qunhe.bean;

import static com.qunhe.constant.SymbolConstant.BLANK;

import com.qunhe.util.ListUtil;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: duiliu
 * @date 2019/7/22
 */

@Data
@NoArgsConstructor
public class SqlSegmentBuilder {

	private List<String> tokenList = new ArrayList<String>(5);
	private SqlSegment sqlSegment = new SqlSegment();

	public void addToken(String token) {
		this.tokenList.add(token);
	}

	public SqlSegment build() {
		sqlSegment.setSignature(ListUtil.join(tokenList, BLANK));
		sqlSegment.setMSqlKey(SqlKey.getInstance(tokenList.get(0).toUpperCase()));
		sqlSegment.setMSqlObject(
			  new SqlContext(ListUtil.join(tokenList.subList(1, tokenList.size()), BLANK)));
		return sqlSegment;
	}

}
