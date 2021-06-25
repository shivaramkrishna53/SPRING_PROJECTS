package com.nt.beans;

import java.util.Map;
import java.util.Properties;

public class UniversityInfo {

	private Map<Integer,String> faculty;

	private Properties pr;
	
	public void setPr(Properties pr) {
		this.pr = pr;
	}

	public UniversityInfo(Map<Integer, String> faculty) {
		this.faculty = faculty;
	}
	
	public void printvalues()
    {
		System.out.println(faculty.toString());
		System.out.println(pr.toString());
    }
	
	
}
