package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repo.IEmployeeRepo;

@SpringBootApplication
public class SpringDataJpaProj7QureryMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj7QureryMethodsApplication.class, args);
	    IEmployeeRepo repo=ctx.getBean(IEmployeeRepo.class);
		
		/*
		 * System.out.println(repo.getClass().getName());
		 * repo.fetchAllEmployess().forEach(System.out::println);
		 */
	   // repo.fetchAllEmpByEadd("begumpet").forEach(System.out::println);
	   // repo.fetchAllBetweenSal(200.0f,500.0f).forEach(System.out::println);
		/*
		 * List<Object[]>
		 * results=repo.fetchEmpDetailsByCities("begumpet","hyd","banglore");
		 * results.forEach(op->System.out.println(op[0]+"  "+op[1]+" "+op[2]));
		 */
	    
		/*
		 * List<Object[]> res=repo.fetchByInitialCharacters("s");
		 * res.forEach(r->System.out.println(r[0]+"  "+r[1]));
		 */
	    
	   // repo.findEmpNamesInEmpNosRange(100, 104).forEach(System.out::println);
	    
	   // repo.findEmpSalariesByEmpName("sai","varu","ropesh").forEach(System.out::println);
	    //System.out.println(repo.findEmpAllDetailsByEno(102));
	    
	   // System.out.println(repo.findSalByEname("varu"));
	    
	    //System.out.println(repo.getEmpCount());
		/*
		 * Object res[]=(Object[]) repo.getEmpAggregateData();
		 * System.out.println("Employee Aggregate functions results are::"+res[0]+" "
		 * +res[1]+" "+res[2]+" "+res[3]);
		 */
	    
	  // System.out.println("No. of records updated are::"+ repo.updateEmpByEsal(200, 100));
	   
	  // System.out.println("no of employees got deleted with null address are::"+repo.deleteEmpWithNullAddrs());
	   //System.out.println("current date is::"+repo.getSysDate());
	    System.out.println(repo.insertIntoEmployeeDetails(108,"begumpet","shiva",700000.0f));
	}

}
