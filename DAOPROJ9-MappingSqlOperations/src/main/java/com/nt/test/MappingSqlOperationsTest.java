package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.ApplicationConfig;
import com.nt.service.IEmployeeSer;

public class MappingSqlOperationsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IEmployeeSer ser=ctx.getBean("empser", IEmployeeSer.class);
		System.out.println(ser.getempbyid(109));
		System.out.println(ser.employeesalinrange(60000,40000)+" number of employees got salary incremented");
		

	}

}
