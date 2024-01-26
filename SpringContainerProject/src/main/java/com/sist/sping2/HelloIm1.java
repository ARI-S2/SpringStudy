package com.sist.sping2;

public class HelloIm1 implements Hello{

	@Override
	public void sayHello(String name) {
		System.out.println(name+"님 환영합니다!");
		
	}
	
}
