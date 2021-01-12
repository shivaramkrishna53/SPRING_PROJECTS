package com.nt.target;

import org.aspectj.lang.ProceedingJoinPoint;

public interface IBankService {

	public float calculateSimpleIntrest(float p,float t,float r) throws Throwable;
	public float calculateCompoundIntrest(float p,float t,float r) throws Throwable;
}
