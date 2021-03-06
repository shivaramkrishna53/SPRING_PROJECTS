package com.nt.listener;

import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class IocContainerMonitoringListener implements ApplicationListener {
	long start=0,stop=0;
	@Override
	
	public void onApplicationEvent(ApplicationEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e);
		if(e.toString().indexOf("ContextRefreshedEvent")!=-1)
		{
			System.out.println("Ioc Container created");
			start=System.currentTimeMillis();
			System.out.println("Started at time"+new Date());
		}
		else
			if(e.toString().indexOf("ContextClosedEvent")!=-1)
		{
			System.out.println("Ioc container destroyed");
			stop=System.currentTimeMillis();
			System.out.println("Destroyed at time"+ new Date());
			System.out.println("Total lifetime of ioc container::::"+ (start-stop));
		}
		
	}

}
