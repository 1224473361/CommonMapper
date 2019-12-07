package com.demo.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGES, sqlSessionTemplateRef = "sqlSessionTemplate_oa")
public class DataSourceConfig {
	public static final String PACKAGES = "com.demo.mapper";
	public static final String XMLPATH = "classpath:com/demo/mapper/*.xml";

	@Bean(name = "dataSource_oa")
	@ConfigurationProperties(prefix = "spring.datasource.oa.jdbc")
	@Primary
	public DataSource dataSource() {
		return new HikariDataSource();
	}

	@Bean(name = "sqlSessionFactory_oa")
	@Primary
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource_oa") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(XMLPATH));

		// 设置 jdbctype,oracle需要,default:OTHER(1111)
		bean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
		return bean.getObject();
	}

	@Bean(name = "transactionManager_oa")
	@Primary
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource_oa") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "sqlSessionTemplate_oa")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate(
			@Qualifier("sqlSessionFactory_oa") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
