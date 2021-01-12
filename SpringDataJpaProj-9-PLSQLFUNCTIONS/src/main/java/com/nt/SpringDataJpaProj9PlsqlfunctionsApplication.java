package com.nt;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.AuthenticateEmpImpl;
import com.nt.service.IAuthenticateEmp;

@SpringBootApplication
public class SpringDataJpaProj9PlsqlfunctionsApplication {

	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj9PlsqlfunctionsApplication.class, args);
		IAuthenticateEmp ser=ctx.getBean("ser",AuthenticateEmpImpl.class);
		System.out.println(ser.Authenticate("shiva","shiva1234"));
		
	}

}
