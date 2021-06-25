package com.nt.Amazon;

import com.nt.courier.Courier;

public class Amazon {
	
	Courier c;
	
	public Amazon()
	{
		
	}
	
	public Amazon(Courier c)
	{
		this.c=c;
	}

	public void setC(Courier c) {
		this.c = c;
	}
	
	public void producttrack()
	{
		System.out.println("Amazon is shipping ur product via:"+c.delivery());
	}

}
