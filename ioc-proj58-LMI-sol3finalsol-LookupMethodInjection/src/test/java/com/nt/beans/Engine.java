package com.nt.beans;

public class Engine {
	public Engine()
	{
		System.out.println("engine 0-param constructor");
	}
	public void start(String initialplace)
	{
		System.out.println("Engine started"+" starting from::"+initialplace);
	}
	public void stop(String finalplace)
	{
		System.out.println("Engine stopped"+" ended at::"+finalplace);
	}

}
