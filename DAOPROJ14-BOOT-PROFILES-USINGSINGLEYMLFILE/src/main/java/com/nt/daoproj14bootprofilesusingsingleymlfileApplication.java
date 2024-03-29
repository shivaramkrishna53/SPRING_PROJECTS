package com.nt;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.CustomerController;
import com.nt.vo.CustomerVo;

@SpringBootApplication
public class daoproj14bootprofilesusingsingleymlfileApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx=SpringApplication.run(daoproj14bootprofilesusingsingleymlfileApplication.class, args);
		CustomerController con=ctx.getBean("custcontroller",CustomerController.class);
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
		System.out.print(con.getLoanDetails(vo));
		
	}
	}


