package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Employee;

public class NullInjectionTest {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		Employee e=ctx.getBean("emp", Employee.class);
		System.out.println(e);
		
	}

}
