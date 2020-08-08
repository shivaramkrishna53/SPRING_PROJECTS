package com.nt.factory;

import com.nt.comp.Car;
import com.nt.comp.Tyre;
import com.nt.comp.apollotyre;
import com.nt.comp.budgetcar;
import com.nt.comp.luxarycar;
import com.nt.comp.mrftyre;

public class factory {

	public static Car instantiatecar(String car)
	{
		Car c=null;
		Tyre t=null;
		if(car.equalsIgnoreCase("luxarycar"))
		{
			t=new apollotyre();
			c=new luxarycar(t);
		}
		else
			if(car.equalsIgnoreCase("budgetcar"))
			{
				t=new mrftyre();
				c=new budgetcar(t);
			}
		return c;
	}
}
