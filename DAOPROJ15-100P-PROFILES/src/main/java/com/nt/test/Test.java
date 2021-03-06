package com.nt.test;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import com.nt.config.AppConfig;
import com.nt.controller.CustomerController;
import com.nt.vo.CustomerVo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=null;
		sc=new Scanner(System.in);
		
		String cno=null,ctime=null,crate=null,cname=null,cadd=null,cprinamnt=null,totalintrestamnt=null;
		System.out.println("Enter the customer uniqueno:");
		cno=sc.next();
		System.out.println("Enter the customer name");
		cname=sc.next();
		System.out.println("Enter the customer address");
		cadd=sc.next();
		System.out.println("Enter the principal amount");
		cprinamnt=sc.next();
		System.out.println("Enter the time of intrest:");
		ctime=sc.next();
		System.out.println("Enter the rate of intrest:");
		crate=sc.next();
		CustomerVo vo=new CustomerVo();
		vo.setCno(cno);
		vo.setCadd(cadd);
		vo.setCname(cname);
		vo.setCprinamnt(cprinamnt);
		vo.setCrate(crate);
		vo.setCtime(ctime);
		
		//create beanfactory ioc container
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ConfigurableEnvironment env=ctx.getEnvironment();
		env.setActiveProfiles("dev");
		ctx.register(AppConfig.class);
		ctx.refresh();
		CustomerController con=ctx.getBean("custcontroller",CustomerController.class);
		
		try {
		
			System.out.println(con.getLoanDetails(vo));
		} catch (Exception e) {
			System.out.println("Internal Problem");
			e.printStackTrace();
		}
		
		
	}

}
