package com.demo.diy;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.example.SelectCountByExampleMapper;
import tk.mybatis.mapper.common.example.SelectOneByExampleMapper;

/**
 * 自定义读mapper接口
 * 
 * @date 2019年6月17日
 * @author lihui
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface MyReadBaseMapper<T> extends BaseSelectMapper<T>, SelectByExampleMapper<T>, SelectOneByExampleMapper<T>,
		SelectCountByExampleMapper<T>, RowBoundsMapper<T>, Marker {

}