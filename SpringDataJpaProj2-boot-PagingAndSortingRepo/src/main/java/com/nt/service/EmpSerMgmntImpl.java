package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import 	org.springframework.data.domain.Pageable;

import com.nt.dto.EmployeeDto;

import com.nt.entity.Employee;

import com.nt.repo.IEmployeeRepo;
@Service("empser")
public class EmpSerMgmntImpl implements IEmpSerMgmnt {

	@Autowired
	private IEmployeeRepo emprepo;
	@Override
	public List<EmployeeDto> getEmployeeDetailsByGivenProperty(String property, boolean asc) {
		List<EmployeeDto> lstdtos=new ArrayList();

		List<Employee> lstenties=(List<Employee>) emprepo.findAll(asc? Sort.by(Sort.Direction.ASC,property) : Sort.by(Sort.Direction.DESC,property));
		
		lstenties.forEach(en->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(en, dto);
			lstdtos.add(dto);
			
		});
		return lstdtos;
	}
	@Override
	public List<EmployeeDto> DisplayEmployeeDetailsByPages(int pageno, int pagesizes) {
	
		Pageable pageable=PageRequest.of(pageno, pagesizes,Direction.ASC,"eno");
		//get Page<T> object 
		Page<Employee> page=emprepo.findAll(pageable);
		System.out.println(page.getNumber()+"  "+page.getNumberOfElements()+" "+page.getTotalPages());
		System.out.println(page.isFirst()+"   "+page.isLast()+"  "+page.isEmpty());
		
		List<Employee>lstentities=page.getContent();
		List<EmployeeDto> lstdtos=new ArrayList();
		lstentities.forEach(en->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(en, dto);
			lstdtos.add(dto);
			
		});
		return lstdtos;
	
	}
	@Override
	public void getRecordsbyPagenation(int pagesize) {

	int totalrecords=(int) emprepo.count();
	int noofpages=totalrecords/pagesize;
	
	if((totalrecords%pagesize)!=0)
       noofpages++;
       
       for(int i=0;i<noofpages;i++)
       {
    	   Pageable pageable=PageRequest.of(i,pagesize,Sort.Direction.ASC,"eno");
    	  Page<Employee>page=emprepo.findAll(pageable);
    	  System.out.println("Displaying Page::"+(i+1)+" of"+noofpages);
    	  System.out.println("Total no of records in this page"+page.getNumberOfElements());
    	  List<Employee> lstemp=page.getContent();
    	  lstemp.forEach(System.out::println);
    	  System.out.println("----------------------------------------------------------------");
    	  
    	   
       }
		
	}
	

}
