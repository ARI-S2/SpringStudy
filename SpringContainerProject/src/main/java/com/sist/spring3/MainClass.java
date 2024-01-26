package com.sist.spring3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app= new ClassPathXmlApplicationContext("application.xml");// xml 파싱해주는 객체
		//등록된 클래스를 모아서 관리하는 클래스 => 컨테이너
		Board board = (Board)app.getBean("board");
		board.board_list();
		Board board1 = (Board)app.getBean("board");
		board.board_list();
		System.out.println(board);
		System.out.println(board1);
		
		Member member = (Member)app.getBean("member");
		member.member_insert();
		
		Notice notice = (Notice)app.getBean("notice");
		notice.notice_list();
	}

}
