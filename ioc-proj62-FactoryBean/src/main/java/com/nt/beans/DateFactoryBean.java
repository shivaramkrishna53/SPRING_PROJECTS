package com.nt.beans;

import java.time.LocalDate;

import org.springframework.beans.factory.FactoryBean;

public class DateFactoryBean implements FactoryBean<LocalDate>{

	int dt,mnt,year;
	
	public DateFactoryBean(int dt, int mnt, int year) {
		
		this.dt = dt;
		this.mnt = mnt;
		this.year = year;
	}

	@Override
	public LocalDate getObject() throws Exception {
		// TODO Auto-generated method stub
		return LocalDate.of(year,mnt,dt);
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return LocalDate.class;
	}
	@Override
	public boolean isSingleton() 
	{
		return false;
	}

}
