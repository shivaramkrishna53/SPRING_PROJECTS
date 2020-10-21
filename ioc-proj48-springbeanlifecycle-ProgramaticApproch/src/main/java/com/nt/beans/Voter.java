package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Voter implements InitializingBean, DisposableBean {
private String name=null;
private int age=0;
private Date d=null;
public void setName(String name) {
	this.name = name;
	System.out.println("Name setter");
}

public void setAge(int age) {
	this.age = age;
	System.out.println("Age setter");
}

public void setD(Date d) {
	this.d = d;
}
 public Voter() {
	// TODO Auto-generated constructor stub
	System.out.println("0- param constructor");
}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Destroy method");
		//used to nullify the properties and closing or non java resources
		name=null;
		age=0;
		d=null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Init method");
		boolean flag=false;
		//initializing left over propereties
		d=new Date();
		//checking wheather important injections are done(validation)
		if(name==null)
		{
			System.out.println("Name cannot be empty");
			flag=true;
		}
		
		//checking wheather the injected values are right(Bean post processor)
		if(age<0)
			age=-1*age;
		if(age>100)
		{
			System.out.println("Age cannot be greater than 100");
			flag=true;
		}
		if(flag)
			throw new IllegalArgumentException("Invalid inputs");

	}
	public void voting()
	{
		if(age>=18)
			System.out.println("Elgible for voting");
		else
			System.out.println("Not elgible for voting");
	}

}
