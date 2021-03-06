package com.nt.Factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.nt.components.BlueDart;
import com.nt.components.Courier;
import com.nt.components.Dhl;
import com.nt.components.Dtdc;
import com.nt.components.Flipkart;

public class FlipkartFactory {
	//the duty of the factory class is to take the input and based on the inputs it need to return one of its classes.
	static Properties prop=new Properties();
	static
	{
		try
		{
			//input stream pointing to the file location
		InputStream is=new FileInputStream("src/com/nt/Commons/info.properties");
		//creating the properties object
		
		//load the file we got from input stream to properties object
		prop.load(is);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}
	
	public static Flipkart getInstance()
	{
		Flipkart f=new Flipkart();
		try
		{
		
		//loading of the dependent class from the properties class
		Class c1=Class.forName(prop.getProperty("sdp.dependent"));
		
//		Object ob=c1.newInstance();
//		Courier c=(Courier)ob;
		
	Courier c=(Courier)c1.newInstance(); //same as above
		f.SetCourier(c);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}

}
