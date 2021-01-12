package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.EmployeeDto;
import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;
@Service("empser")
public class EmployeeMangmntServiceImpl implements IEmployeeMangmntService {

	@Autowired //injects the iemployeerepo implementaiion class obj
	private IEmployeeRepo emprepo;
	
	
	@Override
	public Integer registerEmployee(EmployeeDto dto) {
		Employee entity=new Employee();
		Employee entity1=new Employee();
		BeanUtils.copyProperties(dto,entity);
		entity1=emprepo.save(entity);
		
		return entity1.getEno();
	}


	@Override
	public int[] registerMultipleEmployees(List<EmployeeDto> lstdto) {
		// TODO Auto-generated method stub
		List<Employee> lstentity=new ArrayList<Employee>();
		lstdto.forEach(dto->{
			
			Employee entity=new Employee();
			BeanUtils.copyProperties(dto,entity);
			lstentity.add(entity);
		});
		
				
		List<Employee> lstentity1=(List<Employee>) emprepo.saveAll(lstentity);
		int empnos[]= new int[lstentity1.size()];
	for(int i=0;i<lstentity1.size();++i)
	{
		empnos[i]=lstentity1.get(i).getEno();
	}
	return empnos;
		
	}


	@Override
	public int getEmployeesCount() {
		
		return (int) emprepo.count();
	}


	@Override
	public String removeEmployeeByid(int id) {
		if(emprepo.existsById(id))
		{
			emprepo.deleteById(id);
			return "Employee::"+id+" got deleted successfully";
		}
		else
			return "Employee::"+id+" not got deleted";
	}


	@Override
	public EmployeeDto getEmployeeDetailsbyid(int id) {
		
		EmployeeDto dto=new EmployeeDto();
		Optional<Employee> opnlenti=emprepo.findById(id);
		if(opnlenti.isPresent())
		{
			Employee entity=opnlenti.get();
			
			BeanUtils.copyProperties(entity, dto);
			return dto;
			
		}
		else
			return dto;
			
	}


	@Override
	public String removeEmployeeByid1(int id) {
		
		Optional<Employee>opnlenti= emprepo.findById(id);
		if(opnlenti.isPresent())
		{
			emprepo.deleteById(id);
			return "Employee with id:"+(opnlenti.get().getEno())+"got deleted";
		}
		else
			return "Employee with id:"+id+"not deleted";
	}


	@Override
	public Iterable<EmployeeDto> getAllEmployeeDetails() {
		Iterable<Employee> itrblentity=emprepo.findAll();
		Iterable<EmployeeDto> itrbldto=new ArrayList<EmployeeDto>();
		//converting the iterable of employeeentity to employeedto
		itrblentity.forEach(entity->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(entity, dto);
			((List<EmployeeDto>) itrbldto).add(dto);
		});
		
		return itrbldto;
	}


	@Override
	public String removeEmployeesGivenbyEntities(List<EmployeeDto> lstdto) {
		// TODO Auto-generated method stub
		List<Employee>lstentity=new ArrayList<Employee>();
		//convert the given lstdto to lst entities 
		lstdto.forEach(dto->{
			Employee entity=new Employee();
			BeanUtils.copyProperties(dto, entity);
			lstentity.add(entity);
		});
		emprepo.deleteAll(lstentity);
		return "All employees records given are deleted successfully";
	}


	@Override
	public List<EmployeeDto> getEmployeeByIds(List<Integer> ids) {
		List<Employee> lstentity=(List<Employee>) emprepo.findAllById(ids);
		List<EmployeeDto> lstdto=new ArrayList<EmployeeDto>();
		lstentity.forEach(en->{
			EmployeeDto dto=new EmployeeDto();
			BeanUtils.copyProperties(en,dto);
			lstdto.add(dto);
		});
		return lstdto;
		
	}

}
