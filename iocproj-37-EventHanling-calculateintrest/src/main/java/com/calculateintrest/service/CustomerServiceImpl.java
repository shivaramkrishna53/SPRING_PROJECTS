package com.calculateintrest.service;
import com.calculateintrest.bo.CustomerBo;
import com.calculateintrest.dao.CustomerDaoImpl;
import com.calculateintrest.dto.CustomerDto;
public class CustomerServiceImpl {
private CustomerDaoImpl dao=null;
private  String osName;
private String path;
CustomerBo bo=new CustomerBo();
public CustomerServiceImpl(CustomerDaoImpl dao) {
	
	this.dao = dao;
}
public void setOsName(String osName) {
	this.osName = osName;
}

public String calculateIntrest(CustomerDto d) throws Exception
{
	System.out.println("osName::"+osName);
	
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
