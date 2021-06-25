package com.nt.beans;

import java.util.Date;

public class Employee 
{
    private String name;
    private int empid;
    private Date dob;
    private Date dom;
    private Date doj;
	public Employee(String name, int empid, Date dob, Date dom, Date doj) {
		
		this.name = name;
		this.empid = empid;
		this.dob = dob;
		this.dom = dom;
		this.doj = doj;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", empid=" + empid + ", dob=" + dob + ", dom=" + dom + ", doj=" + doj + "]";
	}
	
    
    
}
