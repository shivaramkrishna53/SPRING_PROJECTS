package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CustomerDetailsServImpl;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml");
		CustomerDetailsServImpl ser=ctx.getBean("custser",CustomerDetailsServImpl.class);
		try
		{
		System.out.println(ser.getdetailsbycno(105));
		System.out.println(ser.getdetailsbyloc("hyd","alwa"));
		System.out.println(ser.getdetailsbybillamnt(2000));
		}
		catch(Exception e)
		{
			System.err.println("Wrong Empid given to process");
			e.printStackTrace();
		}
		

	}

}
