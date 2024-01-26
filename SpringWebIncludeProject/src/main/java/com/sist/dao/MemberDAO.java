package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MemberMapper;
import com.sist.vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public MemberVO memberLogin(MemberVO vo) {
		MemberVO mvo = new MemberVO();
		int count = mapper.idCount(vo.getId()); // ID 있나 확인
		if(count==0) {
			mvo.setMsg("NOID");
		}else {
			mvo = mapper.memberLogin(vo); // 멤버의 정보 가져와서 확인
			if(mvo.getPwd().equals(vo.getPwd())) {
				mvo.setMsg("OK");
			}else {
				mvo.setMsg("NOPWD");
			}
		}
		return mvo;
	}
}
