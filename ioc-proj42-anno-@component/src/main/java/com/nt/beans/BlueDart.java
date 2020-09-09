package com.nt.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Lazy(value=true)

@Component("bluedart")


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
