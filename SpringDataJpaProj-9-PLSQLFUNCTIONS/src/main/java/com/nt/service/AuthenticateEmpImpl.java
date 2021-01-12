package com.nt.service;

import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ser")

public class AuthenticateEmpImpl implements IAuthenticateEmp {

	@Autowired
	EntityManager em;
	@Override
	public String Authenticate(String username, String password) {
		Session ses=em.unwrap(Session.class);
		String result=ses.doReturningWork(con->{
			try {
			CallableStatement cs=con.prepareCall("{?=call FX_AUTHENTICATION(?,?)}");
			//register out param with jdbctye
			cs.registerOutParameter(1,java.sql.Types.VARCHAR);
			//set the IN params
			cs.setString(2,username);
			cs.setString(3,password);
			//execute the function
			cs.execute();
			//get result from return params
			String output=cs.getString(1);
			return output;
			}
			catch(SQLException se)
			{
				se.printStackTrace();
				return null;
			}
		});
		return result;
	}

}
