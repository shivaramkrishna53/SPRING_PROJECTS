package com.nt.aspect;


import java.util.Arrays;
import java.util.HashMap;


import org.aspectj.lang.ProceedingJoinPoint;

public class CachingAspect {

	HashMap<String,Object> cache=new HashMap<String, Object>();
	public Object Caching(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("CachingAspect.Caching()--->Entering");
		Object result;
		
		String key=pjp.getSignature()+Arrays.toString(pjp.getArgs());
		if(!cache.containsKey(key))
		{
			System.out.println("from target method");
			result=pjp.proceed();
			cache.put(key,result);
		}
		else
		{
			System.out.println("From cache");
			result=cache.get(key);
			
		}
		System.out.println("CachingAspect.Caching()--->leaving");
		return result;
	}
}
