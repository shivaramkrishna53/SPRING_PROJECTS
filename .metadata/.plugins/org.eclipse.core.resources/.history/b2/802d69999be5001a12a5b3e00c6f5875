package com.nt.test;

import java.util.Locale;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class I18SpringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		Locale l=new Locale(args[0],args[1]);
		String b1=ctx.getMessage("btn1.cap",new String[] {"insert","update"},"not found",l);
		String b2=ctx.getMessage("btn2.cap",null ,l);
		System.out.println(b1);
		System.out.println(b2);

	}

}
