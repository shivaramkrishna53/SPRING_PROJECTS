package com.nt.comp;

public class budgetcar implements Car {

	Tyre t;
	public budgetcar(Tyre t)
	{
		this.t=t;
		System.out.println("One param-cons of budgetcar::");
		
	}
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("budget car is running with roadgrip of::"+t.roadgrip());
		
	}

}
