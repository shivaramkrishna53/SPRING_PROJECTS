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
