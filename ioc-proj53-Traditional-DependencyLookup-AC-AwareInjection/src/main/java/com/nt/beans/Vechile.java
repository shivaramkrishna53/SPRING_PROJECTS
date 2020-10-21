package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Vechile implements ApplicationContextAware{
	ApplicationContext ctx=null;
	String beanid;
	public Vechile(String beanid)
	{
	this.beanid=beanid;	
	System.out.println("1-param vechile constructor");
	}
	public void musicplayer()
	{
		System.out.println("Music has started");
	}
	public void journey(String start,String stop)
	{
		Engine e=ctx.getBean(beanid,Engine.class);
		e.start();
		System.out.println("Journey started from "+start);
		e.stop();
		System.out.println("Journey has stoped at"+stop);
	}
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		// TODO Auto-generated method stub
		this.ctx=ctx;
		System.out.println("Application context method");
		
	}
	

}
