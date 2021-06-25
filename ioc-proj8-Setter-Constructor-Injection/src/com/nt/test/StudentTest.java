package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.Student;



public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileSystemResource res=new FileSystemResource("src/com/nt/cfgs/ApplicationContext.xml");
		BeanFactory fac=new XmlBeanFactory(res);
		Student s=fac.getBean("st",Student.class);
		s.displayDetails();

	}

}
