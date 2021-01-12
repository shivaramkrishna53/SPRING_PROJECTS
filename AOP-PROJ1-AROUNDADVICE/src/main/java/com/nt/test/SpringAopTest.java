package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankServiceTargetClass;

public class SpringAopTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("SpringAopTest.main()");
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		BankServiceTargetClass tar=ctx.getBean("proxyclass",BankServiceTargetClass.class);
		double result=tar.CalculateInterestAmount(100000,1,2);
		System.out.println("total intrest amount::"+result);
		

	}

}
