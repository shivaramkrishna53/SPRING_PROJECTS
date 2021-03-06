package com.nt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.service.CustomerServiceImpl;

@SpringBootApplication
public class Daoproj4SpringbootJdbctemplateDirectmethodsApplication {
	

	public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(Daoproj4SpringbootJdbctemplateDirectmethodsApplication.class, args);
		CustomerServiceImpl serv=ctx.getBean("ser",CustomerServiceImpl.class);
		try {
		serv.getEmpcount(30);
		}
		catch(DataAccessException dae)
		{
			dae.printStackTrace();
		}
		
	}

}
