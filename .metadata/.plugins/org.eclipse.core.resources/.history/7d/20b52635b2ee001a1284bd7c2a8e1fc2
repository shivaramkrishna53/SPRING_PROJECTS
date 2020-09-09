package com.calculateintrest.controller;

import com.calculateintrest.dto.CustomerDto;
import com.calculateintrest.service.CustomerServiceImpl;
import com.calculateintrest.vo.CustomerVo;

public class CustomerController {
	private CustomerServiceImpl ser;
	CustomerDto d=new CustomerDto();

	public CustomerController(CustomerServiceImpl ser) {
		this.ser = ser;
	}
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
