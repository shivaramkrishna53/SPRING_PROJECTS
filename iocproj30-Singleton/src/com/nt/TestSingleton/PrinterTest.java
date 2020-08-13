package com.nt.TestSingleton;

import com.nt.Singleton.Printer;

public class PrinterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Printer p1=null,p2=null;
		p1=Printer.createInstance();
		p2=Printer.createInstance();
		System.out.println("p1 obj reference:::"+p1.hashCode());
		System.out.println("p2 obj reference:::"+p2.hashCode());
		p1.print();
		p2.print();

	}

}
