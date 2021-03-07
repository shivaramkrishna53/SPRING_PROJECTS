package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.service.CompanyMangamentServiceImpl;
import com.nt.service.ICompanyMangmntService;

@SpringBootApplication
public class SpringDataJpaProj12AssociationMappingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj12AssociationMappingApplication.class, args);
	    ICompanyMangmntService ser=ctx.getBean("companyser",CompanyMangamentServiceImpl.class);
	    try {
	    ser.saveDataUsingParent();
	   // ser.saveDataUsingChild();
	    }
	    catch (Exception e) {
			e.printStackTrace();
		}
	}

}
