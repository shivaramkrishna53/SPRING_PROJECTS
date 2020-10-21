package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.ScheduleReminder;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx;
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		ScheduleReminder scr=ctx.getBean("sr",ScheduleReminder.class);
		scr.reminder();
	}

}
