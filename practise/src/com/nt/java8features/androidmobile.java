package com.nt.java8features;
//java8 feature of having method definations inside interface and make them as default method
interface mobile
{
	public void call();
	default void message()  //java 8 feature in which we can have the definations in the interface by making it as default
	{
	System.out.println("message sent");	
	}
}


public  class androidmobile implements mobile{
	
	public void call()
	{
		System.out.println("mobile ");
	}
	
	
	
	
	
	public static void main(String args[])
	{
		
		mobile m=new androidmobile();
		m.call();
		m.message();
		
	}

}
