package com.nt.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TestDriveAduitingAspect {
	public void testdrive(String car,float price,String executive) throws IOException
	{
		System.out.println("Auditing before advice");
		System.out.println("TestDriveAduitingAspect.testdrive()");
		Writer wt=new FileWriter("E:/auditing.txt",true);
		wt.write("Test Drive of::"+"Car::"+car+"costs::"+price+"under executive"+executive);
		wt.flush();
	}

}
