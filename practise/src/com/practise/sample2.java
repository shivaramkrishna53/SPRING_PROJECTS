package com.practise;

public class sample2 {

	public sample2()
	{
		System.out.println("sample2 constructor");
	}
	static 
	{
		System.out.println("static sample2");
	}
	public static void main(String args[]) throws Exception
	{
		Class c=Class.forName(args[0]);
		
		Object obj=c.newInstance();
		
		
	}
}
