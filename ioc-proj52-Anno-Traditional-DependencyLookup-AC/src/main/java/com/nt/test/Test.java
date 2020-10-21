package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Vechile;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=null;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		Vechile v=ctx.getBean("vechile",Vechile.class);
		v.musicplayer();
		v.aircondition();
		//v.journey("hyd","goa");
		//v.journey("hyd","goa",ctx);
		v.journey("hyd", "goa", ctx,"engine");

	}

}
