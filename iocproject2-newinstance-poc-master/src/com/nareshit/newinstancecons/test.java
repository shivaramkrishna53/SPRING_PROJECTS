package com.nareshit.newinstancecons;

public class test {

	public int a,b,c;
	public test()
	{
		System.out.println("test with zero args");
	}
	public test(int a)
	{
		this.a=a;
		System.out.println("test with one args");
	}
	public test(int b,int c)
	{
		System.out.println("test with two args");
		this.b=b;
		this.c=c;
	}
}
