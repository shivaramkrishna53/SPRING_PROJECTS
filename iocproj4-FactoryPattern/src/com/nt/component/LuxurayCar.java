package com.nt.component;

public class LuxurayCar implements Car {

	Tyre t;
 public LuxurayCar(Tyre t) {
		this.t=t;
		System.out.println("1-param LuxurayCar called");	
		}
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("LuxuaryCar is driving on:"+t.roadgrip());

	}

}
