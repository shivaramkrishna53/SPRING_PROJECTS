package com.nt.service;

import java.util.Calendar;

public class WishMessage implements IWishMessage {

	@Override
	public String getWishMessage() {
		Calendar cl=Calendar.getInstance();
		int hr=cl.get(Calendar.HOUR_OF_DAY);
		if(hr<12)
			return "Good morning";
		else
			if(hr<16)
				return "Good Afternoon";
			else
				if(hr<20)
					return "Good Evening";
				else
					return "Good Night";
		
		
	}

}
