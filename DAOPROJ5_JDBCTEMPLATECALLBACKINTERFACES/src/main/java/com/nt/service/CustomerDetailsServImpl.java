package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBo;
import com.nt.dao.ICustomerdetails;
@Service("custser")
public class CustomerDetailsServImpl implements ICustomerdetails {
	@Autowired
	ICustomerdetails dao;

	@Override
	public CustomerBo getdetailsbycno(int cno) {
		// TODO Auto-generated method stub
		CustomerBo bo=dao.getdetailsbycno(cno);
		
		return bo;
	}

	@Override
	public List<CustomerBo> getdetailsbyloc(String loc1, String loc2) {
		// TODO Auto-generated method stub
		
		return dao.getdetailsbyloc(loc1, loc2);
	}

	@Override
	public List<CustomerBo> getdetailsbybillamnt(int billamnt) {
		return dao.getdetailsbybillamnt(billamnt);
	}

}
