package com.cb.locator;

import org.springframework.beans.factory.FactoryBean;

import com.ipl.external.iiplscorecomp;
import com.ipl.external.iplscorecomp;

public class IPLScoreCompServiceLocatorFactoryBean implements FactoryBean<iiplscorecomp> {

	private iiplscorecomp com=null;
	 public IPLScoreCompServiceLocatorFactoryBean() {
		com=new iplscorecomp();
	}
	@Override
	public iiplscorecomp getObject() throws Exception {
		return com;
	}

	@Override
	public Class<iiplscorecomp> getObjectType() {
		return iiplscorecomp.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
	

}
