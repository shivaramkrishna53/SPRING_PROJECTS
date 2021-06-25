package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.Amazon.Amazon;
import com.nt.Flipkart.Flipkart;
import com.nt.Snapdeal.Snapdeal;

public class AutowiringTest {
 
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
        Flipkart f=ctx.getBean("flipkt", Flipkart.class);
        f.producttrack();
       Amazon a=ctx.getBean("amzn", Amazon.class);
       a.producttrack();
       Snapdeal s=ctx.getBean("snpdl", Snapdeal.class);
       s.producttrack();
	}
	
}
