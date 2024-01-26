package com.sist.ann;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ssf")
// => 지저하지 않으면 클래스명이 아이디값이 됨(맨 앞문자 소문자로)
public class MySqlSessionFactoryBean extends SqlSessionFactoryBean{

	@Autowired
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub
		super.setDataSource(dataSource);
	}
	
}
