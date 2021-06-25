package com.nt.beans;

public class A {
	B obj;
	public A(B obj)
	{
		this.obj=obj;
System.out.println("A.A()");
	}

	
    public void fun1()
    {
    System.out.println("A.fun1()");
    obj.fun2();
    }

}
