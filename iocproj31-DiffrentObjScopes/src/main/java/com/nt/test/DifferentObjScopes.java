package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.WishMessageGenerator;

public class DifferentObjScopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		WishMessageGenerator obj1=null,obj2=null,obj3=null,obj4=null,obj5=null,obj6=null,obj7=null,obj8=null,obj9=null;
		//creating factory
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/ApplicationContext.xml");
		obj1=factory.getBean("wmg",WishMessageGenerator.class);
		obj2=factory.getBean("wmg",WishMessageGenerator.class);
		obj3=factory.getBean("wmg",WishMessageGenerator.class);
		System.out.println(obj1.hashCode()+"  "+obj2.hashCode()+"  "+obj3.hashCode());
		System.out.println("---------------------------------------------------------------");
		obj4=factory.getBean("wmg1",WishMessageGenerator.class);
		obj5=factory.getBean("wmg1",WishMessageGenerator.class);
		obj6=factory.getBean("wmg1",WishMessageGenerator.class);
		System.out.println(obj4.hashCode()+"  "+obj5.hashCode()+"  "+obj6.hashCode());
		System.out.println("----------------------------------------------------------------");
		obj7=factory.getBean("wmg2",WishMessageGenerator.class);
		obj8=factory.getBean("wmg2",WishMessageGenerator.class);
		obj9=factory.getBean("wmg2",WishMessageGenerator.class);
		System.out.println(obj7.hashCode()+"  "+obj8.hashCode()+"  "+obj9.hashCode());

	}

}
