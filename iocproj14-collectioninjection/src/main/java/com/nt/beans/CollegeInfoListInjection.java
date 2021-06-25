package com.nt.beans;

import java.util.List;

public class CollegeInfoListInjection {
	List<String> studnames;
    List<Integer> studids; 
    
    public CollegeInfoListInjection(List<String> studnames,List<Integer> studids)
    {
    	this.studnames=studnames;
    	this.studids=studids;
    }

    public void printvalues()
    {
    	System.out.println(studnames.toString());
    	System.out.println(studids.toString());
    }
}
