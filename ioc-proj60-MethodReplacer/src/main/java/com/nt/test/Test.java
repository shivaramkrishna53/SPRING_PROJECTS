package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.BankLoanManagment;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		BankLoanManagment b=ctx.getBean("bank",BankLoanManagment.class);
		System.out.println(b.calculateIntrest(1000,2,2));
		
	}

}
