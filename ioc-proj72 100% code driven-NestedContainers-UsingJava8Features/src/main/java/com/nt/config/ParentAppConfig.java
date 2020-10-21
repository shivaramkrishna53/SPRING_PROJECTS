package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan({"com.nt.dao","com.nt.service"})
@PropertySource("com/nt/commons/jdbc.properties")
public class ParentAppConfig {
	@Autowired
	Environment env;
	@Bean("ds")
	public DataSource getdatasource()
	{
		
		HikariDataSource  hkDs=null;
		hkDs=new HikariDataSource();
		hkDs.setDriverClassName(env.getRequiredProperty("driverclassname"));
		hkDs.setJdbcUrl(env.getRequiredProperty("url"));
		hkDs.setUsername("c##shiva1234");
		hkDs.setPassword("shiva1234");
		hkDs.setMinimumIdle(10);
		hkDs.setMaximumPoolSize(100);
		return hkDs;
	}

}
