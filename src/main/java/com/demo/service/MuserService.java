package com.demo.service;

import java.util.List;

import com.demo.entity.Muser;

/**
 * @author Administrator
 *
 */
public interface MuserService  {

	/**
	 * 
	 * @return
	 */
	public List<Muser> query();
	
	/**
	 * 
	 */
	public int insert();
}
