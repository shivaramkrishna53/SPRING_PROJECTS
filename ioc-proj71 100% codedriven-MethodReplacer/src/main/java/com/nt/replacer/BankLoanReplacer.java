package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;
@Component("loanrep")
public class BankLoanReplacer implements MethodReplacer {

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Simple intrest");
		float p=(float) args[0];
		float t=(float) args[1];
		float r=(float) args[2];
		return (p*t*r)/100;
		
	}

}
