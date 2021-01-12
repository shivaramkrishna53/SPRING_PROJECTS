package com.nt.dao;

import java.util.List;

import com.nt.bo.CustomerBo;

public interface ICustomerdetails {

	public CustomerBo getdetailsbycno(int cno);
	public List<CustomerBo> getdetailsbyloc(String loc1,String loc2);
	public List<CustomerBo> getdetailsbybillamnt(int billamnt);
	
}
