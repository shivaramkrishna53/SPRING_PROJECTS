package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Student;

@Repository("studdao")
public class StudentDaoImpl implements IStudentDao {

	private static final String query="insert into student_details(sno,sname,sadd,savg) values(?,?,?,?)";
	@Autowired
	JdbcTemplate jt;
	
	@Override
	public int registerstudentindb(Student s) {
		// TODO Auto-generated method stub
		int result=jt.update(query,s.getSno(),s.getSname(),s.getSadd(),s.getSavg());
		return result;
	}

}
