package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class AcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext con=null;
		con=new ClassPathXmlApplicationContext("com/nt/cfgs/ApplicationContext.xml"); //pre instansiation of spring bean classes happening for whose bean scope="singleton" 
		
		
//		DefaultListableBeanFactory fac=new DefaultListableBeanFactory();   
//		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(fac);
//		reader.loadBeanDefinitions("com/nt/cfgs/ApplicationContext.xml");
//		fac.getBean("wmg",WishMessageGenerator.class);
		

	}

}
