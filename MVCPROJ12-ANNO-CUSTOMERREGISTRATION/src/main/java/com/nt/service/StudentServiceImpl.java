package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IStudentDao;
import com.nt.model.Student;

@Service("studser")
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentDao dao;
	@Override
	public String registerStudent(Student s) {
		// TODO Auto-generated method stub
		int result=dao.registerstudentindb(s);
		String x=(result==1)? "Registration successfull":"Registration failed";
		return x;
	}

	
	

}
