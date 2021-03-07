package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.EmployeeDto;
import com.nt.service.IEmpService;

@Controller
public class EmpController {

	@Autowired
	IEmpService ser;
	
	//@RequestMapping("/home") or
	@RequestMapping("/home")
	public String homepage()
	{
		return "home";
	}
	
	
	@RequestMapping("empdetails")
	public String processEmpDetails(Map<String,Object> m)
	{
	
		List<EmployeeDto> lstempdto=ser.getEmpdetails();
		m.put("lstempdata",lstempdto);
		return "empdetails";
	}
}
