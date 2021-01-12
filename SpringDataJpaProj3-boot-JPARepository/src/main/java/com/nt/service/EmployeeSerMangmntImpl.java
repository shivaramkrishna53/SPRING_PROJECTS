package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.BeanSupplierContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.nt.dto.employeedto;
import com.nt.entity.employee;
import com.nt.repo.IEmployeeRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
@Service("empser")
public class EmployeeSerMangmntImpl implements IEmployeeSerMangmnt {

	
	@Autowired
	IEmployeeRepo emprepo;
	@Override
	@Transactional
	public employeedto getEmployeeByid(int id) {
		employeedto dto=new employeedto();
		employee entity=emprepo.getOne(id);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	@Override
	public List<employeedto> fetchEmployeesExampleData(employeedto dto, String property, boolean asc) {
		// TODO Auto-generated method stub
		//convert dto to entity
		List<employeedto> lstdto = new ArrayList();
		
		employee entity=new employee();
		BeanUtils.copyProperties(dto,entity);
		Example<employee> ex=Example.of(entity);		
		List<employee> lstentites= emprepo.findAll(ex,asc?Sort.by(Direction.ASC,property):Sort.by(Direction.DESC,property));
		lstentites.forEach(en->{
			employeedto d=new employeedto();
			BeanUtils.copyProperties(en,d);
			lstdto.add(d);
		});
		return lstdto;
	}
	@Override
	public void deleteinbulk(List<employeedto> lstdto) {
		// TODO Auto-generated method stub
		List<employee> lstentities=new ArrayList<employee>();
		lstdto.forEach(dto->{
			employee e=new employee();
			BeanUtils.copyProperties(dto,e);
			lstentities.add(e);
		});
		emprepo.deleteInBatch(lstentities);
		
	}
	

}
