package com.nt.beans;
import java.lang.reflect.Constructor;

import com.nt.beans.*;

public class sampletest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Class c1=Class.forName(args[0]);
		Class c2=Class.forName(args[1]);
		Object obj1=c1.newInstance();
		Object obj2=c2.newInstance();
		Constructor cons[]=c1.getDeclaredConstructors();
		cons[0].newInstance();
		cons[1].newInstance(1,2);
		
		Constructor cons2[]=c2.getDeclaredConstructors();
		cons2[0].newInstance();
		cons2[1].newInstance(2,3);
		

	}

}
