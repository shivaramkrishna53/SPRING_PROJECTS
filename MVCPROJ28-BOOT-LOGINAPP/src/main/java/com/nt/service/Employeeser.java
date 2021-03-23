package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.employeelogin;
import com.nt.repo.IEmployeeloginRepo;

@Service("empser")
public class Employeeser implements IEmployeeLogin {

	@Autowired
	IEmployeeloginRepo repo;
	
	@Override
	public String loginchecking(employeelogin e) {
		// TODO Auto-generated method stub
		int c=repo.isuservalid(e.getUsername(), e.getPassword());
		String res=(c>0)? "Valid User access granted" : "Invalid User access denied";
		
		return res;
	}

}
