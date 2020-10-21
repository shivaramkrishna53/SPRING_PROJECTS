package com.nt.beans;

import org.springframework.stereotype.Component;

@Component("engine")
public class Engine {

	public Engine()
	{
		System.out.println("0-param engine constructor");
	}
	public void start()
	{
		System.out.println("Engine has started");
	}
	public void stop()
	{
		System.out.println("Engine is stopped");
	}
}
