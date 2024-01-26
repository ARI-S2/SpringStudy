package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.dao.DataBoardVO;

public interface DataBoardMapper {
	@Select("select no,subject,name,TO_char(regdate,'YYYY-MM-DD') as dbday,hit,rownum as num "
			+ "From (select no,subject,name,regdate,hit,rownum "
			+ "From (select /*+ index_desc(springDataBoard sdb_no_pk) +*/ "
			+ "From springDataboard)) "
			+ "where num between #{start} and #{end}")
	public List<DataBoardVO> databoardListData(@Param("start")int start, @Param("end") int end);
	
	@Insert("insert into springDataboard ")
	public void databoardInsert(DataBoardVO vo);
	
	@Update("update springDataboard set hit = hit+1 where no=#{no}")
	public void hitIncrement(int no);
	
	@Select("select no,name,subject,content,TO_char(regdate,'YYYY-MM-DD') as dbday,"
			+ "hit,filename,filesize,filecount "
			+ "from springDataboard where no=#{no}")
	public DataBoardVO databoardDetailData(int no);
	
	// 삭제
	@Select("select filename,filecount from springDataboard where no = #{no}")
	public DataBoardVO databoardFileInfoData(int no);
	
	@Select("select pwd from springDataboard where no = #{no}")
	public String databoardgetPassword(int no);
	
	@Delete("delete from springDataboard where no = #{no}")
	public void databoardDelete(int no);
	
	// 수정
	@Update("")
	
	
}
