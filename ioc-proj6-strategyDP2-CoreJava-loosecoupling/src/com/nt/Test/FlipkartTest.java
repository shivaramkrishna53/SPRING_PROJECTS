package com.nt.Test;

import java.util.Scanner;

import com.nt.Factory.FlipkartFactory;
import com.nt.components.Flipkart;

public class FlipkartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		
		String couriername=null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many items to u want to purchase:");
		int n=sc.nextInt();
		String items[]=new String[n];
		float prices[]=new float[n];
		System.out.println("Enter the set of items u want");
		for(i=0;i<n;i++)
		{
		  items[i]=sc.next();	
		}
		System.out.println("Flipkart please enter the product prices::");
		for(i=0;i<n;i++)
		{
			prices[i]=sc.nextFloat();
		}
		
		Flipkart f=new Flipkart();
		f=FlipkartFactory.getInstance();
		System.out.println(f.billcaluclation(items, prices));
		

	}

}
