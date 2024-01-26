package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
@Repository("cDao")
public class CategoryDAO {
	@Autowired
	private CategoryMapper mapper;
	
	public List<CategoryVO> foodCategoryData(){
		return mapper.foodCategoryData();
	}
	
	public CategoryVO foodCategoryInfoData(int cno) {
		return mapper.foodCategoryInfoData(cno);
	}
}
