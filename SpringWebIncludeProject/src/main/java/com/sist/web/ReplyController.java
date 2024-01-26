package com.sist.web;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sist.dao.ReplyDAO;
import com.sist.vo.ReplyVO;

@Controller
public class ReplyController {
	@Autowired
	private ReplyDAO dao;
	
	@PostMapping("reply/reply_insert.do")
	public String reply_insert(int fno, String msg,HttpSession session, RedirectAttributes ra) {
		ReplyVO vo = new ReplyVO();
		String id = (String)session.getAttribute("id");
		String name = (String)session.getAttribute("name");
		vo.setId(id);
		vo.setFno(fno);
		vo.setMsg(msg);
		vo.setName(name);
		vo.setFno(fno);
		dao.replyInsert(vo);
		ra.addAttribute("fno", fno);
		return "redirect:../food/detail?fno="+fno+".do"; 
	}
}
