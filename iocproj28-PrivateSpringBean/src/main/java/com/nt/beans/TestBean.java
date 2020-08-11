package com.nt.beans;

public class TestBean {

	int a,b,c;
	private TestBean()
	{
		System.out.println("0- param .... private constructor");

	}
	private TestBean(int a,int b)
	{
		System.out.println("private class 2param- ... constructor is called");
		this.a=a;
		this.b=b;
	}
	public String toString()
	{
		return "TestBean"+"a:"+a+"b:"+b;
	}
	private static class privcla
	{
		public privcla()
		{
			System.out.println("private class constructor is called");
		}
		public String toString()
		{
			return "privcla obj";
		}

	}
}