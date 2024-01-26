package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
// dvo.setDname(rs.getString("dname=>1"))
// => getDvo() 사라짐
public interface EmpMapper {
	@Results({
		@Result(property = "dvo.dname", column = "dname"),
		@Result(property = "dvo.loc", column = "loc")
	})
	@Select("select empno,ename,job,hiredate,sal,dname,loc,TO_CHAR(hiredate,'YYYY-MM-DD') as dbday "
			+ "from emp,join dept on emp.deptno="
			+ "dept.deptno")
	public List<EmpVO> empDeptJoinData();
}
