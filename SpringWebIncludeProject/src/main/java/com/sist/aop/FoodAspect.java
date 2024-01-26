package com.sist.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.RequestContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sist.dao.FoodDAO;
import com.sist.dao.GoodsDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;

@Aspect
@Component
public class FoodAspect {
	// finally => 무조건 전송
	@Autowired
	private FoodDAO dao;
	
	@Autowired
	private GoodsDAO gdao;
	
	@After("execution(* com.sist.web.MainController.main_main(..))")
	public void cookieSend() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
									  .getRequestAttributes()).getRequest();
		Cookie[] cookies= request.getCookies();
		List<FoodVO> cList = new ArrayList<FoodVO>();
		if(cookies!=null) {
			for(int i = cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("food_")) {
					String fno = cookies[i].getValue();
					FoodVO vo = dao.foodCookieData(Integer.parseInt(fno));
					cList.add(vo);
				}
			}
		}
		request.setAttribute("count", cList.size());
		request.setAttribute("cList", cList);
	}
	
	@After("execution(* com.sist.web.GoodsController.goods_main(..))")
	public void cookieSendGoods() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder
									  .getRequestAttributes()).getRequest();
		Cookie[] cookies= request.getCookies();
		List<GoodsVO> gcList = new ArrayList<GoodsVO>();
		if(cookies!=null) {
			for(int i = cookies.length-1;i>=0;i--) {
				if(cookies[i].getName().startsWith("goods_")) {
					String gno = cookies[i].getValue();
					GoodsVO vo = gdao.goodsCookieData(Integer.parseInt(gno));
					gcList.add(vo);
				}
			}
		}
		request.setAttribute("count", gcList.size());
		request.setAttribute("gcList", gcList);
	}
}
