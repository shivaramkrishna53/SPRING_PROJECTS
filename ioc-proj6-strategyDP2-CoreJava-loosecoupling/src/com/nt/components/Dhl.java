package com.nt.components;

public class Dhl implements Courier {

	public Dhl()
	{
		System.out.println("DHL 0-param constructor called");
	}
	@Override
	public String delivery(int id) {
		return "DHL dart is delivering your order: your order no is:"+id;
	}

}
