package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Department;

public interface IDeptRepo extends JpaRepository<Department,Integer> {

}
