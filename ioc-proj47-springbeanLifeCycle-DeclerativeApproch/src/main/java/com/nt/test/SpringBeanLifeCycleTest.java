package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Voter;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		Voter v=ctx.getBean("voter",Voter.class);
		v.voting();
		((AbstractApplicationContext) ctx).close();
 
		
	}

}
