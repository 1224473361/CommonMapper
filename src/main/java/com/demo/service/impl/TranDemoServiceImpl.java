package com.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Muser;
import com.demo.mapper.MuserWMapper;
import com.demo.service.TranDemoService;

/**
 * 事务测试
 * 
 * @date 2019年6月26日
 * @author lihui
 */
@Service
public class TranDemoServiceImpl implements TranDemoService {

	@Autowired
	MuserWMapper wmapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void cTran(String n) {
		Muser record = new Muser();
		record.setName(n);
		record.setAge(1);
		record.setTestDate(new Date());
		record.setPhone(this.getClass().getName());
		int i = wmapper.insert(record);
		System.out.println(1 / 0);
		System.out.println(i);
	}
}
