package com.sist.main;

import com.sist.sping1.Hello;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\spingDev\\springStudy\\SpringContainerProject\\src\\main\\java\\com\\sist\\main\\MainClass.java";
		ApplicationConext app = new ApplicationConext(path);
		Board board = (Board)app.getbean("board");
		board.board_list();
	}

}
