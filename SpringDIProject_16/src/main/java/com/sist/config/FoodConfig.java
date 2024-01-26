package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = "com.sist.*")
@MapperScan(basePackageClasses = "com.sist.mapper")
public class FoodConfig {
	@Bean("ds")
	public BasicDataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
	ds.setDriverClassName("");
	ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	ds.setUsername("hr");
	ds.setPassword("happy");
	return ds;
	}
	
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf= new SqlSessionFactoryBean();
		ssf.da
	}
}
