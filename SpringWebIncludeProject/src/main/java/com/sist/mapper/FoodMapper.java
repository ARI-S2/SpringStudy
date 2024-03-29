package com.sist.mapper;
/*
 *   1. web.xml
 *      DispatcherServlet 등록 
 *      한글변환
 *       = 보안 등록
 *       = 에러 처리 
 *   2. 클래스 제작 => 메모리할당 / 주입 (****)
 *   3. Spring => xml코드 설정 
 *   4. mapper => dao => model처리 (****)
 *   5. jsp제작 (****)
 */
import java.util.*;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.FoodVO;
public interface FoodMapper {
	  @Select("SELECT fno,name,poster,num "
			 +"FROM (SELECT fno,name,poster,rownum as num "
			 +"FROM (SELECT fno,name,poster "
			 +"FROM food_menu_house ORDER BY fno ASC)) "
			 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<FoodVO> foodListData(@Param("start") int start,
			  @Param("end") int end);
	  
	  @Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menu_house")
	  public int foodTotalPage();
	  
	  @Update("update food_menu_house set hit = hit+1 where fno=#{fno}")
	  public void hitIncrement(int fno);
	  
	  @Select("select fno,score,poster,name,type,address,phone,theme,price,time,seat,content "
	  		+ "from food_menu_house where fno=#{fno}")
	  public FoodVO foodDetailData(int fno);
	  
	  // 검색
	  @Select("SELECT fno,name,poster,num "
				 +"FROM (SELECT fno,name,poster,rownum as num "
				 +"FROM (SELECT fno,name,poster "
				 +"FROM food_menu_house "
				 + "where ${col_name} like '%'||#{ss}||'%' "
				 +"ORDER BY fno ASC )) "
				 +"WHERE num BETWEEN #{start} AND #{end}")
	  public List<FoodVO> foodFindData(Map map);
	  
	  @Select("SELECT CEIL(COUNT(*)/12.0) FROM food_menu_house where ${col_name} like '%'||#{ss}||'%'")
	  public int foodFindlPage(Map map);
}






