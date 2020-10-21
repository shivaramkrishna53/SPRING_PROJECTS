package com.calculateintrest.service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.calculateintrest.bo.CustomerBo;
import com.calculateintrest.dao.CustomerDao;
import com.calculateintrest.dto.CustomerDto;

@Service("customerservice")

public class CustomerServiceImpl {
@Autowired
@Qualifier("customermysqldao")	
private CustomerDao dao;

@Value("${ser.age}")
int age;



CustomerBo bo=new CustomerBo();


@PostConstruct
public void myinit()
{
if(dao==null)
	throw new IllegalArgumentException("Dao is not injected");
}
@PreDestroy
public void mydestroy()
{
	dao=null;
}

public String calculateIntrest(CustomerDto d) throws Exception
{
	
	System.out.println("Age::"+age);
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
