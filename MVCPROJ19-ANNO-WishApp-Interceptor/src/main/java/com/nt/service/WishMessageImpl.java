package com.nt.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
@Service("wishser")
public class WishMessageImpl implements IWishMessage {

	@Override
	public String processtheWish() {
		LocalDateTime l=LocalDateTime.now();
		int hr=l.getHour();
		if(hr<12)
			return "Good Morning";
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
