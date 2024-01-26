package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.CategoryVO;

public interface CategoryMapper {
	@Select("select cno,title,subject from food_category order by cno asc")
	public List<CategoryVO> foodCategoryData();
	
	@Select("select title,subject from food_category where cno =#{cno}")
	public CategoryVO foodCategoryInfoData(int cno);
}
