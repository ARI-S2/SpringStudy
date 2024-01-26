package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("food/list.do")
	public String food_list(String page,Model model) { 
		// Model model => 전송 객체 (request 대체) ~> 보안문제 
		// 이제 getparameter가 아니라 파라미터로 바로 값 받아서 채워줌 => 바로 사용가능
		// 원래 값 받은거 다 형변환도 해서 넣어주는데 page는 null값이 있어서 string으로 받음
		// 한글변환은 web.xml에서 filter로 변환 처리
			// ~> url에서 필요한 값을 다 매개변수에서 받아주면 됨 !
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize = 12;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		List<FoodVO> list = dao.foodListData(start, end);
		int totalpage = dao.foodTotalPage();
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		if(endPage>totalpage)
			endPage=totalpage;
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list", list);
		return "food/list";
	}
	@RequestMapping("food/detail.do")
	public String food_detail(int fno,Model model) {
		// 매개변수 값이랑 url값이 꼭 같아야 함
		FoodVO vo = dao.foodDetailData(fno);
		model.addAttribute("vo",vo);
		/*
		 * 	class Model{
		 * 		private HttpServletRequest request
		 * 		public Model(HttpServletRequest request){
		 * 			this.request = request;
		 * 		}
		 * 		public void addAttribute(String key,Object obj){
		 * 			request.setAttribute(key,obj);
		 * 		}
		 */
		return "food/detail";
	}
	
	@RequestMapping("food/find.do")
	public String food_find(String fd,Model model ) {
		
		return "food/find";
	}
}
