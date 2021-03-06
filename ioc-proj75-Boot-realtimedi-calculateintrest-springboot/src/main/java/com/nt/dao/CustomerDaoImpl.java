package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
@Repository("custdao")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	DataSource ds;
	public String query="insert into customerloan(cno,cintrestamount,cname,cadd,cprincipalamnt) values(?,?,?,?,?)";
	
	@Override
	public int insertloandetails(CustomerBo bo) throws Exception {
		// TODO Auto-generated method stub
		Connection con=ds.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1,bo.getCno());
		ps.setFloat(2,bo.getCtotalinterest());
		ps.setString(3,bo.getCname());
		ps.setString(4,bo.getCadd());
		ps.setFloat(5,bo.getCprinamnt());
		int result=ps.executeUpdate();
		
		
		
		return result;
	}

}
