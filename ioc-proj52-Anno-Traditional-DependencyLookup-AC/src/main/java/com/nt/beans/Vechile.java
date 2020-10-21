package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component("vechile")
@Lazy
public class Vechile {
//	@Value("${beanid}")
	private String beanid;
	
	public void musicplayer()
	{
		System.out.println("Playing music");
	}
	public void aircondition()
	{
		System.out.println("Air condition");
	}
	//version1
	//drawbacks:1.as we are creating container again for second time 2. the bean id is visible to all the methods of the class
//	public void journey(String startlocation,String endlocation)
//	{
//		ApplicationContext ctx=null;
//		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
//		Engine e=ctx.getBean(beanid,Engine.class);
//		e.start();
//		System.out.println("Vechile started from"+startlocation);
//		e.stop();
//		System.out.println("Vechile ended at"+endlocation);
//		
//	}
	//version2
	/*//drawbacks: 1.As we are passing ctx as parameter this method makes it as invasive 2.the bean id is visible to all the methods of the class
	 * public void journey(String startlocation,String
	 * endlocation,ApplicationContext ctx) {
	 * 
	 * Engine e=ctx.getBean(beanid,Engine.class); e.start();
	 * System.out.println("Vechile started from"+startlocation); e.stop();
	 * System.out.println("Vechile ended at"+endlocation);
	 * 
	 * }
	 */
	//version 3
	//drawbacks: 1. As we are passing ctx as parameter this makes this method as invasive
	/*
	 * public void journey(String startlocation,String
	 * endlocation,ApplicationContext ctx,String beanid) {
	 * 
	 * ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
	 * Engine e=ctx.getBean(beanid,Engine.class); e.start();
	 * System.out.println("Vechile started from "+startlocation); e.stop();
	 * System.out.println("Vechile ended at "+endlocation);
	 * 
	 * }
	 */

}
