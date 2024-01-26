package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;
@Repository
public class GoodsDAO {
	@Autowired
	private GoodsMapper mapper;
	
	public List<GoodsVO> goodsListData(int start,int end){
		return mapper.goodsListData(start, end);
	}
	
	  public int goodsTotalPage()
	  {
		  return mapper.goodsTotalPage();
	  }
	  public GoodsVO goodsDetailData(int gno) {
		  mapper.hitIncrement(gno);
		  return mapper.goodsDetailData(gno);
	  }
	  public GoodsVO goodsCookieData(int gno) {
		  return mapper.goodsDetailData(gno);  
	  }
	  

}
