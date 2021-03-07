package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeeController {

	@RequestMapping("/save")
	public String save()
	{
		System.out.println("EmployeeeController.save()");
		return "redirect:show";
	}
	
	@RequestMapping("/delete")
	public String delete()
	{
		System.out.println("EmployeeeController.delete()");
		return "redirect:show";
	}
	
	@RequestMapping("/show")
	public String showemp()
	{
		System.out.println("EmployeeeController.showemp()");
	 return "welcome2";	
	}
}
