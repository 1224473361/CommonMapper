package com.demo.diy;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.EntityTable;
import tk.mybatis.mapper.gensql.GenSql;

/**
 * 使用序列生成id
 * 
 * @date 2019年6月17日
 * @author lihui
 */
public class MyGenSql implements GenSql {

	@Override
	public String genSql(EntityTable entityTable, EntityColumn entityColumn) {
		return "select getseq() from dual";
	}

}
