package com.nt;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.dto.CustDto;
import com.nt.repo.ICustRepo;
import com.nt.service.CustBillImp;
import com.nt.service.ICustBill;

@SpringBootApplication
public class SpringDataJpaProj10WorkingWithDatevaluesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProj10WorkingWithDatevaluesApplication.class, args);
	   ICustBill cust=ctx.getBean("custser",CustBillImp.class);
		
		  CustDto dto=new CustDto();
		  
		  dto.setCustname("varu"); dto.setCustbillamnt(2000.0f);
		  dto.setCustdob(LocalDate.of(2020,5,20)); dto.setCusttob(LocalTime.of(8,15));
		  dto.setCustbilldate(LocalDateTime.of(2021,1,8,10,10));
		  System.out.println(cust.registerCustomer(dto));
		 
	   CustDto dto1=cust.getCustByid(1);
	   if(dto1==null)
		   System.out.println("Employee not found with the given id");
	   else
		   System.out.println(dto1);
	   
	   
	}

}
