package com.nt.beans;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Named("flipkart")
public class Flipkart {
	
	  
	@Resource(name="dhl")
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
