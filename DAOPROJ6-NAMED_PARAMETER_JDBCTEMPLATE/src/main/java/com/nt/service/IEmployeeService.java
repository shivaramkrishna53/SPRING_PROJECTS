package com.nt.service;

import java.util.List;

import com.nt.EmployeeBo.EmployeeBo;

public interface IEmployeeService {

	
	public String getEmployeeNameById(int eid);
	public List<EmployeeBo> getEmployeeDetailsByLocation(String loc1,String loc2);
}
