package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDto;

public interface IEmpSer {
	public List<EmployeeDto> getEmpDetailsInEsalRange(float inisal,float fisal);
	public List<Object[]> getEmpdetails_withcities(String city1,String city2);
}
