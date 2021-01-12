package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDto;

public interface IEmpSerMgmnt {
	public List<EmployeeDto> getEmployeeDetailsByGivenProperty(String property,boolean asc);

	public List<EmployeeDto> DisplayEmployeeDetailsByPages(int pageno,int pagesizes);
	public void getRecordsbyPagenation(int pagesize);

}
