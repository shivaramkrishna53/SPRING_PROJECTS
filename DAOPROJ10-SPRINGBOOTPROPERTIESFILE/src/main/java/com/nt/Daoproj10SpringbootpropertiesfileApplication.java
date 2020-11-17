package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.model.Person;

@SpringBootApplication
public class Daoproj10SpringbootpropertiesfileApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(Daoproj10SpringbootpropertiesfileApplication.class, args);
		Person p=ctx.getBean("per",Person.class);
		System.out.println(p);
		
	}

}
