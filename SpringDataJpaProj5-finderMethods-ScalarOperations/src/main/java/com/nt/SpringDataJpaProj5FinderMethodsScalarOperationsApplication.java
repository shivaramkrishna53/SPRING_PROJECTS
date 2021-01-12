package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.repository.IEmployeeRepo;

@SpringBootApplication
public class SpringDataJpaProj5FinderMethodsScalarOperationsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj5FinderMethodsScalarOperationsApplication.class, args);
	IEmployeeRepo repo=ctx.getBean(IEmployeeRepo.class);
	repo.findByEaddIn(List.of("delhi","banglore")).forEach(rv->System.out.println(rv.getEno()+" "+rv.getEname()+" "+rv.getEsal()));
	System.out.println("-------------------");
	repo.findByEnameStartingWith("s").forEach(rs->System.out.println(rs.getEno()+"  "+rs.getEname()));
	
	}

}
