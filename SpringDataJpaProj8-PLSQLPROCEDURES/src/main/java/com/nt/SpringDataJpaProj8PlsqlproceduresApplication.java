package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.EmpSerImpl;

@SpringBootApplication
public class SpringDataJpaProj8PlsqlproceduresApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj8PlsqlproceduresApplication.class, args);
	   EmpSerImpl ser= ctx.getBean("empser",EmpSerImpl.class);
		/*System.out.println("hello the o/p is:::");
		  ser.getEmpDetailsInEsalRange(1.0f,10000.0f).forEach(System.out::println);*/
		 ser.getEmpdetails_withcities("hyd","jaipur").forEach(obj->System.out.println(
		  obj[0]+" "+obj[1]+" "+obj[2]));
		 
	}
	
	

}
