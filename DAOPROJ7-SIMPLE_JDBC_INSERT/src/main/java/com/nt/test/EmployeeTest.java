package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.cfgs.ApplicationConfig;
import com.nt.dto.EmployeeDto;
import com.nt.service.IEmployeeService;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		IEmployeeService ser=ctx.getBean("empser", IEmployeeService.class);
		EmployeeDto dto=new EmployeeDto();
		dto.setEno(123);
		dto.setEname("harry");
		dto.setEadd("usa");
		dto.setEsal((float) 55.2);
		int result=ser.recordinsert(dto);
		if(result==1)
			System.out.println("record inserted successfully");
		else
			if(result==0)
				System.out.println("Failed to insert the given record");

	}

}
