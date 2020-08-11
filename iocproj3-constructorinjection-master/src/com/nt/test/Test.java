package com.nt.test;
import java.nio.file.FileSystem;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;



public class Test {

	public static void main(String[] args) {
		
		FileSystemResource res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		BeanFactory b=new XmlBeanFactory(res);
		WishMessageGenerator wmsg=(WishMessageGenerator) b.getBean("wmgshiva");
		
		wmsg.messagegenerator();


	}
	
}
