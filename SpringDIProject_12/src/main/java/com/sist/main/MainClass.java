package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Component
class A{
	public void display() {
		System.out.println("A:display call...");
	}
}
class B{
	public void display() {
		System.out.println("B:display call...");
	}
}
@Component
class C{
	public void display() {
		System.out.println("C:display call...");
	}
}

public class MainClass {
	public static void main(String[] args) {
		String[] cls= {"com.sist.main.A",
					"com.sist.main.B",
					"com.sist.main.C"};
		try {
			for(String s:cls) {
				Class clsName = Class.forName(s);
				if(clsName.isAnnotationPresent(Component.class)==false) {
					continue;
				}
				Object obj = clsName.getDeclaredConstructor().newInstance();
				System.out.println(obj);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		/* ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml"); */
	}
}
