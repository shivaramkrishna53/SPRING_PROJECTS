package com.nt.advice;

import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.sun.source.tree.MethodInvocationTree;

public class PerformanceMonitoring implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		//pre logics
		double starttime=System.currentTimeMillis();
		System.out.println(starttime);
		//call of target class method
		Object result=invocation.proceed();
		//post logics
		double endtime=System.currentTimeMillis();
		System.out.println(endtime);
		System.out.println("total time taken is:"+(endtime-starttime));
		return result;
	}

}
