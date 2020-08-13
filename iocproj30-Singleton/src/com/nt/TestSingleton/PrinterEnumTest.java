package com.nt.TestSingleton;

import com.nt.Singleton.PrinterEnum;

public class PrinterEnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrinterEnum p1=null,p2=null;
		p1=PrinterEnum.Instance;
		p2=PrinterEnum.Instance;
		System.out.println("p1 obj reference:::"+p1.hashCode());
		System.out.println("p2 obj reference:::"+p2.hashCode());
		p1.printmsg();
		p2.printmsg();

	}

}
