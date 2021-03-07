package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;


@Repository("empdao")
public class EmpDaoImpl implements IEmpDao {

private final static String emp_qry="SELECT ENO,ENAME,EADD,ESAL FROM EMPLOYEE"; 	
	@Autowired
	JdbcTemplate jt;
	
	
	@Override
	public List<EmployeeBo> getEmpDetails() {
		// TODO Auto-generated method stub
		
		List<EmployeeBo> empdaolist=new ArrayList();
		empdaolist=jt.query(emp_qry, new ResultSetExtractor<List<EmployeeBo>>() {

			@Override
			public List<EmployeeBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
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
			
			
			
		}	
				);
		
		return empdaolist;
	}

}
