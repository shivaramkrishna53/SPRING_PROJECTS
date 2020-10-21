package com.calculateintrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.calculateintrest.dto.CustomerDto;
import com.calculateintrest.service.CustomerServiceImpl;
import com.calculateintrest.vo.CustomerVo;
@Controller("customercontroller")
public class CustomerController {
	@Autowired
	private CustomerServiceImpl ser;
	
	
	CustomerDto d=new CustomerDto();

	
	public String processreq(CustomerVo vo) throws Exception
	{
		d.setCno(Integer.parseInt(vo.getCno()));
		d.setCname(vo.getCname());
		d.setCadd(vo.getCadd());
		d.setCprinamnt(Float.parseFloat(vo.getCprinamnt()));
		d.setCrate(Integer.parseInt(vo.getCrate()));
		d.setCtime(Integer.parseInt(vo.getCtime()));
		String res=ser.calculateIntrest(d);
		return res;
	}

}
