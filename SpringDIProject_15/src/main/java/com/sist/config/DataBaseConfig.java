package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;

public class DataBaseConfig {
	@Bean("ds")
	public BasicDataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassLoader("");
		ds.setUrl("");
		
	}
}
