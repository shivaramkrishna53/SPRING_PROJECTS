package com.nt.components;

public class BlueDart implements Courier {

	public BlueDart()
	{
		System.out.println("Blue Dart 0-param called");
	}
	@Override
	public String delivery(int id) {
		// TODO Auto-generated method stub
		return "Blue dart is delivering your order: your order no is:"+id;
		
	}

}
