package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.Employees;

public interface EmployeeRepo extends CrudRepository<Employees, Integer> {

}
