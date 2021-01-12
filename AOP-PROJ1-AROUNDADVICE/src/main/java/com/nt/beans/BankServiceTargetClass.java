package com.nt.beans;

public class BankServiceTargetClass {
	//primary logics
	public double CalculateInterestAmount(double principal,double time,double rate)
	{
		System.out.println("BankServiceTargetClass.CalculateInterestAmount()");
		return (principal*time*rate)/100;
	}

}
