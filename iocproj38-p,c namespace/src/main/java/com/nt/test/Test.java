package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Emp;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
	Emp e=ctx.getBean("emp",Emp.class);
	System.out.println(e.getDep().toString());
	System.out.println(e.getDob().toString());
	System.out.println(e.getEno());
	System.out.println(e.getEname());
	System.out.println(e.getEadd());
	}

}
