package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
//@Repository("custdao")
public class CustomerdetailsImpl4 implements ICustomerdetails {
	private static final String cust_query="select cno,cname,cadd,cbillamnt from customer where cno=?";
	private static String cust_loc="select cno,cname,cadd,cbillamnt from customer where cadd in(?,?)";

	@Autowired
	JdbcTemplate jt;
	@Override
	public CustomerBo getdetailsbycno(int cno) {
		System.out.println("using beanpropertyrowmapper");
		return jt.queryForObject(cust_query,new BeanPropertyRowMapper<CustomerBo>(CustomerBo.class), cno);
		
	}
	@Override
	public List<CustomerBo> getdetailsbyloc(String loc1, String loc2) {
		BeanPropertyRowMapper<CustomerBo> bprm=new BeanPropertyRowMapper<CustomerBo>(CustomerBo.class);
		
		return jt.query(cust_loc, new RowMapperResultSetExtractor<CustomerBo>(bprm), loc1,loc2);
		
	}
	@Override
	public List<CustomerBo> getdetailsbybillamnt(int billamnt) {
		// TODO Auto-generated method stub
		return null;
	}

}
