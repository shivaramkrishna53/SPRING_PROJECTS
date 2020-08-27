package com.nt.Test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale loc=null;
		ResourceBundle rb=null;
		loc=new Locale(args[0], args[1]);
		rb=ResourceBundle.getBundle("com/nt/commons/App",loc);
		System.out.println(rb.getString("btn1.cap")+"  "+rb.getString("btn2.cap")+"  "+rb.getString("btn3.cap")+"  "+rb.getString("btn4.cap"));
		

	}

}


