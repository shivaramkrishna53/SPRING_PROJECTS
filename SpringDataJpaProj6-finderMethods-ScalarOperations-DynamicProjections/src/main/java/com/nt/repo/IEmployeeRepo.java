package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.employee;
import com.nt.view.View;

public interface IEmployeeRepo extends JpaRepository<employee,Integer> {
	public <T extends View> List<T> findByEadd(String addrs,Class<T> clazz);

}
