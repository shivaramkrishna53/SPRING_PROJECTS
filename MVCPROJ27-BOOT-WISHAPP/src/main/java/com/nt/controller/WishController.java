package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IwishMessage;

@Controller("wishcontro")
public class WishController {
	
	@Autowired
	IwishMessage ser;
	@GetMapping("/")
	public String defaultpage()
	{
		return "redirect:home";
	}
	
	@GetMapping("/home")
	public String homepagegen()
	{
		return "home_page";
	}

	@GetMapping("/wish")
	public String getWish(Map<String,Object> m)
	{
		String msg=ser.getWishMessage();
		m.put("wishmsg",msg);
		return "result";
		
	}
}
