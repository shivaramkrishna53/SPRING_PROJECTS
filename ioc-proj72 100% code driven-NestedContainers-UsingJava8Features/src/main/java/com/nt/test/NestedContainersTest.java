package com.nt.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.ChildAppConfig;
import com.nt.config.ParentAppConfig;
import com.nt.controller.EmpController;
import com.nt.vo.EmpVo;

public class NestedContainersTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String desg1=null,desg2=null,desg3=null;
		AnnotationConfigApplicationContext parentctx,childctx;
		EmpController con;
		Scanner sc=null;
		
		List<EmpVo> Volist=new ArrayList<EmpVo>();
		
		parentctx=new AnnotationConfigApplicationContext(ParentAppConfig.class);
		childctx=new AnnotationConfigApplicationContext(ChildAppConfig.class);
		childctx.setParent(parentctx);
		con=childctx.getBean("controller",EmpController.class);
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
			Volist=con.EmpdetailsController(desg1,desg2,desg3);
			if(Volist==null)
				System.out.println("No records Present with such desginations");
			else
			{
			Volist.forEach(vo->{ 

				System.out.println();
				System.out.println("Emp no:::"+vo.getEno());
				System.out.println("Emp name:::"+vo.getEname());
				System.out.println("Emp job:::"+vo.getJob());
				System.out.println("Emp sal:::"+vo.getSal());
				System.out.println("Emp deptno:::"+ vo.getDepno());
				System.out.println("-------------------------------------------------");
				System.out.println("--------------------------------------------------");
			});
				
			
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		


	}

}
