package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration("config")
@ComponentScan("com.nt")
@PropertySource("com/nt/commons/jdbc.properties")
public class Config {
	@Autowired
	Environment en;
	
	HikariDataSource hkds=new HikariDataSource();
	@Bean("hk")
	public DataSource getDatasource()
	{
		
		hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		hkds.setUsername("c##shiva1234");
		hkds.setPassword("shiva1234");
		return hkds;
	}
	@Bean("jdtemp")
	public JdbcTemplate getjdt()
	{
		JdbcTemplate jdt=new JdbcTemplate();
		jdt.setDataSource(hkds);
		return jdt;
	}

}
