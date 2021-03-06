package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.EmpBo;

public class EmpDaoImp implements EmpDao {

	private static final String SELECT_EMP_QUERY="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?)"; 
	DataSource ds;
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	boolean flag=false;
	public EmpDaoImp(DataSource ds)
	{
		this.ds=ds;
	}
	@Override
	public List<EmpBo> getEmpDetails(String desg1, String desg2, String desg3) throws Exception {
		// TODO Auto-generated method stub
		List<EmpBo> lst=new ArrayList<EmpBo>();
		con=ds.getConnection();
		if(con!=null)
		{
		ps=con.prepareStatement(SELECT_EMP_QUERY);
		ps.setString(1,desg1);
		ps.setString(2,desg2);
		ps.setString(3,desg3);
		}
		if(ps!=null)
		rs=ps.executeQuery();
		if(rs!=null)
		{
			
			while(rs.next())
			{
				flag=true;
				EmpBo bo=new EmpBo();
				bo.setEno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getInt(4));
				bo.setDepno(rs.getInt(5));
				lst.add(bo);		
				
			}
		}
		if(flag==false)
			return null;
		else
		return lst;
	}

}
