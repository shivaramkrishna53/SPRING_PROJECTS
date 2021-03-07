package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.Customer;
import com.nt.validator.CustomerFormValidator;

@Controller
public class CustomerController {

	@Autowired
	CustomerFormValidator cv;
	
	@GetMapping("/customer")
	public String CustomerRegistrationPage(@RequestParam String cadd,@ModelAttribute("cust") Customer c)
	{
		c.setCadd(cadd);
		return "customer_registration_form";
	}
	@PostMapping("/customer")
	public String CustomerFormValidation(Map<String,Object> m, @ModelAttribute("cust")Customer c,Errors e)
	{
		
		if(cv.supports(c.getClass()))
			cv.validate(c,e);
		
		if(e.hasErrors())
			return "customer_registration_form";
		
		m.put("Result","Customer successfully regiistered");
		return "result";
		
	}
}
