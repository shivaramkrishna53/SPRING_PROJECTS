package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import com.nt.dto.EmpDto;
import com.nt.service.EmpServiceImp;

public class EmpController {
	private EmpServiceImp ser;
	public EmpController(EmpServiceImp ser) {
		this.ser=ser;
		
	}
	List<EmpDto> Dtolst=new ArrayList<EmpDto>();
	public List<EmpDto> EmpdetailsController(String desg1,String desg2,String desg3) throws Exception
	{
		Dtolst=ser.SendEmpDetails(desg1, desg2, desg3);
		
		return Dtolst;
		
	}

}
