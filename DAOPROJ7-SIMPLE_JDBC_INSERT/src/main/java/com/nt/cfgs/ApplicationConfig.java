package com.nt.cfgs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration("appconfig")
@ComponentScan(basePackages = {"com.nt"})
@Import({PersistanceConfig.class,ServiceConfig.class})
public class ApplicationConfig {

}
