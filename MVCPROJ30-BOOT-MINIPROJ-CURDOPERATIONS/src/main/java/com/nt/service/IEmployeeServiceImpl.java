package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.Employees;
import com.nt.repo.EmployeeRepo;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepo repo;
	
	@Override
	public String registerEmployee(Employees e) {
		
		Employees et=repo.save(e);
		if(et!=null)
			return et.getEno()+"  got registered successfully";
		else
			return et.getEno()+" failed to register";
		
	}

	@Override
	public Iterable<Employees> getAllEmployeedetails() {
		// TODO Auto-generated method stub
		Iterable<Employees> it=repo.findAll();
		return it;
	}

	@Override
	public Employees updateEmployee(int no) {
         Optional<Employees> em=repo.findById(no);	
		return em.get();
	}

	@Override
	public String updateEmployeeDetails(Employees e) {
		// TODO Auto-generated method stub
		Employees emp=repo.save(e);
		if(emp!=null)
		return emp.getEno()+"Employee Successfully updated";
		else
		return emp.getEno()+"Employee Failed to updated";
	}

	@Override
	public String deleteEmployee(int eno) {
		// TODO Auto-generated method stub
		repo.deleteById(eno);
		return eno+"got successfully deleted";
	}

	


}
