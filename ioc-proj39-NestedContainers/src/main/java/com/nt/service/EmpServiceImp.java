package com.nt.service;

import java.util.ArrayList;
import java.util.List;

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
		for(int i=0;i<Bolst.size();i++)
		{
			
			
			EmpDto d=new EmpDto();
			d.setEno(Bolst.get(i).getEno());
			d.setEname(Bolst.get(i).getEname());
			d.setJob(Bolst.get(i).getJob());
			d.setSal(Bolst.get(i).getSal());
			d.setDepno(Bolst.get(i).getDepno());
			Dtolst.add(d);
		}
		
		return Dtolst;
		}
	}

}
