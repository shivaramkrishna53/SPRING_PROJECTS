package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.target.CarShowRoom;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		CarShowRoom proxy=ctx.getBean("target",CarShowRoom.class);
		System.out.println(proxy.buyCar("innova", 10000000,"pavan"));
		((AbstractApplicationContext) ctx).close();
		

	}

}
