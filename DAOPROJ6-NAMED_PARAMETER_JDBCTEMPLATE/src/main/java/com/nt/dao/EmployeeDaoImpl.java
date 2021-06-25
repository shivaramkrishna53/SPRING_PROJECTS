package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.EmployeeBo.EmployeeBo;

@Repository("empdao")
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	NamedParameterJdbcTemplate npjt;
	
	
private static final String EmpName_Query="select ename from employee where eno=:no";	
private static final String EmpDetailsByLoc_Query="select eno,ename,eadd,esal from employee where eadd in (:location1,:location2)";
	
	@Override
	public String getEmployeeNameById(int eid) {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap=new HashMap();
		paramMap.put("no",eid);
		String name=npjt.queryForObject(EmpName_Query, paramMap,String.class);
		return name;
	}

	@Override
	public List<EmployeeBo> getEmployeeDetailsByLocation(String loc1, String loc2) {
		// TODO Auto-generated method stub
		Map<String, Object> mp=new HashMap();
		mp.put("location1",loc1);
		mp.put("location2", loc2);
		List<EmployeeBo> lst=new ArrayList(); 
		lst=npjt.query(EmpDetailsByLoc_Query, mp, new ResultSetExtractor<List<EmployeeBo>>() {
			
			@Override
			public List<EmployeeBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<EmployeeBo> emplst=new ArrayList();
				while(rs.next())
				{
					EmployeeBo bo=new EmployeeBo();
					bo.setEno(rs.getInt(1));
					bo.setEname(rs.getString(2));
					bo.setEadd(rs.getString(3));
					bo.setEsal(rs.getFloat(4));
					emplst.add(bo);
				}
				return emplst;
			}
			
		});
		
		return lst;
	}

}
