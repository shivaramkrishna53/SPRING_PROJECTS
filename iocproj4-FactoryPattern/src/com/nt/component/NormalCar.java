package com.nt.component;

public class NormalCar implements Car {

	Tyre t;
	 public NormalCar(Tyre t) {
		this.t=t;
		System.out.println("NormalCar 1-param constructor");
	}
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Normal car is driving" + t.roadgrip());
		

	}

}
