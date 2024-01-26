package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.*;
import com.sist.dao.*;
@RestController // 데이터만 보내주는 컨트롤러 => 자바스크립트에
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao;
	
	@PostMapping("databoard/delete_ok.do")
	public String databoard_delete(int no,String pwd,HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("\\upload");
		String res = "";
		try {
			DataBoardVO vo = dao.databoardFileInfoData(no);
			boolean bc = dao.databoardDelete(no);
			
		}
		
		return "";
	}
}
