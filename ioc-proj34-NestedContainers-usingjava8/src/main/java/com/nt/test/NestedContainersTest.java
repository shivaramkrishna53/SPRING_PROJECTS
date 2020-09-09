package com.nt.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.EmpController;
import com.nt.dto.EmpDto;

public class NestedContainersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String desg1=null,desg2=null,desg3=null;
		EmpController con;
		Scanner sc=null;
		
		List<EmpDto> Dtolst=new ArrayList<EmpDto>();
		ClassPathXmlApplicationContext parentctx= new ClassPathXmlApplicationContext("com/nt/cfgs/ParentApplicationContext.xml");
		ClassPathXmlApplicationContext childctx= new ClassPathXmlApplicationContext(new String[] {"com/nt/cfgs/ChildApplicationContext.xml"},parentctx);
		con=childctx.getBean("con",EmpController.class);
		sc=new Scanner(System.in);
		
		
		try
		{
			
			if(sc!=null)
			{
			System.out.println("Enter the first designation::");
			desg1=sc.next();
			System.out.println("Enter the second designation::");
			desg2=sc.next();
			System.out.println("Enter the third designation::");
			desg3=sc.next();
			}
			Dtolst=con.EmpdetailsController(desg1,desg2,desg3);
			if(Dtolst==null)
				System.out.println("No records Present with such desginations");
			else
			{
			for(int i=0;i<Dtolst.size();i++)
			{
				System.out.println("Details of::"+(i+1)+" Employee");
				
				System.out.println("Emp no:::"+Dtolst.get(i).getEno());
				System.out.println("Emp name:::"+Dtolst.get(i).getEname());
				System.out.println("Emp job:::"+Dtolst.get(i).getJob());
				System.out.println("Emp sal:::"+Dtolst.get(i).getSal());
				System.out.println("Emp deptno:::"+ Dtolst.get(i).getDepno());
				System.out.println("-------------------------------------------------");
				System.out.println("--------------------------------------------------");
			}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		


	}

}
