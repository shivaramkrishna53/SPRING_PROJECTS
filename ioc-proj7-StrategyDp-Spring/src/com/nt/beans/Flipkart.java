package com.nt.beans;

import java.util.Arrays;

public class Flipkart {
	
	Courier cor;
	public Flipkart(Courier cor)
	{
		System.out.println("Flipkart 1 param)");
		this.cor=cor;
	}
	
	public Flipkart()
	{
		System.out.println("Flipkart 0 param");
	}
	
	public void setCor(Courier cor) {
		this.cor = cor;
		System.out.println("Setter injection");
	}

	public void calculatebillanddelivery(String[] products,int[] prices)
	{
		int s=0;
	for(int x:prices)
		s+=x;
	System.out.println("Your products are:"+Arrays.deepToString(products) +" and there prices are:"+Arrays.toString(prices) +"The total is:"+s+"It is delivering by::");
	cor.delivery();	
	}

}
