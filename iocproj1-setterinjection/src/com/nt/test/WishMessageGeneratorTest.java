package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.nt.beans.WishMessageGenerator;



public class WishMessageGeneratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource res=new FileSystemResource("src/com/nt/cfgs/ApplicationContext.xml");
		BeanFactory fac=new XmlBeanFactory(res);
		Object obj=fac.getBean("wmg");
		WishMessageGenerator w=(WishMessageGenerator)obj;
		System.out.println(w.wishMsg("shiva"));

	}

}
