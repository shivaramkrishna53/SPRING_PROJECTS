package com.nt.beans;

import java.util.Set;

public class PhoneNumbers {

	private Set<Integer> phnos;

	public void setPhnos(Set<Integer> phnos) {
		this.phnos = phnos;
	}
	
	public void printvalues()
    {
		System.out.println(phnos.toString());
    }
}
