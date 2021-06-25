package com.nt.beans;

public class A {
	B obj;
	public A()
	{
		System.out.println("A.A()");
	}
	
	public void setObj(B obj)
	{
		System.out.println("A.setObj()");
		this.obj=obj;
	}

	
    public void fun1()
    {
    System.out.println("A.fun1()");
    obj.fun2();
    }

}
