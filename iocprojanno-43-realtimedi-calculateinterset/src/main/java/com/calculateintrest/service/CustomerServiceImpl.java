package com.calculateintrest.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.calculateintrest.bo.CustomerBo;
import com.calculateintrest.dao.CustomerDao;
import com.calculateintrest.dto.CustomerDto;

@Service("customerservice")

public class CustomerServiceImpl {
@Autowired
@Qualifier("customeroradao")	
private CustomerDao dao;

CustomerBo bo=new CustomerBo();

public String calculateIntrest(CustomerDto d) throws Exception
{
	
	
	float intrestAmount=(d.getCprinamnt()*d.getCtime()*d.getCrate())/100.0f;
	bo.setCno(d.getCno());
	bo.setCname(d.getCname());
	bo.setCadd(d.getCadd());
	bo.setCprincipalamnt(d.getCprinamnt());
	bo.setCintrestamnt(intrestAmount);
	int count=dao.insert(bo);
	if(count==0)
		return "Record insertion failed for: cname::"+d.getCname()+" cadd::"+d.getCadd()+" cprincipalAmount"+d.getCprinamnt()+" IntrestAmount is:::"+intrestAmount;
	else
		return "Record inserted succesfully for: cname::"+d.getCname()+" cadd::"+d.getCadd()+" cprincipalAmount"+d.getCprinamnt()+" IntrestAmount is:::"+intrestAmount;

}

}
