package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessage;

@Controller
public class WishController {
	@Autowired
	IWishMessage ser;
	
	
	@RequestMapping("/home")
	public String gethome()
	{
		return "homepage";
	}
	
	@GetMapping("/mainpage")
	public String intomainpage(Map<String,Object> m)
	{
		String result=ser.processtheWish();
		m.put("resultmsg",result);
		return "resultpage";
	}

}
