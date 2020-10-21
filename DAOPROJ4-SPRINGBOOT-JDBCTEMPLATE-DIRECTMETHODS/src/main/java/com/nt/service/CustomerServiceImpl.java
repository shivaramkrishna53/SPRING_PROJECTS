package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.CustomerDaoImpl;
@Service("ser")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDaoImpl dao;


	public void getEmpcount(int deptid) {
		System.out.println("The total number of deptid employess are::"+dao.getEmpcount(deptid));

	}
	public void getEmpdetails(int empno)
	{
		System.out.println(dao.getEmpDetails(empno));
	}
	public void getEmpofJob(String job1,String job2)
	{
		System.out.println(dao.getEmpofJob(job1, job2));
	}

}
