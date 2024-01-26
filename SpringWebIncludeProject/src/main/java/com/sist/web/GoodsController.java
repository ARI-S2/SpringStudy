package com.sist.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.GoodsDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;

@Controller
public class GoodsController {
	@Autowired
	private GoodsDAO dao;
	
	@GetMapping("goods/goods_main.do")
	   public String goods_main(String page,Model model)
	   {
		  if(page==null)
			  page="1";
		  int curpage=Integer.parseInt(page);
		  int rowSize=12;
		  int start=(rowSize*curpage)-(rowSize-1);
		  int end=rowSize*curpage;
		  
		  List<GoodsVO> list=dao.goodsListData(start, end);
		  int totalpage=dao.goodsTotalPage();
		  
		  final int BLOCK=10;
		  int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		  int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		  
		  if(endPage>totalpage)
			  endPage=totalpage;
		  
		  model.addAttribute("curpage", curpage);
		  model.addAttribute("totalpage", totalpage);
		  model.addAttribute("startPage", startPage);
		  model.addAttribute("endPage", endPage);
		  model.addAttribute("list", list);
		  
		  model.addAttribute("main_jsp", "../goods/goods_main.jsp");
		  return "main/main";
	   }
	
	   @GetMapping("goods/goods_detail_before.do")
	   public String goods_detail_before(int gno,HttpServletResponse response,RedirectAttributes ra)
	   {
		   // 쿠키는 일반 객체 => 매개변수로 받을 수 없다
		   Cookie cookie=new Cookie("goods_"+gno, String.valueOf(gno));
		   cookie.setPath("/");
		   cookie.setMaxAge(60*60*24);
		   response.addCookie(cookie);
		   // sendRedirect(RedirectAttributes) => 값 전송(물음표를 붙여서 값 전송하지 않음)
		   ra.addAttribute("gno", gno);
		   return "redirect:../goods/goods_detail.do";
	   }
	   
	   @GetMapping("goods/goods_detail.do")
	   public String goods_detail(int gno,Model model) {
		   GoodsVO vo = dao.goodsDetailData(gno);
		   model.addAttribute("vo",vo);
		   model.addAttribute("main_jsp", "../goods/goods_detail.jsp");
		   return "main/main";
	   }
}
