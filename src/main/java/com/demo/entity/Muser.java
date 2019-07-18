package com.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.diy.MyGenSql;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.code.ORDER;

/**
 * <p>
 * 
 * </p>
 *
 * @author XXX
 * @since 2019-06-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Table(name = "MUSER")
public class Muser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@KeySql(genSql = MyGenSql.class, order = ORDER.BEFORE)
	private Long testId;

	private Long tenantId;

	private String name;

	private Integer age;

	private Long testType;

	private Date testDate;

	private Long role;

	private String phone;

}
