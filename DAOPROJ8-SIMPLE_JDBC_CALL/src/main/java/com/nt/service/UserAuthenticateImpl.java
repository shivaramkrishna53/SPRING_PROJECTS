package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IUserAuthenticateDao;

@Service("userser")
public class UserAuthenticateImpl implements IUserAuthenticate {

	@Autowired
	IUserAuthenticateDao dao;
	
	static
	{
		System.out.println("Service class loading");
	}
	
	public UserAuthenticateImpl()
	{
		System.out.println("service class constructor");
	}
	
	@Override
	public String authentication(String username, String password) {
		
		return dao.authentication(username, password);
	}

}
