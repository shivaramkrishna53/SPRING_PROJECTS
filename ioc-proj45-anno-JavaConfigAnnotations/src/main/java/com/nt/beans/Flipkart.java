package com.nt.beans;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Named("flipkart")
public class Flipkart {
	
	  @Inject
	  @Named("dtdc")
	 
	private Courier c ;
	
	
	public Flipkart()
	{
		System.out.println("Flipkart 0-param constructor");
	}
	
	
	public void callcouriercompanies()
	{
		System.out.println(c.delivery());
	}

}
