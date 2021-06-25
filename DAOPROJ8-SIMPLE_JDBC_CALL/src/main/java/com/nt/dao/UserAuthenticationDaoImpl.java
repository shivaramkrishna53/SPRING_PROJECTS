package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("userdao")
public class UserAuthenticationDaoImpl implements IUserAuthenticateDao {
	
	@Autowired
	SimpleJdbcCall sjc;

	static
	{
		System.out.println("Dao class loading");
	}
	
	public UserAuthenticationDaoImpl()
	{
		System.out.println("Dao class constructor");
	}
	@Override
	public String authentication(String username, String password) {
	
		sjc.setProcedureName("LOGINUSER");
		Map<String,Object> inparams=Map.of("uname",username,"pwd",password);
		Map<String,?> res=sjc.execute(inparams);
		return (String) res.get("RESULT");
		
	}

}
