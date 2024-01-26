package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.DataBoardMapper;

@Repository // DAO전용 메모리 할당
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> databoardListData(int start, int end){
		return mapper.databoardListData(start, end);
	}
	
	public void databoardInsert(DataBoardVO vo) {
		mapper.databoardInsert(vo);
	}
	
	
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
	
	public DataBoardVO databoardFileInfoData(int no) {
		return mapper.databoardFileInfoData(no);
	}
	
	public String databoardgetPassword(int no) {
		return mapper.databoardFileInfoData(no);
	}
	
	public void databoardDelete(int no) {
		boolean bk = false;
		boolean db_pwd = mapper.databoardgetPassword(no);
		
	}
	
	public DataBoardVO databoardUpdateData(int no) {
		return mapper.databoardDetailData(no);
	}
	
	
}
