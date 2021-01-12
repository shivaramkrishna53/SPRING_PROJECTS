package com.nt.service;

public final class BankServiceImpl implements BankService {

	@Override
	public final double calculateInterest(double p, double t, double r) {
		return ((p*t*r)/100);
		
	}

}
