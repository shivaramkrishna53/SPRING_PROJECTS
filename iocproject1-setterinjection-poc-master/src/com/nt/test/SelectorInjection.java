package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import java.util.*;
import com.nt.beans.WishMessageGenerator;



public class SelectorInjection  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileSystemResource res=null;
		BeanFactory factory=null;
		WishMessageGenerator wmg=null;
		res=new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		factory=new XmlBeanFactory(res);
		Object obj=factory.getBean("wmsg");
		wmg=(WishMessageGenerator)obj;
		System.out.println(wmg.WishMessageGenerators("shiva"));

	}

}
