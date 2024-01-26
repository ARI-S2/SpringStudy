package com.sist.dao;

import java.util.List;

public class ShopDAO {
	private ShopMapper mapper; 
	
	// 스프링으로부터 값을 받는 경우 = @Autowired
	public void setMapper(ShopMapper mapper) {
		this.mapper = mapper;
	}
	
	public List<ShopVO> shopListData(){
		return mapper.shopListData();
	}
	
	public ShopVO shopDetailData(int no) {
		return mapper.shopDetailData(no);
	}
	
	public List<ShopVO> shopfindData(String title){
		return mapper.shopfindData(title);
	}
}
