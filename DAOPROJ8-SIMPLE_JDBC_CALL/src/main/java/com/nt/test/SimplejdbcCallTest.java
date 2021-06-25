package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.ApplicationConfig;
import com.nt.service.IUserAuthenticate;
import com.nt.service.UserAuthenticateImpl;

public class SimplejdbcCallTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main Class");
		ApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IUserAuthenticate ser=ctx.getBean("userser", UserAuthenticateImpl.class);
		System.out.println(ser.authentication("shiva", "shiva1234"));

	}

}
