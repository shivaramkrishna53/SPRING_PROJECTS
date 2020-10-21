package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDaoImpl implements CustomerDao {

	private JdbcTemplate jdt=null;
	
	public CustomerDaoImpl(JdbcTemplate jdt) {
		this.jdt = jdt;
	}

	public int getEmpcount(int deptid) {
		int count=jdt.queryForObject("select count(*) from emp where DEPTNO="+deptid,Integer.class);
		return count;
	}
	public Map<String,Object> getEmpDetails(int empno)
	{
		return jdt.queryForMap("select empno,ename,job,sal from emp where empno=?",empno);
	}
	public List<Map<String,Object>> getEmpofJob(String job1,String job2)
	{
		return jdt.queryForList("select empno,ename,job,sal from emp where job in(?,?) order by job",job1,job2);
	}

	
}
