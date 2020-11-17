package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.CustomerDto;
import com.nt.service.CustomerService;
import com.nt.vo.CustomerVo;
@Controller("custcontroller")
public class CustomerController
{
	@Autowired
	CustomerService ser;
public String getLoanDetails(CustomerVo vo) throws Exception
{
	
	CustomerDto dto=new CustomerDto();
	dto.setCno(Integer.parseInt(vo.getCno()));
	dto.setCname(vo.getCname());
	dto.setCadd(vo.getCadd());
	dto.setCprinamnt(Long.parseLong(vo.getCprinamnt()));
	dto.setCrate(Long.parseLong(vo.getCrate()));
	dto.setCtime(Integer.parseInt(vo.getCtime()));
	 return ser.getLoandetails(dto);
	
}
}
