package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDto;
import com.nt.entity.Employee;

@Service("empser")
public class EmpSerImpl implements IEmpSer {

	@Autowired
	private EntityManager em;
	@Override
	public List<EmployeeDto> getEmpDetailsInEsalRange(float inisal, float fisal) {
		// TODO Auto-generated method stub
	 StoredProcedureQuery procedure=em.createStoredProcedureQuery("P_GET_EMPS_BYSALRANGE",Employee.class);
	 // register the params
	 procedure.registerStoredProcedureParameter(1,Float.class,ParameterMode.IN);
	 procedure.registerStoredProcedureParameter(2,Float.class,ParameterMode.IN);
	 procedure.registerStoredProcedureParameter(3,Employee.class,ParameterMode.REF_CURSOR);
	 // set the params
	 procedure.setParameter(1,inisal);
	 procedure.setParameter(2,fisal);
	 List<Employee> lstentities=procedure.getResultList();
	 List<EmployeeDto> lstdto=new ArrayList<EmployeeDto>();
	 lstentities.forEach(en->{
		 EmployeeDto dto= new EmployeeDto();
		 BeanUtils.copyProperties(en,dto);
		 lstdto.add(dto);
	 });
	 
		
		return lstdto;
	}
	@Override
	public List<Object[]> getEmpdetails_withcities(String city1, String city2) {
		StoredProcedureQuery procedure=em.createStoredProcedureQuery("P_GETEMPDETAILS_BYCITIES");
	    //register params
		procedure.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
		procedure.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
//-->not required for mysql //procedure.registerStoredProcedureParameter(3,Object[].class,ParameterMode.REF_CURSOR);
		//set params
		procedure.setParameter(1,city1);
		procedure.setParameter(2,city2);
		List<Object[]> lstresults=procedure.getResultList();
		
		return lstresults;
	}

}
