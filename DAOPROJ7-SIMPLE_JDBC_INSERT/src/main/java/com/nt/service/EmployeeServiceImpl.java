package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBo;
import com.nt.dao.IEmployeeDao;
import com.nt.dto.EmployeeDto;

@Service("empser")
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	IEmployeeDao dao;
	
	@Override
	public int recordinsert(EmployeeDto dto) {
		// TODO Auto-generated method stub
		EmployeeBo bo=new EmployeeBo();
		BeanUtils.copyProperties(dto, bo);
		int count=dao.recordinsert(bo);
		return count;
	}

}
