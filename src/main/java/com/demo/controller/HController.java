package com.demo.controller;

import java.util.HashMap;
import java.util.Map;

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

	@RequestMapping("h")
	public void test() {
		this.muserService.test();
	}

	@RequestMapping("t")
	public void tran() {
		this.tranDemoService.tran("123121");
	}

	@RequestMapping("get")
	public Map<String, Object> get() {
		Map<String, Object> m = new HashMap<>();
		m.put("1ss", "fsfds");
		return m;
	}
}
