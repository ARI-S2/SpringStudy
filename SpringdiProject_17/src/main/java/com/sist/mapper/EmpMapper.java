package com.sist.mapper;

import java.util.List;

import com.sist.dao.*;

public interface EmpMapper {
	public List<EmpVO> empAllData();
	
	public EmpVO empDetailData(int empno);
}
