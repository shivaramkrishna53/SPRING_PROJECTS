package com.nt.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@Autowired
	ServletContext sc;
	@Autowired
	ServletConfig cg;
	
	@RequestMapping("/student")
	public String studdetails(HttpSession ses,HttpServletRequest req)
	{
		System.out.println("Webapplication name::"+ sc.getContextPath());
		System.out.println("Webapplication path"+sc.getRealPath("/"));
		System.out.println("Dispatcher servlet logical name::"+cg.getServletName());
		System.out.println("Session id::"+ses.getId());
		System.out.println("reqest uri"+req.getRequestURI());
		return "welcome2";
	}
	
	
}
