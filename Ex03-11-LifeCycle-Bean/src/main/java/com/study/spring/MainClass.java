package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext(); //생성
		
		ctx.load("classpath:beans.xml");
		System.out.println("aaaaa");
		ctx.refresh();
		System.out.println("bbbbb");
		
		ctx.close();
		System.out.println("ccccc");
		
	}

}
