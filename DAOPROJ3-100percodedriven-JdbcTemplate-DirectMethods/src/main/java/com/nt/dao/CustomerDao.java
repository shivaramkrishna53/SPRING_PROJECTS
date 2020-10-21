package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface CustomerDao {
	
	public int getEmpcount(int deptid);
	public Map<String,Object> getEmpDetails(int empno);
	public List<Map<String,Object>> getEmpofJob(String job1,String job2);

}
