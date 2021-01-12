package com.nt;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.dto.EmployeeDto;
import com.nt.service.EmployeeMangmntServiceImpl;
import com.nt.service.IEmployeeMangmntService;

@SpringBootApplication
public class SpringDataJpaProj1BootCurdRepoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj1BootCurdRepoApplication.class, args);
		EmployeeMangmntServiceImpl ser=ctx.getBean("empser",EmployeeMangmntServiceImpl.class);
		Integer id=ser.registerEmployee(new EmployeeDto(152,"sai","hyd",50000.0f));
		System.out.println(id+"got successfully registered");
		System.out.println("The employee no's that got registered are::"+ Arrays.toString(ser.registerMultipleEmployees(List.of(new EmployeeDto(138113, "khoil","jntu",5211.0f),new EmployeeDto(133743, "dhoni", "ocity",399903.0f)))));
		
		System.out.println("Total number of employees present are"+ser.getEmployeesCount());
		
		System.out.println(ser.removeEmployeeByid(101));
		
		
		EmployeeDto dto=ser.getEmployeeDetailsbyid(109);
		if(dto!=null)
			System.out.println("record found:::"+dto);
		else
			System.out.println("no record found");
		
		System.out.println(ser.removeEmployeeByid1(105));
		
		
		//ser.getAllEmployeeDetails().forEach(System.out::println);
	//(or)
		ser.getAllEmployeeDetails().forEach(x->System.out.println(x));
		
		try
		{
		System.out.println(ser.removeEmployeesGivenbyEntities(List.of(new EmployeeDto(152),new EmployeeDto(1333))));
		}
		catch(Exception e) {
			System.out.println("Couldn't delete the given records from the database");
			e.printStackTrace();
			
		}
	
		
		ser.getEmployeeByIds(List.of(133423,133743)).forEach(d->System.out.println(d));
		
	}

}
