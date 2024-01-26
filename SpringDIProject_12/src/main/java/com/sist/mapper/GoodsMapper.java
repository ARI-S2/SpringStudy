package com.sist.mapper;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;

public interface GoodsMapper {
	
	@Select("select fno,name,address,score,type,price,phone,parking,time,menu from food_house where fno=#{fno}")
	public GoodsVO foodDetailData(int fno);
}
