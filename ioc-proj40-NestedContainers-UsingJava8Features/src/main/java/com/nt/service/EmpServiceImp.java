package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmpBo;
import com.nt.dao.EmpDaoImp;
import com.nt.dto.EmpDto;

public class EmpServiceImp implements EmpService {

	EmpDaoImp dao=null;
	List<EmpDto> Dtolst=new ArrayList<EmpDto>();
	public EmpServiceImp(EmpDaoImp dao) {
		this.dao=dao;
		
	}
	
	@Override
	
	public List<EmpDto> SendEmpDetails(String desg1, String desg2, String desg3) throws Exception {
		// TODO Auto-generated method stub
		
		desg1=desg1.toUpperCase();
		desg2=desg2.toUpperCase();
		desg3=desg3.toUpperCase();
		List<EmpBo> Bolst=dao.getEmpDetails(desg1, desg2, desg3);
		if(Bolst==null)
			return null;
		else
		{
		Bolst.forEach(bo->{
			EmpDto dto=new EmpDto();
			BeanUtils.copyProperties(bo,dto);
			Dtolst.add(dto);
		});
		
		return Dtolst;
		}
	}

}
