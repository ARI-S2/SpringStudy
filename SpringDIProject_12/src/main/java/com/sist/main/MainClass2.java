package com.sist.main;

import java.io.File;

public class MainClass2 {

	public static void main(String[] args) {
		try {
			String path = "C:\\spingDev\\springStudy\\SpringDIProject_12\\src\\main\\java";
			String pack = "com.sist.temp";
			path = path+"\\"+pack.replace(".", "\\");
			System.out.println(path);
			File dir = new File(path);
			File[] files = dir.listFiles();
			for(File f:files) {
				String ff = f.getName();
				String ext = ff.substring(ff.lastIndexOf(".")+1);
				if(ext.equals("java")) {
					String ss = ff.substring(0,ff.lastIndexOf("."));
					String res= pack+"."+qqss;
					System.out.println(res);
				}
				System.out.println(f.getName());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
