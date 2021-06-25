package com.nt.cfgs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.zaxxer.hikari.HikariDataSource;

@Configuration("perconfig")
@ComponentScan("com.nt")
public class PersistanceConfig {

	@Bean("hkds")
	public DataSource getDataSource()
	{
		HikariDataSource hk=new HikariDataSource();
		hk.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hk.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		hk.setUsername("c##shiva1234");
		hk.setPassword("Shiva@2003");
		return hk;
	}
	
	@Bean("sji")
	public SimpleJdbcInsert getsimplejdbcinsert()
	{
		SimpleJdbcInsert sim=new SimpleJdbcInsert(getDataSource());
		return sim;
	}
}
