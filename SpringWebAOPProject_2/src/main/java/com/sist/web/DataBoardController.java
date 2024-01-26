package com.sist.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Connection.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.*;
@Controller // 화면 바꿔주는 컨트롤러
@RequestMapping("databoard/") // 공통된 경로 저장(@RequestMapping) => 클래스 위에 올리기
// GetMapping / PostMapping => ajax,axios,form
public class DataBoardController {
	@Autowired
	private DataBoardDAO dao;
	
	/*
	 * 값이 명확하게 넘어오면 해당 자료형
	 * 아니면 string!! => null도 넘어오는 경우
	 */
	@GetMapping("list.do")
	public String databoard_list(String page, Model model) {
		if(page==null)
			page="1";
		int curpage = Integer.parseInt(page);
		int rowSize=10;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = curpage * endPage
		
	}
	
	@GetMapping("detail.do")
	public String databoard_detail(int no,Model model) {
		DataBoardVO vo = dao.databoardDetailData(no);
		if(vo.getFilecount()>0) {
			String[] filenames=vo.getFilename().split(",");
			String[] filesizes=vo.getFilesize().split(",");
			
			List<String> fList = Arrays.asList(filenames);
			List<String> sList = Arrays.asList(filesizes);
			
			model.addAttribute("fList",fList);
			model.addAttribute("sList",sList);
		}
		model.addAttribute("vo", vo);
		return "databoard/detail";
	}
	
	@GetMapping("download.do")
	public void databoard_download(String fn,HttpServletRequest request,HttpServletResponse response) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/")+"upload\\";
			path = path.replace("\\", File.separator);
			File file = new File(path+fn);
			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fn,"UTF-8"));
			
			response.setContentLength((int)file.length());
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			
			int i = 0;
			byte[] buffer = new byte[1024];
			while((i=bis.read(buffer,0,1024))!=-1) {
				bos.write(buffer,0,i);
			}
			bis.close();
			bos.close();
		}catch (Exception e) {

		}
	}
	
	@GetMapping("update.do")
	public String databoard_update(int no,Model model) {
		DataBoardVO vo = dao.databoardUpdateData(no);
		model.addAttribute("vo",vo);
		
		return "databoard/update";
	}
	
	@PostMapping("update_ok.do")
	public String databoard_update_ok(DataBoardVO vo,Model model,HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath("/")+"upload\\";
		path = path.replace("\\", File.separator);
		DataBoardVO fvo = dao.databoardFileInfoData(vo.getNo());
		try {
			if(fvo.getFilecount()>0) {
				StringTokenizer st = new StringTokenizer(vo.getFilename(),",");
				while(st.hasMoreTokens()) {
					File file = new File(path+st.nextToken());
				}
			}
		}catch (Exception e) {
		}
		
		List<MultipartFile> list = vo.getFiles();
		if(list == null) {
			vo.setFilename("");
			vo.setFilesize("");
			vo.setFilecount(0);
		}else {
			String filename="";
			String filesize="";
			for(MultipartFile mf:list) {
				String name = mf.getOriginalFilename();
				File f = new File(path+name);
				try {
					mf.transferTo(f);
				}catch (Exception e) {
					filename = name+",";
					filesize = f.length()+",";
				}
				filename = filename.substring(0,filename.lastIndexOf(","));
				filesize = filesize.substring(0,filesize.lastIndexOf(","));
				vo.setFilecount(list.size());
				vo.setFilename(filename);
				vo.setFilesize(filesize);
			}
			boolean bc = dao.databoardUpdateData(vo);
			model.addAttribute("bc",bc);
			
			return "databord/update_ok";
		}
	}
}
