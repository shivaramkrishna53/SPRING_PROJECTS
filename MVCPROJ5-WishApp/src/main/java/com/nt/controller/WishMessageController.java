package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IWishMessage;

@org.springframework.stereotype.Controller
public class WishMessageController 
{
     @Autowired
	IWishMessage wmg;
	
     @RequestMapping("/welcome.do")
     public String welcomepage()
     {
    	return "home"; 
     }
	
//     @RequestMapping("/wish.do")
//	public Map<String,Object> getwishmsg()
//	{
//    	 Map<String,Object> m=new HashMap<String,Object>();
//		String msg=wmg.getWishMessage();
//		m.put("WshMsg",msg);
//		return m;
//		//return "result";
//		
//		
//	}
     
     @RequestMapping("/wish.do")
     public String getwishmsg(Map<String,Object> m)
     {
    	 String msg=wmg.getWishMessage();
    	 m.put("WshMsg",msg);
        return "result";
     }

}
