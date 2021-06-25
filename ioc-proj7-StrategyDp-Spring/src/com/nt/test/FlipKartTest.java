package com.nt.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import com.nt.beans.Flipkart;


public class FlipKartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileSystemResource	res=new FileSystemResource("src/com/nt/config/applicationContext.xml");
		BeanFactory fac=new XmlBeanFactory(res);
		Flipkart f=(Flipkart) fac.getBean("flpkrt");
		f.calculatebillanddelivery(new String[] {"bat","ball"},new int[] {100,200});
	}

}
