package com.sist.spring;

public class Member {
	private int mno;
	private String name;
	private String addr;
	public Member(int mno, String name, String addr) {
		this.mno = mno;
		this.name = name;
		this.addr = addr;
	}
	public void print() {
		System.out.println("회원번호"+mno);
		System.out.println("이름"+name);
		System.out.println("주소"+addr);
	}
	
}
