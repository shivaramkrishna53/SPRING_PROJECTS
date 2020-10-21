package com.nt.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("wmg")
public class WishMessageGenerator {
	static
	{
		System.out.println("Static block of WishMessageGenerator");
	}
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator constructor");
	}

	@Autowired
	private LocalDateTime dt;
	public void wishmessage(String user)
	{
		if(dt.getHour()<12)
			System.out.println("Goood Morning:"+user);
		else
			if(dt.getHour()<16)
				System.out.println("Good afternoon:"+user);
			else
				if(dt.getHour()<20)
				System.out.println("Good Evening:"+user);
				else
					System.out.println("Good Night:"+user);
	}
	
	
}
