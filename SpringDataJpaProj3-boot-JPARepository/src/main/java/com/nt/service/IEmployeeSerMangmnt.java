package com.nt.service;

import java.util.List;

import com.nt.dto.employeedto;
import com.nt.entity.employee;

public interface IEmployeeSerMangmnt {
	public employeedto getEmployeeByid(int id);
	public List<employeedto> fetchEmployeesExampleData(employeedto dto, String property,boolean asc);
	public void deleteinbulk(List<employeedto> lstdto);

}
