package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
@Repository("oraclecustdao")
@Profile({"uat","prod"})
public class OracleCustomerDaoImpl implements CustomerDao {

	@Autowired
	JdbcTemplate jt;
	public String query="insert into customerloan(id,intrstamnt,name,address,principalamnt) values(CUSTOMER_ID.NEXTVAL,?,?,?,?)";
	
	@Override
	public int insertloandetails(CustomerBo bo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("The datasource being used is:::"+jt.getDataSource().getClass());
		System.out.println("Oracle DataBase is being used");
		int result=jt.update(query,bo.getCtotalinterest(),bo.getCname(),bo.getCadd(),bo.getCprinamnt());
		return result;
	}

}
