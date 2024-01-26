package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.SeoulMapper;

@Repository("sDao")
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData(Map map){
		return mapper.seoulListData(Map map);
	}
	
	public List<SeoulVO> seoulDetailData(Map map){
		return mapper.seoulDetailData(Map map);
	}
}
