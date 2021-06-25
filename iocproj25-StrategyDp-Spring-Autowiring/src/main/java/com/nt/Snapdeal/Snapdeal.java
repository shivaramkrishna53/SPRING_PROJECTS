package com.nt.Snapdeal;

import com.nt.courier.Courier;

public class Snapdeal {
	
	Courier c;
	
	public Snapdeal(Courier c)
	{
		this.c=c;
	}
	
	public void producttrack()
	{
		System.out.println("Your Snapdeal product is delivery via:"+ c.delivery());
	}
	
	

}
