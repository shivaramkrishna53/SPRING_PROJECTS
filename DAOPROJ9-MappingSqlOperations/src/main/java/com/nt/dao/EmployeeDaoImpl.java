package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;
import com.sun.jdi.Type;

@Repository("empdao")
public class EmployeeDaoImpl implements EmployeeDao {
private static final String Get_Emp_byId="select eno,ename,eadd,esal from employee where eno=?";
private static final String Increment_Emp_sal_inrange="update employee set esal=esal+2000 where esal<? and esal>?";


GetEmp e1;
SalaryIncrement si;

@Autowired
public EmployeeDaoImpl(DataSource ds) {
	// TODO Auto-generated constructor stub
	e1=new GetEmp(ds,Get_Emp_byId);
	si=new SalaryIncrement(ds, Increment_Emp_sal_inrange);
}
	
	@Override
	public EmployeeBo getempbyid(int eid) {
		// TODO Auto-generated method stub
		List<EmployeeBo> lst=e1.execute(eid);
		return lst.get(0);
	}
	
	private class GetEmp extends MappingSqlQuery<EmployeeBo>
	{
		 public GetEmp(DataSource ds,String query) {
			// TODO Auto-generated constructor stub
			 super(ds,query);
			 super.declareParameter(new SqlParameter(Types.NUMERIC));
			 super.compile();
			
		}

		@Override
		protected EmployeeBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			EmployeeBo bo=new EmployeeBo();
			bo.setEno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setEadd(rs.getString(3));
			bo.setEsal(rs.getFloat(4));
			return bo;
		}
		
	}

	@Override
	public float employeesalinrange(float inisal,float fisal) {
		// TODO Auto-generated method stub
		int count=si.update(inisal,fisal);
		return count;
	}
	
	
	private class SalaryIncrement extends SqlUpdate
	{
		public SalaryIncrement(DataSource ds,String query)
		{
			super(ds, query);
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.compile();
			
		}
	}

}
