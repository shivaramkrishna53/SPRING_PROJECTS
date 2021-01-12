package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDto;

public interface IEmployeeMangmntService {
	public Integer registerEmployee(EmployeeDto dto);
	public int[] registerMultipleEmployees(List<EmployeeDto> lstdto);
	public int getEmployeesCount();
	public String removeEmployeeByid(int id);
	public EmployeeDto getEmployeeDetailsbyid(int id);
	public String removeEmployeeByid1(int id);
	public Iterable<EmployeeDto> getAllEmployeeDetails();
	public String removeEmployeesGivenbyEntities(List<EmployeeDto> lstdto);
	public List<EmployeeDto> getEmployeeByIds(List<Integer> ids);

}
