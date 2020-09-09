package com.nt.Test;

import java.util.Scanner;

import com.nt.FactoryPattern.FactoryPattern;
import com.nt.component.Car;

public class FactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FactoryPattern fac=new FactoryPattern();
		System.out.println("Enter the car type and tyre brand");
		Scanner sc=new Scanner(System.in);
		String cartype=sc.next();
		String tyrebrand=sc.next();
		Car c=fac.getcar(cartype, tyrebrand);
		c.drive();
	}

}
