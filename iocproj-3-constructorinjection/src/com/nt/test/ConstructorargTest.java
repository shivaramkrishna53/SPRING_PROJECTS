package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.wishMessageGenerator;

public class ConstructorargTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource res=new FileSystemResource("src/com/nt/cfgs/ApplicationContext.xml");
		BeanFactory fac=new XmlBeanFactory(res);
		Object obj=fac.getBean("wmg");
		wishMessageGenerator w=(wishMessageGenerator)obj;
		w.callfunmethod();
		w.wish("shiva");
		
		

	}

}
