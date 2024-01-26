package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpVO;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
		EmpDAO dao = (EmpDAO)app.getBean("empDAO");// DL => id값을 넘겨주고 객체주소값을 가져오는 것
												  // id값 안넘겨줄거면 클래스이름 주기(첫글자 소문자)
		List<EmpVO> list = dao.empDeptJoinData();
		for(EmpVO vo : list) {
			
		}
	}

}
