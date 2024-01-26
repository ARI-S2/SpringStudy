package com.sist.main;
import com.sist.spring.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml");
		Sawon s = (Sawon)app.getBean("sa");
		System.out.println("사번"+s.getSabun());
		
		Member mem = (Member)app.getBean("mem");
		mem.print();
		
		Member mem1 = (Member)app.getBean("mem1");
		mem.print();
		
		Member mem2 = (Member)app.getBean("mem2");
		mem.print();
	}
}
