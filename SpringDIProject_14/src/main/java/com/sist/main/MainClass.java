package com.sist.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

		ApplicationContext app = new ClassPathXmlApplicationContext("app1.xml"); 
		SeoulDAO sdao = (SeoulDAO)app.getBean("sDao");
		GoodsDAO gdao = app.getBean("gDao",GoodsDAO.class);
		
		String[] stable = {"","seoul_location","seoul_nature","seoul_shop"};
		String[] gtable = {"","goods_all","goods_best","goods_special","goods_new"};
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=======Menu=======");
			System.out.println("1.여행");
			System.out.println("2.상품");
			System.out.println("3.종료");
			System.out.println("==================");
			System.out.print("선택: ");
			int index = sc.nextInt();
			if(index==1) {
				System.out.println("======= 서브메뉴 =======");
				System.out.println("1. 명소");
				System.out.println("2. 자연&관광");
				System.out.println("3. 쇼핑");
				System.out.println("=======================");
				System.out.println("여행 선택: ");
				int sno= sc.nextInt();
				String tab_name=stable[sno];
				List<SeoulVO>list=sdao.seoulListData(tab_name);
				for(SeoulVO vo : list) {
					System.out.println(vo.getNo()+"."+);
				}
				System.out.println("==========================");
				System.out.println("상세 볼 여행번호 입력: ");
				int no = sc.nextInt();
				SeoulVO vo = sdao.seoulDetailData(map);
				System.out.println("여행지: "+vo.getTilte());
				
			}else if(index==2) {
				System.out.println("===== 서브메뉴 ======");
				System.out.println("1. 전체상품");
				System.out.println("2. 베스트 상품");
				System.out.println("3. 특가 상품");
				System.out.println("4. 신상품");
				System.out.println("===================");
				System.out.println("서브메뉴 선택");
				int gno = sc.nextInt();
				String table_name = gtable[gno];
				Map map = new HashMap();
				map.put("table_name", table_name);
				List<GoodsVO> list =gdao.goodsListData(map);
				for(GoodsVO vo:list) {
					System.out.println(vo.getname());
				}
			}else {
				System.out.println("프로그램 종료");
				break;
			}
		}
}
