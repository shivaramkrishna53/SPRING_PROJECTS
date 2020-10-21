package com.nt.beans;

import java.time.LocalDate;

public class ScheduleReminder {
	LocalDate dt;

	public ScheduleReminder(LocalDate dt) {
		
		this.dt = dt;
	}
	public void reminder()
	{
		LocalDate presentdt=LocalDate.now();
		if(dt.isEqual(presentdt))
			System.out.println("Today u have board metting ");
		else
			System.out.println("Today no mettings are scheduled just relax and take rest");
	}
	

}
