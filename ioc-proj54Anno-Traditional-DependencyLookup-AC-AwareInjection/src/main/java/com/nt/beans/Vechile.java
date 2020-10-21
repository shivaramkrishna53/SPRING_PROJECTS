package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
@Component("vechile")
public class Vechile implements ApplicationContextAware{
	ApplicationContext ctx=null;
	@Value("${beanid}")
	String beanid;
	
	public Vechile()
	{
		System.out.println("0-param vechile constructor");
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
