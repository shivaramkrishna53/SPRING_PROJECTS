package com.calculateintrest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.calculateintrest.bo.CustomerBo;

public class CustomerDaoImpl implements CustomerDao
{
	private DriverManagerDataSource dmds;
	public String query="insert into customerloan values(?,?,?,?,?)";

	public CustomerDaoImpl(DriverManagerDataSource dmds) {
		
		this.dmds = dmds;
	}
	public int insert(CustomerBo bo) throws Exception
	{
	Connection con=dmds.getConnection();
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1,bo.getCno());
	ps.setFloat(2,bo.getCintrestamnt());
	ps.setString(3,bo.getCname());
	ps.setString(4,bo.getCadd());
	ps.setFloat(5,bo.getCprincipalamnt());
	int count=ps.executeUpdate();
	ps.close();
	con.close();
	return count;
	
	}
	
}