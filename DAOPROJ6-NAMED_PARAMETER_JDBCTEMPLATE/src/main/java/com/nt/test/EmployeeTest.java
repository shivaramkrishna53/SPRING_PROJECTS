package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmployeeServiceImpl;
import com.nt.service.IEmployeeService;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		IEmployeeService ser=ctx.getBean("empser", IEmployeeService.class);
		System.out.println(ser.getEmployeeNameById(109));
		System.out.println(ser.getEmployeeDetailsByLocation("hyd", "ocity"));
		

	}

}
