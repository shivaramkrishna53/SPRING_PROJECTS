package com.nt.target;



public final class BankService implements IBankService {
	//primary logics or joinpoints
	public final float calculateSimpleIntrest(float p,float t,float r)
	{
		System.out.println("BankService.calculateSimpleIntrest()");
		return (p*t*r)/100;
	}
	
	public final float calculateCompoundIntrest(float p,float t,float r)
	{
		System.out.println("BankService.calculateCompoundIntrest()");
		return (float) ((p)* Math.pow(1+(r/100),t));
	}

}
