package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.dto.EmpDto;
import com.nt.service.EmpServiceImp;
import com.nt.vo.EmpVo;

public class EmpController {
	private EmpServiceImp ser;
	EmpDto dto=new EmpDto();
	EmpVo vo=new EmpVo();
	public EmpController(EmpServiceImp ser) {
		this.ser=ser;
		
	}
	List<EmpVo> Volst=new ArrayList<EmpVo>();
	List<EmpDto>Dtolst=new ArrayList<EmpDto>();
	public List<EmpVo> EmpdetailsController(String desg1,String desg2,String desg3) throws Exception
	{
		
		Dtolst=ser.SendEmpDetails(desg1, desg2, desg3);
		Dtolst.forEach(dto->{
			BeanUtils.copyProperties(dto,vo);
			vo.setDepno(String.valueOf(dto.getDepno()));
			vo.setEno(String.valueOf(dto.getEno()));
			vo.setSal(String.valueOf(dto.getSal()));
			Volst.add(vo);
			
		});
		
		return Volst;
		
	}

}
