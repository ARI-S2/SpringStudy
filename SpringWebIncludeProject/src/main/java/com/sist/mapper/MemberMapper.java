package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

public interface MemberMapper {
	@Select("select count(*) from springmember "
			+"where id=#{id}")
	public int idCount(String id);
	
	@Select("select id,pwd,name,sex from springmember "
			+ "where id=#{id}")
	public MemberVO memberLogin(MemberVO vo);
}
