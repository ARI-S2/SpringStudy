package com.sist.main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.*;

public class MainClass2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(
				SeoulGoodsConfig.class);
	}

}
