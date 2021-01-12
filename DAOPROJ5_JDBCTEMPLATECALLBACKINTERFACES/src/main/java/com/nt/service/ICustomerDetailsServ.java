package com.nt.service;

import java.util.List;

import com.nt.bo.CustomerBo;

public interface ICustomerDetailsServ {

	public CustomerBo getCustomerDetails(int cno);
	public List<CustomerBo> getcustbyloc(String loc1,String loc2);
	public List<CustomerBo> getcustbybillamnt(int amnt);
}
