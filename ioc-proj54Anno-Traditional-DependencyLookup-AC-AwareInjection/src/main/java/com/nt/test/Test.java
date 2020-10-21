package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Vechile;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		Vechile v=ctx.getBean("vechile",Vechile.class);
		v.musicplayer();
		v.journey("hyd", "goa");

	}

}

// The main drawbacks are: 1.The injected ApplicationContext ctx container is visible to all methods whereas it should be visible only for one method(Dependency lookup)
//2. The injected bean id of dependent is visible to all the methods
//3. it shows invasive behaviour as vechile class implementing the ApplicationContextAware