package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;

//@Repository("custdao")
public class CustomerdetailsImpl2 implements ICustomerdetails {
private static String cust_query="select cno,cname,cadd,cbillamnt from customer where cno=?";
private static String cust_loc="select cno,cname,cadd,cbillamnt from customer where cadd in(?,?)";
private static final String Customer_lnamnt="select cno,cname,cadd,cbillamnt from customer where cbillamnt>?";

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public CustomerBo getdetailsbycno(int cno) {
		// TODO Auto-generated method stub
		
		return jt.queryForObject(cust_query, new RowMapper<CustomerBo>() {

			@Override
			public CustomerBo mapRow(ResultSet rs, int rowNum) throws SQLException {
				CustomerBo bo=new CustomerBo();
				System.out.println("by using the anonmoys inner class");
				bo.setCno(rs.getInt(1));
				bo.setCname(rs.getString(2));
				bo.setCadd(rs.getString(3));
				bo.setCbillamnt(rs.getInt(4));
				return bo;
				
			}
			
		}
				
				
				
				
				
				, cno);
}

	@Override
	public List<CustomerBo> getdetailsbyloc(String loc1, String loc2) {
		return jt.query(cust_loc, new ResultSetExtractor<List<CustomerBo>>() {

			@Override
			public List<CustomerBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				List<CustomerBo> lstbo=new ArrayList<CustomerBo>();
				while(rs.next())
				{
					CustomerBo bo=new CustomerBo();
					bo.setCno(rs.getInt(1));
					bo.setCname(rs.getString(2));
					bo.setCadd(rs.getString(3));
					bo.setCbillamnt(rs.getInt(4));
					lstbo.add(bo);
				}
				return lstbo;
			}
		
		}
		
		
		
		
		, loc1,loc2);
		
	}

	@Override
	public List<CustomerBo> getdetailsbybillamnt(int billamnt) {
		// TODO Auto-generated method stub
		List<CustomerBo> lstbo=new ArrayList<CustomerBo>();
		 jt.query(Customer_lnamnt,new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println("CustomerdetailsImpl2.getdetailsbybillamnt(...).new RowCallbackHandler() {...}.processRow()");
				CustomerBo bo=new CustomerBo();
				bo.setCno(rs.getInt(1));
				bo.setCname(rs.getString(2));
				bo.setCadd(rs.getString(3));
				bo.setCbillamnt(rs.getInt(4));
				lstbo.add(bo);
				
				
			}
		}, 
				
				billamnt);
	
		 return lstbo;
	}
}
