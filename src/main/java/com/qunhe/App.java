package com.qunhe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qunhe.container.Parser;
import com.qunhe.bean.SqlContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {


	public static void main(String[] args) throws Exception {
		String sql = "SELECT col1,col2 FROM table1,table2 where id in (select distinct id from table3)";
		Parser parser = new Parser();
		List<String> tokenList = parser.buildTokenList(sql);
		System.out.println(tokenList);
		SqlContext sqlContext = parser.parse(tokenList);

		ObjectMapper objectMapper = new ObjectMapper();
		String res = objectMapper.writeValueAsString(sqlContext);
		System.out.println(res);


	}

}
