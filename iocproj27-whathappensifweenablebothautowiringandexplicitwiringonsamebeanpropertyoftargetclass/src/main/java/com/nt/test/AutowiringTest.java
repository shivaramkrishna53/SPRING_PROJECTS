package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.Amazon.Amazon;

public class AutowiringTest {
 
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
       
       Amazon a=ctx.getBean("amzn", Amazon.class);
       a.producttrack();
      
	}
	
}
