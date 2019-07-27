package com.qunhe.bean;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: duiliu
 * @date 2019/7/22
 */
@Data
@AllArgsConstructor

public class SqlContext implements SqlObject, Cloneable {

	protected String signature;
	private List<SqlContext> childrenSql;

	public SqlContext() {
	}

	public SqlContext(String signature) {
		this.signature = signature;
	}

	public void addChildSql(SqlContext sqlContext) {
		if (childrenSql == null || childrenSql.isEmpty()) {
			childrenSql = new ArrayList<SqlContext>();
		}
		this.childrenSql.add(sqlContext);
	}

	@Override
	public SqlContext clone() {
		// 此处应该深拷贝,待修改
		try{
			return (SqlContext)super.clone();
		}catch (CloneNotSupportedException e){
			return null;
		}
	}
}
