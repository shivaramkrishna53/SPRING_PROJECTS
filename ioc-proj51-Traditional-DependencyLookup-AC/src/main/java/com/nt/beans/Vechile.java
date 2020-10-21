package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vechile {
	private String beanid;
	
	public void musicplayer()
	{
		System.out.println("Playing music");
	}
	public void aircondition()
	{
		System.out.println("Air condition");
	}
	public Vechile(String beanid)
	{
		this.beanid=beanid;
	}
	public void journey(String startlocation,String endlocation)
	{
		ApplicationContext ctx=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		Engine e=ctx.getBean(beanid,Engine.class);
		e.start();
		System.out.println("Vechile started from"+startlocation);
		e.stop();
		System.out.println("Vechile ended at"+endlocation);
		
	}

}
