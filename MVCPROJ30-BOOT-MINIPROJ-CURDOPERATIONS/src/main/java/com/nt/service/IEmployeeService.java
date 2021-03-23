package com.nt.service;

import java.util.Optional;

import com.nt.model.Employees;
public interface IEmployeeService {
	public String registerEmployee(Employees e);
	public Iterable<Employees> getAllEmployeedetails();
	public Employees updateEmployee(int no);
	public String updateEmployeeDetails(Employees e);
    public String deleteEmployee(int eno);
}
