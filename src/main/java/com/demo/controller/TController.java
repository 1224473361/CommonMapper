package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Muser;
import com.demo.mapper.MuserMapper;
import com.demo.mapper.MuserWMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RestController
public class TController {

	@Autowired
	MuserMapper mapper;
	@Autowired
	MuserWMapper wmapper;

	/**
	 * localhost/testPage 分页查询数据
	 */
	@SuppressWarnings("resource")
	@RequestMapping("testPage")
	public Object testPage() {
		PageHelper.offsetPage(1, 10);
		List<Muser> list = mapper.selectAll();
		Page<Muser> p = (Page<Muser>)list;
		return p.toPageInfo();
	}

}
