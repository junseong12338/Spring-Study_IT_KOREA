package com.korea.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDITest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(Coding.class,Computer.class);
		
		Coding coding = (Coding)ac.getBean(Coding.class);
		Computer computer = (Computer)ac.getBean(Computer.class);
		
		// ����
		//coding.computer = computer;
		
		// setter ����
		// coding.setComputer(computer);

		System.out.println(coding.getComputer().getRam());
	}
}
