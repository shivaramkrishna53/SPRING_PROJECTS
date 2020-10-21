package com.nt.beans;

public class Vechile {
	private Engine e=null;
	
	public void setEngine(Engine e) {
		this.e = e;
	}
	public Vechile(Engine e)
	{
		this.e=e;
		System.out.println("Vechile 0-param constructor");
	}
	public void musicplayer() {
		System.out.println("Music is playing");
	}
	public void ac()
	{
		System.out.println("Air conditioner is on");
		
		
	}

	public void journey(String ini,String fin)
	{
		System.out.println("journey method of vechile");
		e.start(ini);
		e.stop(fin);
		
	}
}
////main drawbacks:
//1.The dependent class object that is been injected is visible to all the methods...whereas it is only nessary in one method
//2.if the dependent scope is prototype and target class scope is singleton...if we use setter or constructor injection then the dependent bean
//scope automatically change to singleton.