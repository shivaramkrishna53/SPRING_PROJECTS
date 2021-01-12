package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.dto.employeedto;
import com.nt.service.EmployeeSerMangmntImpl;

@SpringBootApplication
public class SpringDataJpaProj3BootJpaRepositoryApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj3BootJpaRepositoryApplication.class, args);
		EmployeeSerMangmntImpl ser=ctx.getBean("empser",EmployeeSerMangmntImpl.class);
		//System.out.println(ser.getEmployeeByid(101));
		ser.fetchEmployeesExampleData(new employeedto(null,null,null,70000.f),"eno",true).forEach(System.out::println);
		try {
	ser.deleteinbulk(List.of(new employeedto(100),new employeedto(105)));
	System.out.println("deleted successfully");
		}
		catch(Exception e)
		{
			System.out.println("Problem in deletion");
			e.printStackTrace();
			
		}
	
	}

}
