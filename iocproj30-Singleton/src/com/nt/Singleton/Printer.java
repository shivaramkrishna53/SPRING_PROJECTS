package com.nt.Singleton;

public class Printer {

	private static Printer InstanceObj=null;
	private Printer()
	{
		
	}
	public static Printer createInstance()
	{
		if(InstanceObj==null)
			InstanceObj=new Printer();
		return InstanceObj;
			
	}
	public void print()
	{
		System.out.println("printer class print method");
	}
}
