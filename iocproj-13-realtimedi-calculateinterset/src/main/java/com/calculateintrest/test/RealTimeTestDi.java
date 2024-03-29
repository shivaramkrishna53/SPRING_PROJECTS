package com.calculateintrest.test;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.calculateintrest.controller.CustomerController;
import com.calculateintrest.vo.CustomerVo;
public class RealTimeTestDi {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);;
		
		
		String cno=null,ctime=null,crate=null,cname=null,cadd=null,cprinamnt=null,totalintrestamnt=null;
		 
		
		
		System.out.println("Enter the customer uniqueno:");
		cno=sc.next();
		System.out.println("Enter the customer name");
		cname=sc.next();
		System.out.println("Enter the customer address");
		cadd=sc.next();
		System.out.println("Enter the principal amount");
		cprinamnt=sc.next();
		System.out.println("Enter the time of intrest:");
		ctime=sc.next();
		System.out.println("Enter the rate of intrest:");
		crate=sc.next();
		CustomerVo vo=new CustomerVo();
		vo.setCno(cno);
		vo.setCadd(cadd);
		vo.setCname(cname);
		vo.setCprinamnt(cprinamnt);
		vo.setCrate(crate);
		vo.setCtime(ctime);
		
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/calculateintrest/cfgs/ApplicationContext.xml");
		CustomerController contro=factory.getBean("controller",CustomerController.class);
		try
		{
		String result=contro.processreq(vo);
		System.out.println(result);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
