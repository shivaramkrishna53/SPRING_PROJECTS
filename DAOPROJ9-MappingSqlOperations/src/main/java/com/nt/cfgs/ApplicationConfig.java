package com.nt.cfgs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.nt")
@Import({ServiceConfig.class,PersistanceConfig.class})
public class ApplicationConfig {

}
