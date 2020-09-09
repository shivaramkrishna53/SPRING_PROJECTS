package com.nt.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dtdc")
@Lazy

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
