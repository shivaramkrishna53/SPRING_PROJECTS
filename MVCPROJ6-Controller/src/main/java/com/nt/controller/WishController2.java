package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wish2")
public class WishController2 {

	@RequestMapping("/home")
	public String fun()
	{
		return "welcome2";
	}
}
