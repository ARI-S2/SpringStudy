package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;

public interface FoodMapper {
	@Select("select fno,name,address,phone,type from food_house where cno=#{cno}")
	public List<FoodVO> foodCategoryListData(int cno);
	
	@Select("select fno,name,address,score,type,price,phone,parking,time,menu from food_house where fno=#{fno}")
	public FoodVO foodDetailData(int fno);
}
