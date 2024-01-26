package com.sist.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO extends SqlSessionDaoSupport{
	private EmpMapper mapper;
	
	@Autowired
	public void setMapper(EmpMapper mapper) {
		this.mapper = mapper;
	}
	public List<EmpVO> empDeptJoinData(){
		return getSqlSession().selectList("empDeptJoinData");
	}
	
}
