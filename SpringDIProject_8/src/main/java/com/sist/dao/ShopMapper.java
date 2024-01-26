package com.sist.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface ShopMapper {
	@Select("select no,title,msg,address from seoul_shop order by no asc")
	public List<ShopVO> shopListData();
	
	@Select("select no,title,address,msg from seoul_shop where no=#{no}")
	public ShopVO shopDetailData(int no);
	
	@Select("select no,title from seoul_shop where title like '%'||#{title}||'%'")
	public List<ShopVO> shopfindData(String title);
}
