package com.sist.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;

public interface FoodMapper {
	@Select("select fno,poster,name,num from "
			+ "(select fno,poster,name,rownum as num "
			+ "from (select fno,poster,name "
			+ "from food_menu_house order by fno asc)) "
			+ "where num between #{start} and #{end}")
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	
	@Select("select ceil(count(*)/12.0) from food_menu_house")
	public int foodTotalPage();
	
}
