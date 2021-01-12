package com.nt.target;

public class CarShowRoom {
	public String buyCar(String car,float price,String executive)
	{
		if(car.equalsIgnoreCase("waganor")||car.equalsIgnoreCase("Tata"))
		{
			return "Car::"+car+" is avilable for sale";
		}
		else
		{
			return "No car is available with that car name::"+car;
		}
	}

}
