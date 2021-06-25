package com.nt.dao;

import java.util.List;

import com.nt.EmployeeBo.EmployeeBo;

public interface IEmployeeDao {

	public String getEmployeeNameById(int eid);
	public List<EmployeeBo> getEmployeeDetailsByLocation(String loc1,String loc2);
}
