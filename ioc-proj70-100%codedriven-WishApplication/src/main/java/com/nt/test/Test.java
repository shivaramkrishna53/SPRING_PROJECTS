package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class Test {

	public static void main(String[] args) {
	
		System.out.println("Test.main()");
		ApplicationContext ctx=null;
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		WishMessageGenerator gen=ctx.getBean("wmg",WishMessageGenerator.class);
		gen.wishmessage("shiva");
		((AbstractApplicationContext) ctx).close();

	}

}
