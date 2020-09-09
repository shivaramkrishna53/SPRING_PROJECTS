package com.nt.component;

public class Bridestone implements Tyre {

	public Bridestone()
	{
		System.out.println("BridgeStone 0-param constructor");
	}
	@Override
	public String roadgrip() {
		return("BridgeStone for mountain drives");

	}

}
