package com.nt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustomerBo;
@Repository
public class CustomerdetailsImpl3 implements ICustomerdetails {
private static final String cust_query="select cno,cname,cadd,cbillamnt from customer where cno=?";
private static String cust_loc="select cno,cname,cadd,cbillamnt from customer where cadd in(?,?)";
private static final String Customer_lnamnt="select cno,cname,cadd,cbillamnt from customer where cbillamnt>?";

@Autowired
	JdbcTemplate jt;
	
	@Override
	public CustomerBo getdetailsbycno(int cno) {
		// TODO Auto-generated method stub
		return jt.queryForObject(cust_query, (rs,indx)->{
			System.out.println("Using lamda expression");
			CustomerBo bo=new CustomerBo();
			bo.setCno(rs.getInt(1));
			bo.setCname(rs.getString(2));
			bo.setCadd(rs.getString(3));
			bo.setCbillamnt(rs.getInt(4));
			return bo;
		}
				
				
				
				
				
				,cno);
		
		
	}

	@Override
	public List<CustomerBo> getdetailsbyloc(String loc1, String loc2) {
	
		return jt.query(cust_loc,rs->{
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
		},loc1,loc2);
		
	}

	@Override
	public List<CustomerBo> getdetailsbybillamnt(int billamnt) {
		List<CustomerBo> lstbo=new ArrayList<CustomerBo>();
		jt.query(Customer_lnamnt,rs->{
			System.out.println("CustomerdetailsImpl3.getdetailsbybillamnt()");
			CustomerBo bo=new CustomerBo();
			bo.setCno(rs.getInt(1));
			bo.setCname(rs.getString(2));
			bo.setCadd(rs.getString(3));
			bo.setCbillamnt(rs.getInt(4));
			lstbo.add(bo);
		}, billamnt);
		
		
		return lstbo;
	}

}
