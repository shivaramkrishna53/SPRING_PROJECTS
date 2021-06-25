package com.nt.Flipkart;

import com.nt.courier.Courier;

public class Flipkart {
	
	Courier corier1;
	
	public void setCorier1(Courier c)
	{
		corier1=c;
	}
	
	public void producttrack()
	{
		System.out.println("Your Flipkart product is delivery via:"+ corier1.delivery());
	}

}
