package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.FoodMapper;

@Repository("fDao")
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
}
