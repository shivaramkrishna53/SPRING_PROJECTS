package com.nt.beans;

public class Dhl implements Courier {

	public Dhl()
	{
		System.out.println("Dhl 0-param constructor");
	}
	@Override
	public String delivery() {
		// TODO Auto-generated method stub
		return "Dhl delivery method";
	}

}
