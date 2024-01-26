package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.ReplyVO;

public interface ReplyMapper {
	// 시퀀스 생성
	@SelectKey(keyProperty="no",resultType=int.class, before=true, 
			statement="Select NVL(MAX(no)+1,1) as no FROM springReplyBOARD")
	@Insert("insert into springReplyBOARD values(#{no}, #{fno}, #{id}, #{name}, #{msg}, sysdate)")
	public void replyInsert(ReplyVO vo);
	
	@Select("select no, fno, id, name, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') "
			+ "as dbdate, msg from springReplyBOARD where fno=? order by no desc")
	public List<ReplyVO> replyListData(int fno);
	
	@Update("update springReplyBOARD set msg=#{msg} where no=#{no}")
	public void replyUpate(ReplyVO vo);
	
	@Delete("delete from spingReplyBOARD where no=#{no}")
	public void replyDelete(int no);
}
