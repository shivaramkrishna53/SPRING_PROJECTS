package com.nt.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("engine")
@Lazy
public class Engine {
	public void start()
	{
		System.out.println("Engine has started");
	}
	public void stop()
	{
		System.out.println("Engine has stoped");
	}

}
