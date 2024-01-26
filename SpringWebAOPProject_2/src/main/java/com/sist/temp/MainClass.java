package com.sist.temp;

import java.beans.Encoder;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("mc")
public class MainClass {
	@Autowired // 필요할 때마다 오토와이어드로 주입
	private BCryptPasswordEncoder encoder; // 암호화 클래스 메모리 할당
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		MainClass mc = (MainClass)app.getBean("mc");
		
		String pwd="1234";
		String enPwd=mc.encoder.encode(pwd);
		System.out.println(enPwd);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 입력: ");
		pwd = sc.next();
		// matches 복호화 메소드
		if(mc.encoder.matches(pwd, enPwd)) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
	}

}
