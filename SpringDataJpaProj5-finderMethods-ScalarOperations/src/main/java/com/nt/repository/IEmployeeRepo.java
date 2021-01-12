package com.nt.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.employee;
import com.nt.TypeView.*;
public interface IEmployeeRepo extends JpaRepository<employee, Integer> {
	
	//select eno,ename,esal from employee where eadd in('hyd','delhi','mumbai');
	public List<ResultView> findByEaddIn(Collection<String> cities);
	
	//select eno,ename from employee where ename like('s%');
	public List<ResultView2> findByEnameStartingWith(String inichars);
	
}
