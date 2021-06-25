package com.nt.beans;

public class B {

	public B(A obj)
	{
		this.obj=obj;
		System.out.println("B class constructr injec");
	}
	A obj;

	
	public void fun2()
    {
    System.out.println("B.fun2()");
    
    }
	
}
