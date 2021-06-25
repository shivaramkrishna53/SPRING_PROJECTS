package com.nt.beans;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class tcs 
{
	private long id;
	private String ceo;
	private String headoffice;
	private Date doj;
	private float initialctc;
	private String empname;
	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "tcs [id=" + id + ", ceo=" + ceo + ", headoffice=" + headoffice + ", doj=" + doj + ", initialctc="
				+ initialctc + ", empname=" + empname + "]";
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public void setHeadoffice(String headoffice) {
		this.headoffice = headoffice;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public void setInitialctc(float initialctc) {
		this.initialctc = initialctc;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public tcs(long id, String ceo, String headoffice, Date doj, float initialctc, String empname) {
		
		this.id = id;
		this.ceo = ceo;
		this.headoffice = headoffice;
		this.doj = doj;
		this.initialctc = initialctc;
		this.empname = empname;
	}
	public tcs()
	{
		
	}
	
	
	
	
	
   
}
