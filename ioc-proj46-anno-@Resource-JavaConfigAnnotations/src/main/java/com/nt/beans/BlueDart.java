package com.nt.beans;

import javax.inject.Named;

@Named("bluedart")

public class BlueDart implements Courier {

	public BlueDart()
	{
		System.out.println("Blue Dart 0-param constructor");
	}
	@Override
	public String delivery() {
		// TODO Auto-generated method stub
		return "BlueDart delivery method";
	}

}
