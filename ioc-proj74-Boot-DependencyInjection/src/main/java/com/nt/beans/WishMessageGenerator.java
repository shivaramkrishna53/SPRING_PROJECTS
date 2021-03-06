package com.nt.beans;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	@Autowired
	private LocalTime obj;
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator constructor");
	}
	int hrs=obj.getHour();
	public String wishmessage(String user)
	{
		if(hrs<12)
			return "Good Morning"+user;
		else
			if(hrs<16)
				return "Good AfterNoon"+user;
			else
				if(hrs<20)
					return "Good Evening"+user;
				else
					return "Good Night"+user;
	}

}
