package com.nt.beans;

import javax.inject.Named;

@Named("dtdc")
public class Dtdc implements Courier {

	public Dtdc()
	{
		System.out.println("Dtdc 0-param constructor called");
	}
	@Override
	public String delivery() {
		
		return "Dtdc delivery method";
	}

}
