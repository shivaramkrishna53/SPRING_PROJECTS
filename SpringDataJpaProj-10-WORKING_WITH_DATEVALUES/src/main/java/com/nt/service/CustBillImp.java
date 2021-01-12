package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.CustDto;
import com.nt.entity.CustBillDetails;
import com.nt.repo.ICustRepo;
@Service("custser")
public class CustBillImp implements ICustBill {

	@Autowired
	ICustRepo repo;
	@Override
	public String registerCustomer(CustDto dto) {
		// TODO Auto-generated method stub
		CustBillDetails entity=new CustBillDetails();
		BeanUtils.copyProperties(dto,entity);
		int id=repo.save(entity).getCustid();
		return "Customer got registered with id"+id;
	}
	@Override
	public CustDto getCustByid(int id) {
		CustBillDetails entity=repo.findById(id);
		if(entity!=null)
		{
		CustDto dto=new CustDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
		}
		else
			return null;
	}

}
