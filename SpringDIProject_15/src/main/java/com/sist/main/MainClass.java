package com.sist.main;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
		FoodDAO fDao = (FoodDAO)app.getBean("fDao");
		System.out.println("=========================================");
		Scanner sc = new Scanner(System.in);
		System.out.print("카테고리 선택(1-30): ");
		int cno = sc.nextInt();
		List<FoodVO> fList= fDao.foodCategoryListData(cno);
		
		for(FoodVO vo:fList) {
			System.out.println(vo.getFno()+" "
					+vo.getName()+" "
					+vo.getAddress()+" "
					+vo.getPhone()+" "
					+vo.getType());
		}
		System.out.println("===============================");
		System.out.println(cvo.getTitle()+" "
				+cvo.getSubject());
		System.out.println("===============================");
		System.out.print("맛집선택: ");
		System.out.println("");
		int fno = sc.nextInt();
		FoodVO vo = fDao.foodDetailData(fno);
		System.out.println("업체명:"+vo.getName());
		System.out.println("주소:"+vo.getAddress());
		System.out.println("전화:"+vo.getPhone());
		System.out.println("음식종류:"+vo.getType());
		System.out.println("가격대:"+vo.getPrice());
		System.out.println("영업시간:"+vo.getTime());
		System.out.println("주차:"+vo.getParking());
	}
	
	
}
