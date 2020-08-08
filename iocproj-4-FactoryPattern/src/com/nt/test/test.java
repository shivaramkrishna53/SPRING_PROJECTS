package com.nt.test;

import com.nt.comp.Car;
import com.nt.factory.factory;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car cr=null;
		cr=factory.instantiatecar("luXarYcaR");
		cr.drive();
		cr=factory.instantiatecar("BUDgetCaR");
		cr.drive();
	

	}

}
