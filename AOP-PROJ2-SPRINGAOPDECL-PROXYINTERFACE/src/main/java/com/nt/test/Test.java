package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/AppliicationContext.xml");
		BankService proxy=ctx.getBean("proxy",BankService.class);
		System.out.println("simple interset is::"+proxy.calculateInterest(2000, 2, 1));

	}

}
