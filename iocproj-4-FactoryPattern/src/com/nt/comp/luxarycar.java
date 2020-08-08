package com.nt.comp;

public class luxarycar implements Car {
	Tyre t;
	public luxarycar(Tyre t)
	{
		this.t=t;
		System.out.println("luxary car one-param constructor");
	}

	@Override
	public void drive() {
		System.out.println("Luxary cars with the roadgrip of::"+ t.roadgrip());

	}

}
