package com.sist.di;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CommonDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String url,username,password;
	
	public CommonDAO(String driver) {
		try {
			Class.forName(driver);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url,username,password);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void disconnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
