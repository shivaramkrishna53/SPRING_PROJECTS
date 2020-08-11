package com.nareshit.test;

public class newinstance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		Class c=Class.forName(args[0]);
		Object obj=c.newInstance();
		System.out.println("newinstance is created for the:"+obj);
		
		
		Class c2=Class.forName(args[1]);
		Object o=c2.newInstance();
		System.out.println("newinstance is created for::::"+o);
		

	}
		catch(Exception e)
		{
			System.out.println(e.getMessage()+"happy");
		}

}
}
