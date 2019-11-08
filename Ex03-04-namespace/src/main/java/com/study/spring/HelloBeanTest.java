package com.study.spring;

import org.springframework.context.support.GenericXmlApplicationContext;


public class HelloBeanTest {
	
	public static void main(String[] args)
	{
		
		//의존성이 강한 결합
		/*
		Printer p1 =new PrinterA();
		Printer p2 =new PrinterB();
		Hello h1= new Hello();
		
		h1.setName("이순신");
		h1.setNickname("성웅");
		h1.setPrinter(p1);
		h1.print();
		
		h1.setName("신순이");
		h1.setNickname("웅성");
		h1.setPrinter(p2);
		h1.print();
		*/
		
		
		String configLocation="classpath:beans.xml";
		//1.IoC 컨테이너 생성
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext(configLocation); 
		
		//2.HelloBean가져오기 
		//DI
		Hello hello=(Hello)context.getBean("hello"); 
		hello.print(); 
		
		//3.PrinterBBean가져오기 
		
		Printer printer=context.getBean("printerB",Printer.class); 
		hello.setPrinter(printer);
		hello.print();
		
		//4.싱글톤인지 확인
		Hello hello2 =context.getBean("hello",Hello.class);
		System.out.println(hello == hello2);
		
//		context.close();
		

	}

}
