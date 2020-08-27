package com.nt.beans;

public class Printer {
	private static Printer obj=null;
	private Printer()
	{
		
	}
	public static Printer getobj()
	{
		if(obj==null)
			obj=new Printer();
		return obj;
	}

	public void printmessage()
	{
		System.out.println("Printer.printmessage()");
	}
}
