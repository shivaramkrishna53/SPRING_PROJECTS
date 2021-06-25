package com.nt.beans;

import java.util.Random;

public class CricketBat {
	
	public String batcompany;
	public CricketBat(String batcompany)
	{
		this.batcompany=batcompany;
		System.out.println("cricket bat is created, bat name is::"+batcompany);
		
	}
	
	public int runsscoredbybat()
	{
		Random rand=new Random();
		return rand.nextInt(200);
	}
	

}
