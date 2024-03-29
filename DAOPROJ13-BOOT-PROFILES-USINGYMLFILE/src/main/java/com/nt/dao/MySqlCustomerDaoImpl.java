package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
@Repository("mysqlcustdao")
@Profile({"dev","test"})
public class MySqlCustomerDaoImpl implements CustomerDao {

	@Autowired
	JdbcTemplate jt;
	public String query="insert into customerloan(cno,cintrestamount,cname,cadd,cprincipalamnt) values(?,?,?,?,?)";
	
	@Override
	public int insertloandetails(CustomerBo bo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Datasource begin used is:::"+jt.getDataSource().getClass());
		System.out.println("Mysql DataBase is being used");
		int result=jt.update(query,bo.getCno(),bo.getCtotalinterest(),bo.getCname(),bo.getCadd(),bo.getCprinamnt());
		return result;
	}

}
