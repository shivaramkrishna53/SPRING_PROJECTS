package com.nt.config;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig constructor");
	}
	@Bean("dt")
	public LocalTime generatedateobj()
	{
		return LocalTime.now();
	}
	

}