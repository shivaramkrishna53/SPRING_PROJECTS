package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.employee;

public interface IEmployeeRepo extends JpaRepository<employee,Integer> {
	

}
