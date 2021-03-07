package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/register")
	public String register()
	{
		System.out.println("TestController.register()");
		return "redirect:save";
	}
}
