package com.nt.beans;

public class Dhl implements Courier {

	
	public Dhl() {
		System.out.println("Dhl 0 param constructor");
	}

	@Override
	public void delivery() {
		// TODO Auto-generated method stub
		System.out.println("Dhl is delivering ur product");
		
	}

}
