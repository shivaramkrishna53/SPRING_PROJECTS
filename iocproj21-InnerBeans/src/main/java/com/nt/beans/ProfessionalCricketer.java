package com.nt.beans;

public class ProfessionalCricketer {

	CricketBat bat;
	String cricketername;
	
	public ProfessionalCricketer(String name,CricketBat bat)
	{
		System.out.println("Profession cricketer consturctor");
		this.bat=bat;
		cricketername=name;
	}
	public void cricketerdetails()
	{
		System.out.println(cricketername+" using "+bat.batcompany);
		System.out.println("Runs scored by bat is:"+bat.runsscoredbybat());
    	
	}
}
