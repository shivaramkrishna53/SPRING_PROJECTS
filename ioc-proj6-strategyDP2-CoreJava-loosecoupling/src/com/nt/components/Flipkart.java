package com.nt.components;

import java.util.Arrays;
import java.util.Random;



public class Flipkart {
Courier c;

public Flipkart()
{
	System.out.println("0-param constructor of Flipkart");
}
public void SetCourier(Courier c)
{
	this.c=c;
	System.out.println("Flipkart set Courier method");
}

public String billcaluclation(String[] items,float[] prices)
{
	int id;
	float sum=0.00f;
	Random r=new Random();
	id=r.nextInt(1000);
	for(float temp:prices)
	{
		sum+=temp;
	}

	
	return "The total bill for items"+Arrays.toString(items)+"with prices:"+Arrays.toString(prices)+"total bill is:"+sum+" and delivery service is"+c.delivery(id);
}
}
