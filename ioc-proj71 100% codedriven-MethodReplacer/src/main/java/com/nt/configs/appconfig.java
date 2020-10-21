package com.nt.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.nt")
@ImportResource("com/nt/cfgs/ApplicationContext.xml")
public class appconfig {

}
