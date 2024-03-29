package com.nt.FactoryPattern;

import com.nt.component.Bridestone;
import com.nt.component.Car;
import com.nt.component.Ceat;
import com.nt.component.LuxurayCar;
import com.nt.component.NormalCar;
import com.nt.component.Tyre;

public class FactoryPattern {
	public Car getcar(String cartype,String tyrebrand)
	{
		Car c=null;
		if(cartype.equalsIgnoreCase("NormalCar")&&(tyrebrand.equalsIgnoreCase("Bridgestone")))
		{
			Tyre t=new Bridestone();
			 c=new NormalCar(t);
		}
		else
			if(cartype.equalsIgnoreCase("NormalCar")&& tyrebrand.equalsIgnoreCase("Ceat"))
			{
				Tyre t=new Ceat();
				 c=new NormalCar(t);
				
			}
			else
				if(cartype.equalsIgnoreCase("LuxuaryCar")&& tyrebrand.equalsIgnoreCase("BridgeStone"))
				{
					Tyre t=new Bridestone();
					 c=new LuxurayCar(t);
				}
				else
					if(cartype.equalsIgnoreCase("LuxuaryCar")&& tyrebrand.equalsIgnoreCase("Ceat"))
					{
						Tyre t=new Ceat();
						 c=new LuxurayCar(t);
					}
		return c;
	}

}
