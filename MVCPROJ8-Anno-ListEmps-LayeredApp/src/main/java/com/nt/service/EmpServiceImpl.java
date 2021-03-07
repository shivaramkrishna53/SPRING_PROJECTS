package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBo;
import com.nt.dao.IEmpDao;
import com.nt.dto.EmployeeDto;

@Service("empservice")
public class EmpServiceImpl implements IEmpService {
   
	@Autowired
	IEmpDao dao;
	
	@Override
	public List<EmployeeDto> getEmpdetails() {
		// TODO Auto-generated method stub
		List<EmployeeDto> lstempdto=new ArrayList();
		
		List<EmployeeBo> lstempbo=dao.getEmpDetails();
		lstempbo.forEach(bo->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(bo,dto,"empsal");
			dto.setEsal(Math.round(bo.getEsal()));
			dto.setSno(lstempdto.size()+1);
			lstempdto.add(dto);
		});
		
		return lstempdto;
	}

}
