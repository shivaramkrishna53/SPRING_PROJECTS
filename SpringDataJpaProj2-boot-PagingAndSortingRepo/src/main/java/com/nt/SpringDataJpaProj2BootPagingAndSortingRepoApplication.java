package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.EmpSerMgmntImpl;

@SpringBootApplication
public class SpringDataJpaProj2BootPagingAndSortingRepoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj2BootPagingAndSortingRepoApplication.class, args);
		EmpSerMgmntImpl ser=ctx.getBean("empser",EmpSerMgmntImpl.class);
		ser.getEmployeeDetailsByGivenProperty("eno",true).forEach(System.out::println);
		ser.DisplayEmployeeDetailsByPages(1,3).forEach(System.out::println);
		ser.getRecordsbyPagenation(2);
	}

}
