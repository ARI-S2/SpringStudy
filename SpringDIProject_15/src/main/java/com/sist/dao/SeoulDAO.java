package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;

@Repository("sDao")
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData(String table_name){
		return mapper.seoulListData(table_name);
	}
	
	public List<SeoulVO> seoulDetailData(String table_name,int no){
		return mapper.seoulDetailData(table_name, no);
	}
}
