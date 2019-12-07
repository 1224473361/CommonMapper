package com.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Muser;
import com.demo.mapper.MuserMapper;
import com.demo.mapper.MuserWMapper;
import com.demo.service.MuserService;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

/**
 * <p>
 * 测试 服务实现类
 * </p>
 *
 * @author XXX
 * @since 2019-06-13
 */
@Service
@Slf4j
public class MuserServiceImpl implements MuserService {

	@Autowired
	MuserMapper mapper;
	@Autowired
	MuserWMapper wmapper;

	@Override
	public List<Muser> query() {
		List<Muser> list = this.mapper.selectAll();
		log.info("所有数据:{}", list);
		Example example = new Example(Muser.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("name", "%1%");
		List<Muser> list3 = this.mapper.selectByExample(example);
		log.info("部分数据:{}", list3);
		return list3;
	}

	@Override
	public int insert() {
		int c = 0;
		for (int i = 0; i < 10; i++) {
			Muser m = new Muser();
			m.setName("名称" + i);
			m.setTestDate(new Date());
			c += this.wmapper.insert(m);
		}
		return c;
	}

}
