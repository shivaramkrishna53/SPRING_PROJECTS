package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Printer;
import com.nt.beans.PrinterEnum;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultListableBeanFactory factory=null;
		Printer p1=null,p2=null,p5=null,p6=null;
		PrinterEnum p3=null,p4=null;
		
		factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/ApplicationContext.xml");
		p1=factory.getBean("prin",Printer.class);
		p2=factory.getBean("prin",Printer.class);
		
		System.out.println("p1 obj ref::"+p1.hashCode());
		System.out.println("p2 obj ref::"+p2.hashCode());
		
		p3=PrinterEnum.PrinterInstance;
		p4=PrinterEnum.PrinterInstance;
		
		System.out.println("p3 obj ref::"+p3.hashCode());
		System.out.println("p4 obj ref::"+p4.hashCode());
		
		p5=factory.getBean("prin1",Printer.class);
		p6=factory.getBean("prin1",Printer.class);
		System.out.println("p5 obj ref::"+p5.hashCode());
		System.out.println("p6 obj ref::"+p6.hashCode());
		
	

	}

}
