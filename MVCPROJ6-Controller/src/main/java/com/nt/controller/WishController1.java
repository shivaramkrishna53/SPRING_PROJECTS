package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller

public class WishController1 {
//
//	// RequestMapping uri's are case sensitive
//	
//	@RequestMapping("/home")
//	public String fun1()
//	{
//		return "welcome1";
//	}
//	@RequestMapping("/HOME")
//	public String fun2()
//	{
//		return "welcome2";
//	}
	
	
	
//	// IF BOTH THE REQUEST PATH URI'S ARE SAME...THEN EXCEPTION OCCURS
//	@RequestMapping("/home")
//	public String fun1()
//	{
//		return "welcome1";
//	}
//	@RequestMapping("/home")
//	public String fun2()
//	{
//		return "welcome2";
//	}

	
//	//THOUGH WE HAVE SAME REQUEST URI'S WE NEED TO HAVE TWO DIFFERENT REQUEST MODES SUCH AS GET AND POST
//	@RequestMapping(value="/home",method =RequestMethod.GET)
//	public String fun1()
//	{
//		return "welcome1";
//	}
//	@RequestMapping(value="/home",method = RequestMethod.POST)
//	public String fun2()
//	{
//		return "welcome2";
//	}
	
	
//	//we can have multiple request uris for one handle method
//	@RequestMapping(value= {"/home","/welcome","/firstpage"})
//	public String fun()
//	{
//		return "welcome1";
//	}
	
//	//if we dont specify the handler method request mode then it takes both Get and Post mode request types
//	
//	@RequestMapping(value="/home",method =RequestMethod.POST)
//	public String fun()
//	{
//		return "welcome1";
//	}
//	

//	//if we want to display home page without implict request from index.jsp then directly use @RequestMapping("/") and delete the index.jsp
//	@RequestMapping("/")
//	public String fun()
//	{
//		return "welcome1";
//	}
	
	
//	@RequestMapping(value="/", method = RequestMethod.GET)
//	public String fun1()
//	{
//		return "welcome1";
//	}
//	
//	@RequestMapping(value="/", method = RequestMethod.POST)
//	public String fun2()
//	{
//		return "welcome2";
//	}
	
	
	
	
	
	
	
	
}
