package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;

@Repository("empdao")
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	SimpleJdbcInsert simji;
	
	@Override
	public int recordinsert(EmployeeBo bo) {
		// TODO Auto-generated method stub
		
		simji.setTableName("employee");
		
		//way 1:
//		Map<String,Object> mp=new HashMap();
//		mp.put("eno", bo.getEno());
//		mp.put("ename",bo.getEname());
//		mp.put("eadd",bo.getEadd());
//		mp.put("esal", bo.getEsal());
//		
//		int rowseffected=simji.execute(mp);
		
		//way 2:
		BeanPropertySqlParameterSource bpsps=new BeanPropertySqlParameterSource(bo);
		int rowseffected=simji.execute(bpsps);
		return rowseffected;
	}

}
