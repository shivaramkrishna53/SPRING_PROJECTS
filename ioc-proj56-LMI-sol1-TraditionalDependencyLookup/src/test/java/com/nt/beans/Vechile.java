package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vechile {
	
	private String beanid=null;
	
	public void setBeanid(String beanid) {
		System.out.println("Bean id injected");
		this.beanid = beanid;
	}
	public Vechile()
	{
		System.out.println("Vechile 0-param constructor");
	}
	public void musicplayer() {
		System.out.println("Music is playing");
	}
	public void ac()
	{
		System.out.println("Air conditioner is on");
		
		
	}

	public void journey(String ini,String fin)
	{
		ApplicationContext ctx=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		Engine e=ctx.getBean(beanid,Engine.class);
		System.out.println("journey method of vechile");
		e.start(ini);
		e.stop(fin);
		
	}
}
////main drawbacks:
//1.Need to create an extra ioc container for the method which makes it bit heavy
//2.The bean id that is been injected is visible accross all the methods in the class although it is required by only one method.
//3.we need to set the singleton scope to enable lazy init=true if not for every ioc container creation singleton scope beans are instanciated.
 
//advantages:
//1. here we can inject the dependent class object to target class required one method...but not injected for all(incase of setter/const injection)
//2.we can maintain the prototype scope of dependent bean id class as we are not injecting the dependent ref but we are injecting the dependent bean id name to target bean though target is singleton.

