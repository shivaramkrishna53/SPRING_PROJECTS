package com.nt.config;

import java.beans.PropertyVetoException;
import java.sql.JDBCType;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration("persistanceconfig")
@ComponentScan("com.nt.dao")
public class PersistanceConfig {
	
	@Bean
	@Profile("dev")
	public DataSource createc3po() throws Exception
	{
		ComboPooledDataSource cpds=new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.cj.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql:///springdb");
		cpds.setUser("root");
		cpds.setPassword("shiva1234");
		return cpds;
	}
	
	
	@Bean
	@Profile("test")
	public DataSource createapachedbcpmysql() throws Exception
	{
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql:///springdb");
		bds.setUsername("root");
		bds.setPassword("shiva1234");
		return bds;
	}
	

	@Bean
	@Profile("uat")
	public DataSource createapachedbcporacle() throws Exception
	{
		BasicDataSource bds=new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		bds.setUsername("c##shiva1234");
		bds.setPassword("shiva1234");
		return bds;
	}
	
	
	
	@Bean
	@Profile("prod")
	public DataSource createhikaridpcp() throws Exception
	{
		HikariDataSource hkds=new HikariDataSource();
		hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		hkds.setUsername("c##shiva1234");
		hkds.setPassword("shiva1234");
		return hkds;
	}
	
	
	@Bean
	@Profile("dev")
	public JdbcTemplate createjtusingc3po() throws Exception
	{
		JdbcTemplate jt=new JdbcTemplate(createc3po());
		return jt;
	}
	
	@Bean
	@Profile("test")
	public JdbcTemplate createjtusingapachedbcpmysql() throws Exception
	{
		JdbcTemplate jt=new JdbcTemplate(createapachedbcpmysql());
		return jt;
	}
	
	
	@Bean
	@Profile("uat")
	public JdbcTemplate createjtusingapachedbcporacle() throws Exception
	{
		JdbcTemplate jt=new JdbcTemplate(createapachedbcporacle());
		return jt;
	}
	
	@Bean
	@Profile("prod")
	public JdbcTemplate createjtusinghikaridbcp() throws Exception
	{
		JdbcTemplate jt=new JdbcTemplate(createhikaridpcp());
		return jt;
	}
	

}
