package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.dao.*;
// @ResponseBody => 클래스로 승격 (RestController) 
//				 => 타언어랑 연결(값을보냄) => restful(자바스크립트)
@RestController
public class BoardRestController {
	@Autowired
    private BoardDAO dao;
	
	@RequestMapping("board/update_ok.do")
	public String board_update_ok(BoardVO vo)
	{
		String result="";
		boolean bCheck=dao.boardUpdate(vo);
		if(bCheck==true)
		{
			result="<script>location.href=\"detail.do?no="+vo.getNo()+"\"</script>";
		}
		else
		{
			result="<script>"
				  +"alert(\"비밀번호가 틀립니다\");"
				  +"history.back();"
				  +"</script>";
		}
		return result;
	}
	@RequestMapping("board/delete_ok.do")
	public String board_delete(int no,String pwd) {
		String result = "";
		boolean bc = dao.boardReplyDelete(no, pwd);
		if(bc==true)
			result = "yes";
		else
			result = "no";
		return result;
	}
	
}