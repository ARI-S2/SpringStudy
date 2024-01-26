package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.GoodsVO;

public interface GoodsMapper {
	/*
	 *  private int gno;
		private String gname,poster,origin,manufacturer,price,dimage;
	 */
		  @Select("SELECT gno,price,poster,num "
					 +"FROM (SELECT gno,price,poster,rownum as num "
					 +"FROM (SELECT gno,price,poster "
					 +"FROM goods ORDER BY gno ASC)) "
					 +"WHERE num BETWEEN #{start} AND #{end}")
			  public List<GoodsVO> goodsListData(@Param("start") int start,
					  @Param("end") int end);
			  
			  @Select("SELECT CEIL(COUNT(*)/12.0) FROM goods_all")
			  public int goodsTotalPage();
			  
			  @Update("update goods set hit = hit+1 where gno=#{gno}")
			  public void hitIncrement(int fno);
			  
			  @Select("select gno,poster,gname,origin,manufacturer,price,dimage "
			  		+ "from goods where gno=#{gno}")
			  public GoodsVO goodsDetailData(int fno);
}
