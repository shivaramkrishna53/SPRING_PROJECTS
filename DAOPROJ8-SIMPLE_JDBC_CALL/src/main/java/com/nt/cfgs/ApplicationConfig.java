package com.nt.cfgs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.zaxxer.hikari.HikariDataSource;

@Configuration("appconfig")
@ComponentScan("com.nt")
public class ApplicationConfig {
	
	@Bean("hk")
	public DataSource getDataSource()
	{
		System.out.println("ApplicationConfig.getDataSource()");
		HikariDataSource hkds=new HikariDataSource();
		hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		hkds.setUsername("c##shiva1234");
		hkds.setPassword("Shiva@2003");
		return hkds;
	}
	
	@Bean("sjdbc")
	public SimpleJdbcCall getjdbc()
	{
		System.out.println("ApplicationConfig.getjdbc()");
		SimpleJdbcCall sj=new SimpleJdbcCall(getDataSource());
		return sj;
	}
	

}
