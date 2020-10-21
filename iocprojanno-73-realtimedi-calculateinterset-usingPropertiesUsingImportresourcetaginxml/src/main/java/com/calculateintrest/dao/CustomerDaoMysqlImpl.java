package com.calculateintrest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.calculateintrest.bo.CustomerBo;

import jdk.jfr.Registered;
@Repository("customermysqldao")
public class CustomerDaoMysqlImpl implements CustomerDao
{
	@Autowired
	
	private DataSource dmds;
	public String query="insert into customerloan values(?,?,?,?,?)";

	
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