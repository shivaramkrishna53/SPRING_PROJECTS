package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.employeelogin;
import com.nt.service.IEmployeeLogin;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("empser")
	IEmployeeLogin ser;
	
	@GetMapping("/")
	public String redirecthome()
	{
		return "redirect:home";
		
	}
	
	@GetMapping("/home")
	public String homepage()
	{
		return "homepage";
	}
	
	@GetMapping("/login")
	public String loginpage(@ModelAttribute("emp") employeelogin e)
	{
		return "loginpage";
		
	}
	@PostMapping("/login")
	public String loginprocessing(@ModelAttribute("emp")employeelogin e,Map<String,Object> m)
	{
		String result=ser.loginchecking(e);
		m.put("finalresult",result);
		return "resultpage";
	}

}
