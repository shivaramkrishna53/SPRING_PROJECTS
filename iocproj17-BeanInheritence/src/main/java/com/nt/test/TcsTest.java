package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.tcs;

public class TcsTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		tcs emp1=ctx.getBean("ShivaAsEmp", tcs.class);
		System.out.println(emp1);
		tcs emp2=ctx.getBean("GovindAsEmp", tcs.class);
		System.out.println(emp2);
//		tcs t=ctx.getBean("tcsEmp", tcs.class); //throws exception
//		System.out.println(t);
	}
}
