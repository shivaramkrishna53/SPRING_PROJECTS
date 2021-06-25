package com.nt.beans;

import java.util.Arrays;
import java.util.Date;

public class EmployeeInfo {
	
	int[] empids;
	Date[] empdoj;
	
	public EmployeeInfo(int[] empids)
	{
		this.empids=empids;
	}

	public void setEmpdoj(Date[] empdoj) {
		this.empdoj = empdoj;
	}
	
	public void printvalues()
	{
		System.out.println(Arrays.deepToString(empdoj));
		System.out.println(Arrays.toString(empids));
	}

}
