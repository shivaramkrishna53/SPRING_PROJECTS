package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Customer;

@Repository("custdao")
public class CustomerDaoImpl implements IcustomerDao {
private static final String qry="insert into customer_registration values(?,?,?)";
	@Autowired
	JdbcTemplate jt;
	
	@Override
	public int registerCustomerintoDb(Customer c) {
		// TODO Auto-generated method stub
		int w=jt.update(qry, c.getCname(),c.getCadd(),c.getBillamnt());
		
		return w;
	}

}
