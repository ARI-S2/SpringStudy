package com.sist.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.FoodVO;

public interface FoodMapper {
	@Select("<script>"
			+"select fno,name,type,address where "
			+"<trim prefix=\"(\" suffix=\")\" prefixOverrides=\"OR\">"
			+"<foreach collection=\"fsArr\" item=\"ss\">"
			+"<trim prefix=\"OR\">"
			+"<choose>"
			+"<when test=\"fd=='N'.toString()\">"
			+"name Like '%'||#{ss}||'%'"
			+"</when>"
			+"<when test=\"fd=='A'.toString()\">"
			+"name Like '%'||#{ss}||'%'"
			+"</when>"
			+"<when test=\"fd=='T'.toString()\">"
			+"name Like '%'||#{ss}||'%'"
			+"</when>"
			+"</choose>"
			+"</trim>"
			+"</foreach>"
			+"</trim>"
			+"</script>")
	public List<FoodVO> foodFindData(Map map);
}
