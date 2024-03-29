package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	private Date dt;
	
	public void setDt(Date dt)
	{
		this.dt=dt;
	}
	public String wishMsg(String user)
	{
		int hr=0;
		hr=dt.getHours();
		if(hr<12)
			return "Good morning::"+user;
		else
			if(hr<16)
				return "Good Afternoon::"+user;
			else
				if(hr<20)
					return "Good Evening::"+user;
				else
					return "Good Night::"+user;
	}

}
