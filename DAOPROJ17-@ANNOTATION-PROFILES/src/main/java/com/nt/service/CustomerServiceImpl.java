package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.bo.CustomerBo;
import com.nt.dao.CustomerDao;
import com.nt.dto.CustomerDto;
@Service("custser")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao dao;
	
	@Override
	public String getLoandetails(CustomerDto dto) throws Exception {
		CustomerBo bo=new CustomerBo();
		bo.setCname(dto.getCname());
		bo.setCno(dto.getCno());
		bo.setCadd(dto.getCadd());
		bo.setCprinamnt(dto.getCprinamnt());
		bo.setCtime(dto.getCtime());
		bo.setCrate(dto.getCrate());
		long totamnt=(dto.getCprinamnt()*dto.getCtime()*dto.getCrate())/100;
		bo.setCtotalinterest(totamnt);
	
		
		int res=dao.insertloandetails(bo);
		           
		if(res==0)
			return "record not inserted";
		else
			return "record inserted successfully";
		 
		      
		
		
	}

}
