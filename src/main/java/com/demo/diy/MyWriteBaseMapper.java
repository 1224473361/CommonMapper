package com.demo.diy;

import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseInsertMapper;
import tk.mybatis.mapper.common.base.BaseUpdateMapper;
import tk.mybatis.mapper.common.example.DeleteByExampleMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleMapper;
import tk.mybatis.mapper.common.example.UpdateByExampleSelectiveMapper;

/**
 * 自定义写mapper接口
 * 
 * @date 2019年6月17日
 * @author lihui
 */
@tk.mybatis.mapper.annotation.RegisterMapper
public interface MyWriteBaseMapper<T> extends BaseInsertMapper<T>, BaseUpdateMapper<T>, BaseDeleteMapper<T>, Marker,
		DeleteByExampleMapper<T>, UpdateByExampleMapper<T>, UpdateByExampleSelectiveMapper<T> {

}