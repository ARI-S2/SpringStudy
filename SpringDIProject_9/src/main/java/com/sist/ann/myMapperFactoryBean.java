package com.sist.ann;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.stereotype.Component;

import com.sist.dao.EmpMapper;

@Component()
public class myMapperFactoryBean extends MapperFactoryBean{

	public void setMapperInterface(Class mapperInterface) {
		// TODO Auto-generated method stub
		setMapperInterface(EmpMapper.class);
	}

	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		// TODO Auto-generated method stub
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
}
