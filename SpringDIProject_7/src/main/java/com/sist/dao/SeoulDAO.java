package com.sist.dao;

import java.util.List;

public class SeoulDAO {
	private SeoulMapper mapper; 
	
	// 스프링으로부터 값을 받는 경우 = @Autowired
	public void setMapper(SeoulMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<SeoulVO> naturefindData(String title){
		return mapper.naturefindData(title);
	}
}
