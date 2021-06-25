package com.nt.beans;

public class B {

	public B()
	{
		System.out.println("B.B()");
	}
	A obj;

	public void setObj(A obj) {
		System.out.println("B class setter method");

		this.obj = obj;
	}
	public void fun2()
    {
    System.out.println("B.fun2()");
    
    }
	
}
