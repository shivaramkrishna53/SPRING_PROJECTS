package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.PersonalDetails;

@SpringBootApplication
public class Daoproj11SpringbootymlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(Daoproj11SpringbootymlApplication.class, args);
		PersonalDetails pd=ctx.getBean("per",PersonalDetails.class);
		System.out.println(pd);
		
	}

}
