package com.nt.beans;

public class sample1 {
	public sample1()
	{
		System.out.println("zero param sample1 constructor");
	}
	static
	{
		System.out.println("static block of sample1");
	}
	public sample1(int a,int b)
	{
		System.out.println("two param constructor of sample1");
	}

}
