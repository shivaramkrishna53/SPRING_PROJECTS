package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Vechile implements ApplicationContextAware{
	
	private String beanid=null;
	private ApplicationContext ctx=null;
	
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
	
		Engine e=ctx.getBean(beanid,Engine.class);
		System.out.println("journey method of vechile");
		e.start(ini);
		e.stop(fin);
		
	}
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Aware injection");
		this.ctx=ctx;
			
	}
}
////main drawbacks:
//1.it makes the class as invasive as it is implementing applicationcontextaware 
//2. the injected container is visible to all the methods of the class whereas it is only required in only one method.
//3. the injected dependent bean id is visible to all the methods of the class whereas it is needed in only one method.
//advantages:
//1.no need of creation of new Container, underlying applicationcontext container is injected
//2.no need of taking lazy init=true for singleton scope beans as there is no another container creating.(using the existing container)
