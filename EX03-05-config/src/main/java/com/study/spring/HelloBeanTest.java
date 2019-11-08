package com.study.spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class HelloBeanTest {
	
	public static void main(String[] args)
	{
		
	

		//String configLocation="classpath:beans.xml";
		//1. 스프링 설정이 클래스패스 루트가 아닌 다른 곳에 위치한다
		// 루트를 기준으로 경로 형식을 입력
		// String configLocation = "classpath:config/beans.xml";
		// String configLocation = "classpath:/config/beans.xml";
		//2. 클래스패스가 아닌 파일 시스템에서 설정 파일을 읽어오기
		//String configLocation="classpath:config/beans*.xml";
		
		//A.Ioc 컨테이너 생성
		//ApplicationContenxt context = new GenericXmlApplicationContext(configLocation);
		
		//4.1개이상의 설정파일 경로를 값으로 전달 가능 : 가변 인자 형태임
		AbstractApplicationContext context = new GenericXmlApplicationContext(
				"classpath:beans.xml",
				"classpath:config/beans2.xml");

		//B. Hello Bean가져오기 
		//DI
		Hello hello=(Hello)context.getBean("hello"); 
		hello.print(); 
		
		
//		context.close();
		

	}

}
