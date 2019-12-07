package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.MuserService;
import com.demo.service.TranDemoService;

/**
 * 
 * @date 2019年6月17日
 * @author lihui
 */
@RestController
public class HController {

	@Autowired
	private MuserService muserService;

	@Autowired
	private TranDemoService tranDemoService;

	/**
	 * 查询测试 localhost/query 
	 */
	@RequestMapping("query")
	public Object query() {
		return this.muserService.query();
	}

	/**
	 * 插入测试 localhost/insert 
	 * 
	 * @return
	 */
	@RequestMapping("insert")
	public Object insert() {
		return this.muserService.insert();
	}

	/**
	 * 事务测试 localhost/cTran
	 * 
	 * @return
	 */
	@RequestMapping("cTran")
	public String cTran() {
		tranDemoService.cTran("1231232");
		return "1";
	}

}
