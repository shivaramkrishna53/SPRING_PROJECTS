package com.nt.beans;

import java.util.Date;

public class Voter {
private String name;
private int age;
private Date dov;
public String getName() {
	return name;
}
public void setName(String name) {
	System.out.println("Name setter");
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	System.out.println("Age setter");
	this.age = age;
}
public Date getDov() {
	return dov;
}
public void setDov(Date dov) {
	this.dov = dov;
}
public Voter()
{
	System.out.println("0-param constructor");
}

public void myinit()
{
	System.out.println("My init method");
	//instanciating the left over properties
	dov=new Date();
	boolean flag=false;
	//validation logic
	if(name==null)
	{
		System.out.println("Name cannot be empty");
		flag=true;
	}
	//check wheather the injected values are correct or not (bean post processing)
	if(age<0)
		age=-1*age;
	//validation logic
	if(age>100)
	{
		System.out.println("Age cannot be greater than 100");
		flag=true;
	}
	if(flag)
		throw new IllegalArgumentException("Invalid values entered");
}
public void mydestroy()
{
	System.out.println("My destroy method");
name=null;
age=0;
dov=null;
}
public void voting()
{
	if(age>=18)
		System.out.println("You are elgible for voting");
	else
		System.out.println("You are not elgible for voting");
}
}
