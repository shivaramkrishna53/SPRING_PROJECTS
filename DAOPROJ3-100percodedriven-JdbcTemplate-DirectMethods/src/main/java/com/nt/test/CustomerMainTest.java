package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.Config;
import com.nt.service.CustomerServiceImpl;

public class CustomerMainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Config.class);
		CustomerServiceImpl ser=ctx.getBean("ser",CustomerServiceImpl.class);
		ser.getEmpcount(30);
		ser.getEmpdetails(7844);
		ser.getEmpofJob("SALESMAN", "PRESIDENT");

	}

}
