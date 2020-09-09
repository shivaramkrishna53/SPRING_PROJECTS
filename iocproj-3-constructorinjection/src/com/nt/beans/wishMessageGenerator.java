package com.nt.beans;

import java.util.Date;

public class wishMessageGenerator {
	Date d;
	sample s;
	static
	{
		System.out.println("Wish Message Generator static block");
	}
	public wishMessageGenerator(Date d,sample s)
	{
		System.out.println("2-param Wish Message Generator constructor");
		this.s=s;
		this.d=d;
	}
	public wishMessageGenerator()
	{
		System.out.println("0 param wishMessageGenerator class");
	}
	public void callfunmethod()
	{
		s.fun();
	}
	public void wish(String user)
	{
		int hrs=d.getHours();
		if(hrs<12)
			System.out.println("good morning"+ user);
		else
			if(hrs<16)
				System.out.println("good afternoon"+user);
			else
				System.out.println("good night"+user);
	}
	

}
