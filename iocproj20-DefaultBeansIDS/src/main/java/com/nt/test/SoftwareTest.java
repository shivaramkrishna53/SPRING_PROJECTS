package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Software;

public class SoftwareTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		Software s1=ctx.getBean("com.nt.beans.Software", Software.class);
		System.out.println(s1);
		Software s2=ctx.getBean("com.nt.beans.Software#0", Software.class);
        System.out.println(s2);
        Software s3=ctx.getBean("com.nt.beans.Software#1", Software.class);
        System.out.println(s3);
        Software s4=ctx.getBean("com.nt.beans.Software#2", Software.class);
        System.out.println(s4);
        
		

	}

}
