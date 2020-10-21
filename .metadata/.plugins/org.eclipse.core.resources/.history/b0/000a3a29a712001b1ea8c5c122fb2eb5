package com.nt.service;

import com.nt.dao.CustomerDaoImpl;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDaoImpl dao=null;
	public CustomerServiceImpl(CustomerDaoImpl dao)
	{
		this.dao=dao;
	}

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
