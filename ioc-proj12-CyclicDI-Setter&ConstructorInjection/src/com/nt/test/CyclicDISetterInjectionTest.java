package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.A;
import com.nt.beans.B;

public class CyclicDISetterInjectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileSystemResource res=new FileSystemResource("src/com/nt/cfgs/ApplicationContext.xml");
		XmlBeanFactory fac=new XmlBeanFactory(res);
		B obj=fac.getBean("bclass", B.class);
		obj.fun2();
		
	}

}
