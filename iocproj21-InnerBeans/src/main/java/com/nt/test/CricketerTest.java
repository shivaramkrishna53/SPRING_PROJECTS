package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.ProfessionalCricketer;

public class CricketerTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		ProfessionalCricketer c1=ctx.getBean("cricketer1", ProfessionalCricketer.class);
	    c1.cricketerdetails();
//	    ProfessionalCricketer c2=ctx.getBean("cricketer2", ProfessionalCricketer.class);
//	    c2.cricketerdetails();
	    
	}
}
