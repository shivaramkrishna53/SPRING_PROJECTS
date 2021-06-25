package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.EmployeeBo.EmployeeBo;
import com.nt.dao.IEmployeeDao;

@Service("empser")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeDao dao;
	
	@Override
	public String getEmployeeNameById(int eid) {
		// TODO Auto-generated method stub
		return dao.getEmployeeNameById(eid);
	}

	@Override
	public List<EmployeeBo> getEmployeeDetailsByLocation(String loc1, String loc2) {
		// TODO Auto-generated method stub
		return dao.getEmployeeDetailsByLocation(loc1, loc2);
	}

}
