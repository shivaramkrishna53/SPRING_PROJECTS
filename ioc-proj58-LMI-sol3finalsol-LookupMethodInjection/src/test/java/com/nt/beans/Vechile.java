package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class Vechile
{
	public Vechile()
	{
		System.out.println("0-param vechile constructor");
	}
	public abstract Engine createengine();
	
	public void musicplayer() {
		System.out.println("Music is playing");
	}
	public void ac()
	{
		System.out.println("Air conditioner is on");
		
		
	}
	public void journey(String ini,String fin)
	{
		System.out.println("journey method of vechile");
		Engine e=createengine();
		
		e.start(ini);
		e.stop(fin);
		
	}
	
}

//advantages:
//1.it is non-invasive
//2.no need of creation extra container
//3. no need of injecting the dependent class bean id
//4.no need of lazy-init=true
//5.it is industry standard
//6. ioc container manages the dependent class obj creation and dependency lookup to target class.