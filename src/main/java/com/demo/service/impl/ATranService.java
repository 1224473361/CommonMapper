package com.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Muser;
import com.demo.mapper.MuserWMapper;

/**
 * 
 * @date 2019年6月26日
 * @author lihui
 */
@Service
public class ATranService {

	@Autowired
	MuserWMapper wmapper;

	public void aTran(String n) {
		Muser record = new Muser();
		record.setName(n);
		record.setTestDate(new Date());
		record.setPhone(this.getClass().getName());
		int i = wmapper.insert(record);
		System.out.println(i);
	}
}
