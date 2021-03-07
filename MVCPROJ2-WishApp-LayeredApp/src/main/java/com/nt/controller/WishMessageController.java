package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.service.IWishMessage;

public class WishMessageController implements Controller {

	IWishMessage wmg;
	public  WishMessageController(IWishMessage wmg) 
	{
		this.wmg=wmg;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//b.logics to communicate with service or dao
		String msg=wmg.getWishMessage();
		return new ModelAndView("result","WishMsg",msg);
	}

}
