package com.nt.beans;

public class sample2 {
	public sample2()
	{
		System.out.println("zero param sample2 constructor");
	}
	static
	{
		System.out.println("static block of sample2");
	}
	public sample2(int a,int b)
	{
		System.out.println("two param constructor of sample2");
	}

}
