package com.sist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import com.sist.dao.*;
@Component
public class MainClass {
	
0	@Autowired
	@Qualifier("memberDAO") // => 인터페이스로 여러 객체 묶어놓고 선택할 때
	private OracleDB ob;
	
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		MainClass mc = (MainClass)app.getBean("mainClass");
		mc.ob.display();// app에 두개의 dao를 등록해서 특정된 하나의 객체를 찾지를 못함 => @Qualifier("클래스id")
	}

}
