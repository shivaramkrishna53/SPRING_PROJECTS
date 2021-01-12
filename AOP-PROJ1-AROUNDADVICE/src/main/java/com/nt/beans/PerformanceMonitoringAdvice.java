package com.nt.beans;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceMonitoringAdvice implements MethodInterceptor {
//secondry logics
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		//pre-logic
		System.out.println("PerformanceMonitoringAdvice.pre-logic-invoke()");
		double starttime=System.currentTimeMillis();
		System.out.println("Starttime is:"+starttime);
		//To modify the target method arg values
				Object args[]=invocation.getArguments();
				if(((Double)args[0])>50000)
					  args[2]=((Double)args[2])-0.5d;
				
				//to modify the target method flow of execution
				if(((Double)args[0])<0 || ((Double)args[1])<0 || ((Double)args[2])<0)
					throw new IllegalArgumentException("invalid inputs");
					
					
				
		Object result=invocation.proceed();
		//post-logic
		System.out.println("PerformanceMonitoringAdvice.post-logic-invoke()");
		double endtime=System.currentTimeMillis();
		System.out.println("Endtime is::"+endtime);
		
		System.out.println("Total time taken is:::"+(endtime-starttime)+" milliseconds");
		System.out.println("Method name is::"+invocation.getMethod()+"Method args are::"+Arrays.toString(invocation.getArguments()));
		//to modify the target method return value
		result=((Double)result)+((Double)result)*0.5;
		return result;
	}
	

}
