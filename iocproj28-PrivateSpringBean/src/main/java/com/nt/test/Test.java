package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.TestBean;

public class Test{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestBean tb=null;
		Object o=null;
		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/ApplicationContext.xml");
		tb=(TestBean) factory.getBean("tb",TestBean.class);
		System.out.println(tb);
		o=factory.getBean("privcla",Object.class);
		System.out.println(o);
		
		

	}

}
