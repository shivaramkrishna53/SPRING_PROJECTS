package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBo;
import com.nt.dao.EmployeeDao;

@Service("empser")
public class EmployeeSerImpl implements IEmployeeSer {

	@Autowired
	EmployeeDao dao;
	
	@Override
	public EmployeeBo getempbyid(int eid) {
		
		return dao.getempbyid(eid);
	}

	@Override
	public float employeesalinrange(float inisal,float fisal) {
		// TODO Auto-generated method stub
		return dao.employeesalinrange(inisal,fisal);
	}

}
