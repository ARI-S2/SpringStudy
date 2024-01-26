package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SeoulMapper {
	@Select("select no,title,msg,address from seoul_nature order by no asc")
	public List<SeoulVO> natureListData();
	
	@Select("select no,title,address,msg from seoul_nature where no=#{no}")
	public SeoulVO natureDetailData(int no);
	
	@Select("select no,title from seoul_nature where title like '%'||#{title}||'%'")
	public List<SeoulVO> naturefindData(String title);
	
	/*
	 * @Select("select no,title,address,msg from seoul_nature where no=#{no}")
	 * public SeoulVO natureDetailData(int no);
	 * 
	 */
}
