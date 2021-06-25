package com.nt.service;

import com.nt.bo.EmployeeBo;

public interface IEmployeeSer {

	public EmployeeBo getempbyid(int eid);
	public float employeesalinrange(float inisal,float fisal);
}
