package com.nt.target;

public class BankLoanManagment {
	public float calculateIntrest(float principal,float time,float rate)
	{
		System.out.println("Compound intrest");
		float intrest=0.0f;
		intrest=(float) (((principal)*Math.pow((1+rate/100),time))-principal);
		return intrest;
	}

}
