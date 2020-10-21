package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmpDto;
import com.nt.service.EmpServiceImp;
import com.nt.vo.EmpVo;
@Controller("controller")
@Lazy
public class EmpController {
	@Autowired
	private EmpServiceImp ser;
	EmpDto dto=new EmpDto();
	EmpVo vo=new EmpVo();
	
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
