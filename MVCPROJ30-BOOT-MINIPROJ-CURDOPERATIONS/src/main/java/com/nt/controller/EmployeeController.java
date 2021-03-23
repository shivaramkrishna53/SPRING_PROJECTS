package com.nt.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employees;
import com.nt.service.IEmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	IEmployeeService ser;
	
	@GetMapping("/")
	public String redirectrequest()
	{
		return "redirect:home";
	}
	
	@GetMapping("/home")
	public String homepage()
	{
		return "home_page";
		
	}
	
	@GetMapping("/regemp")
	public String registeremp(@ModelAttribute("emp")Employees e)
	{
		return "empregform";
	}
	
	@PostMapping("/regemp")
	public String registerempprogress(@ModelAttribute("emp")Employees e,Map<String,Object> m)
	{
		String result=ser.registerEmployee(e);
		m.put("empresult",result);
		return "registerempresultpage";
		
	}
	
	@GetMapping("/genrep")	
	public String generateempreport(Map<String,Object> m)
	{
		Iterable<Employees> itr=ser.getAllEmployeedetails();
		m.put("empslist",itr);
		return "genratereportpage";
	}
	
	@GetMapping("/edit")
	public String geteditemployeedetails(@RequestParam("no") int eno,@ModelAttribute("emp")Employees e)
	{
		
	         Employees emps=ser.updateEmployee(eno); 
	         BeanUtils.copyProperties(emps,e);
	         return "editemployeepage";
	}
	
	@PostMapping("/updateemployee")
	public String updateEditEmployeeDetails(@ModelAttribute("emp") Employees e,RedirectAttributes rediat)
	{
		String result=ser.updateEmployeeDetails(e);
		rediat.addFlashAttribute("resultMsg",result);
		
			return "redirect:genrep";
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("no") int eno,RedirectAttributes rdat)
	{
		String res=ser.deleteEmployee(eno);
		rdat.addFlashAttribute("resultMsg", res);
		return "redirect:genrep";
	}
}
