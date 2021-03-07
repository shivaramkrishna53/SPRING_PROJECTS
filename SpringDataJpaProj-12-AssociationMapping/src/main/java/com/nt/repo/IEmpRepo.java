package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Employee123;

public interface IEmpRepo extends JpaRepository<Employee123, Integer> {

}
