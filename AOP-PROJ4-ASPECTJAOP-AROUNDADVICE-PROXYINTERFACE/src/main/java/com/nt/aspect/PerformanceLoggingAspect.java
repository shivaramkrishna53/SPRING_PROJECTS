package com.nt.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
//aspect class
public class PerformanceLoggingAspect {
	//advices
	public Object monitor(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("PerformanceLoggingAspect.monitor()");
		//pre-logics
		float starttime=System.currentTimeMillis();
		System.out.println(starttime);
		Object result=pjp.proceed();
		float endtime=System.currentTimeMillis();
		//post logics
		System.out.println(endtime);
		System.out.println("Total time taken is:::"+(endtime-starttime)+" ms");
		System.out.println(pjp.getSignature()+"  compound intrest::: "+Arrays.toString(pjp.getArgs()));
		return result;
		
	}
	
	public Object logging(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("PerformanceLoggingAspect.logging()");
		System.out.println("entering to ::"+pjp.getSignature()+"with arguments"+Arrays.toString((pjp.getArgs())));
		Object result=pjp.proceed();
		System.out.println("leaving from::"+pjp.getSignature()+"with arguments"+Arrays.toString(pjp.getArgs()));
		return result;
	}
	

}
