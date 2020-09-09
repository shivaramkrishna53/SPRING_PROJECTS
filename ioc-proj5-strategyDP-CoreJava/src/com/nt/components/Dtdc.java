package com.nt.components;

public class Dtdc implements Courier {

	
	public Dtdc()
	{
		System.out.println("Dtdc 0-param constructor called");
	}
	@Override
	public String delivery(int id) {
		return "Dtdc dart is delivering your order: your order no is:"+id;
	}

}
