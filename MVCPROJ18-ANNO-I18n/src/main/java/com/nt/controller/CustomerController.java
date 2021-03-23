package com.nt.controller;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.model.Customer;

@Controller
public class CustomerController {

	
	@RequestMapping("/customer")
	public String getCustomerFormPage(Map<String,Object> m,@ModelAttribute("cust") Customer c)
	{
		c.setAddress("Hyderabad");
		m.put("sysdate",new Date());
		m.put("salary",new Random().nextInt(10000));
		return "customer_form";
	}
}
