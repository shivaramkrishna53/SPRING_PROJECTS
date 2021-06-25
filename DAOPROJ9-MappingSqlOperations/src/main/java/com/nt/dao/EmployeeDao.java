package com.nt.dao;

import com.nt.bo.EmployeeBo;

public interface EmployeeDao {
	
	public EmployeeBo getempbyid(int eid);
	public float employeesalinrange(float inisal,float fisal);

}
