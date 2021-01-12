package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.IBankService;

public class Test {

	public static void main(String[] args) throws Throwable {
		System.out.println("Test.main()");
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		IBankService proxy=ctx.getBean("target",IBankService.class);
		System.out.println(proxy.calculateSimpleIntrest(100, 1, 1));
		/*
		 * System.out.println(proxy.calculateSimpleIntrest(100, 2, 1));
		 * System.out.println(proxy.calculateSimpleIntrest(100, 1, 1));
		 * System.out.println(proxy.calculateCompoundIntrest(200, 1, 1));
		 */
		

	}

}
