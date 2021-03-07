package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IcustomerDao;
import com.nt.model.Customer;

@Service("custser")
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
	IcustomerDao dao;
	
	@Override
	public String registerCustomer(Customer c) {
		// TODO Auto-generated method stub
		int n=dao.registerCustomerintoDb(c);
		String s=(n==1)? "Registration sucessful":"Registration Failed";
		return s;
	}

}
