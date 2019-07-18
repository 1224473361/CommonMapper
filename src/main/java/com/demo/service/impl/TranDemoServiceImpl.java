package com.demo.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entity.Muser;
import com.demo.mapper.MuserWMapper;
import com.demo.service.TranDemoService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @date 2019年6月26日
 * @author lihui
 */
@Service
@Slf4j
public class TranDemoServiceImpl implements TranDemoService {

	@Autowired
	private ATranService aTranService;
	@Autowired
	private BTranService bTranService;
	@Autowired
	private CTranService cTranService;
	@Autowired
	MuserWMapper wmapper;
	
	@Override
	@Transactional
	public String tran(String n) {
		log.info("参数:{}",n);
		this.aTranService.aTran(n);
		log.info("aservice执行完毕");
		this.bTranService.bTran(n);
		log.info("bservice执行完毕");
		cTranService.cTran(n);
		log.info("cservice执行完毕");
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void cTran(String n) {
		Muser record = new Muser();
		record.setName(n);
		record.setAge(1);
		record.setTestDate(new Date());
		record.setPhone(this.getClass().getName());
		int i = wmapper.insert(record);
		System.out.println(1/0);
		System.out.println(i);
	}
}
