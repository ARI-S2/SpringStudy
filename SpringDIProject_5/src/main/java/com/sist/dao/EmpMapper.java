package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface EmpMapper {
	@Select("select empno,ename,job,hiredate,sal, deptno "
			+ "from emp")
	public List<EmpVO> empListData();
	//     resultType     id     parameterType
}
