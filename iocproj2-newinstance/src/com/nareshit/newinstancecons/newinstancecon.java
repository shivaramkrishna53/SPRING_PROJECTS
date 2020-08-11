package com.nareshit.newinstancecons;

import java.lang.reflect.Constructor;

public class newinstancecon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Class c=Class.forName(args[0]);
		Constructor cons[]=c.getDeclaredConstructors();
		Object o1=cons[2].newInstance(10,20);
		Object o2=cons[1].newInstance(10);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	}


