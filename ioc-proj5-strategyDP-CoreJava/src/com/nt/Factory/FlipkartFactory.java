package com.nt.Factory;

import com.nt.components.BlueDart;
import com.nt.components.Dhl;
import com.nt.components.Dtdc;
import com.nt.components.Flipkart;

public class FlipkartFactory {
	//the duty of the factory class is to take the input and based on the inputs it need to return one of its classes.
	public static Flipkart getInstance(String couriercompany)
	{
		Flipkart f=new Flipkart();
		if(couriercompany.equalsIgnoreCase("bluedart"))
		{
			BlueDart bd=new BlueDart();
			f.SetCourier(bd);
		}
		else
			if(couriercompany.equalsIgnoreCase("dhl"))
			{
				Dhl dl=new Dhl();
				f.SetCourier(dl);
			}
			else
				if(couriercompany.equalsIgnoreCase("dtdc"))
				{
					Dtdc d=new Dtdc();
					f.SetCourier(d);
				}
		return f;
	}

}
