package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.GoodsVO;

public interface GoodsMapper {
	@Select("select no,goods_name as name from ${table_name}")
	public List<GoodsVO> goodsListData(Map map);
	
	@Select("select no,goods_name as name,goods_price as price,"
			+ "goods_sub as sub,goods_discount as discount from ${table_name} "
			+ "where no=#{no}")
	public GoodsVO goodsDetailData(Map map);
}
