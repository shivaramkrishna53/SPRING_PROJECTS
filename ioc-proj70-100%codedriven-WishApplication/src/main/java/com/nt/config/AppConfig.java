package com.nt.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.nt")
public class AppConfig {
	static
	{
		System.out.println("AppConfig static block");
	}
	public AppConfig() {
		System.out.println("AppConfig constructor");
	}
	@Bean("dt")
	public LocalDateTime generatetime()
	{
		System.out.println("AppConfig.generatetime()");
		return LocalDateTime.now();
	}
	

}
