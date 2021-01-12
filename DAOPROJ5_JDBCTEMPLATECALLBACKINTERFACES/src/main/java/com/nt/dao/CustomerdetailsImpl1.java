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
public class CustomerdetailsImpl1 implements ICustomerdetails {
private static final String Customer_Query="select cno,cname,cadd,cbillamnt from customer where cno=?";
private static final String Customer_loc="select cno,cname,cadd,cbillamnt from customer where cadd in (?,?)";
private static final String Customer_lnamnt="select cno,cname,cadd,cbillamnt from customer where cbillamnt>?";

@Autowired
	private JdbcTemplate jt;
	
	@Override
	public CustomerBo getdetailsbycno(int cno) {
		CustomerBo bo=jt.queryForObject(Customer_Query, new CustMapper(),cno);
		return bo;
	}
	
	private static class CustMapper implements RowMapper<CustomerBo>
	{
		@Override
		public CustomerBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			CustomerBo bo=new CustomerBo();
			bo.setCno(rs.getInt(1));
			bo.setCname(rs.getString(2));
			bo.setCadd(rs.getString(3));
			bo.setCbillamnt(rs.getInt(4));
			return bo;
		}
	}
	
	
	@Override
		public List<CustomerBo> getdetailsbyloc(String loc1, String loc2) {
		
		return jt.query(Customer_loc,new custloc(),loc1,loc2);
		}
	public class custloc implements ResultSetExtractor<List<CustomerBo>>
	{
		@Override
		public List<CustomerBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			List<CustomerBo> lstBo=new ArrayList<CustomerBo>();
			{
				while(rs.next())
				{
				CustomerBo bo=new CustomerBo();
				bo.setCno(rs.getInt(1));
				bo.setCname(rs.getString(2));
				bo.setCadd(rs.getString(3));
				bo.setCbillamnt(rs.getInt(4));
				
				lstBo.add(bo);
				}
			}
					
			return lstBo;
		}
	}


	@Override
	public List<CustomerBo> getdetailsbybillamnt(int billamnt) {
		List<CustomerBo>lstbo=new ArrayList<CustomerBo>();
		 jt.query(Customer_lnamnt, new custbillamnt(lstbo), billamnt);
		 return lstbo;
	}
	class custbillamnt implements RowCallbackHandler
	{
		List<CustomerBo> lstbo;
		public custbillamnt(List<CustomerBo> lstbo)
		{
		this.lstbo=lstbo;
		System.out.println("CustomerdetailsImpl1.custbillamnt.custbillamnt(constructor)");
		}

		@Override
		public void processRow(ResultSet rs) throws SQLException {
			// TODO Auto-generated method stub
			System.out.println("CustomerdetailsImpl1.getdetailsbybillamnt(...).custbillamnt.processRow(method)");
			CustomerBo bo=new CustomerBo();
			bo.setCno(rs.getInt(1));
			bo.setCname(rs.getString(2));
			bo.setCadd(rs.getString(3));
			bo.setCbillamnt(rs.getInt(4));
			lstbo.add(bo);
			
		}
		
	}


	
		
		
	}


