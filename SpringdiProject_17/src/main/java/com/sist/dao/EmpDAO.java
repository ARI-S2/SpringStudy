package com.sist.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sist.main.*;
import com.sist.mapper.EmpMapper;
public class EmpDAO {
	@Autowired
	private EmpMapper mapper;
	
	public List<EmpVO> empAllData(){
		return mapper.empAllData();
	}
	
	public EmpVO empDetailData(int empno) {
		return mapper.empDetailData(empno);
	}
}
