package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("flipkart")
@Scope("prototype")

public class Flipkart {
	
	  @Autowired
	  @Qualifier("bluedart")
	 
	private Courier c;
	
	  public Flipkart()
	  {
		  System.out.println("Flipkart 0-param constructor called");
	  }
	
	  
	
	
	public void callcouriercompanies()
	{
		System.out.println(c.delivery());
	}

}
