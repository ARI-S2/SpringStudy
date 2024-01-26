package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		ShopDAO dao = (ShopDAO)app.getBean("dao");
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("====메뉴====");
			System.out.println("1. 목록");
			System.out.println("2. 상세보기");
			System.out.println("3. 검색");
			System.out.println("4. 종료");
			System.out.println("===========");
			System.out.print("메뉴 선택: ");
			int menu = sc.nextInt();
			if(menu<1||menu>4) {
				System.out.println("없는 메뉴 입니다.");
				continue;
			}
			
			if(menu==4) {
				System.out.println("프로그램 종료");
				break;
			}
			if(menu==1) {
				List<ShopVO> list = dao.shopListData();
				for(ShopVO vo:list) {
					System.out.println(vo.getTitle());
				}
			}
			if(menu==2) {
				System.out.println("번호 입력: ");
				int no = sc.nextInt();
				ShopVO vo = dao.shopDetailData(no);
				System.out.println(vo.getTitle());
				System.out.println(vo.getNo());
				System.out.println(vo.getAddress());
			}
			if(menu==3) {
				System.out.print("검색어 입력: ");
				String title =sc.next();
				List<ShopVO> list = dao.shopfindData(title);
				
				for(ShopVO vo:list) {
					System.out.println(vo.getTitle());
				}
				
			}
		
		}
		
	}

	

}
