package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;

public interface SeoulMapper {
	@Select("select no,title from ${table_name}")
	public List<SeoulVO> seoulListData(String table_name);
	
	/*
	 * @Select("select no,title,msg,address from ${table_name} " +
	 * "where no = #{no}") 
	 * public List<SeoulVO> seoulDetailData(@Param("table_name")String table_name, 
	 * 										@Param("no") int no);
	 */
	@Select("select no,title,msg,address from ${table_name} "
			+ "where no = #{no}")
	public List<SeoulVO> seoulDetailData(Map map);
}
