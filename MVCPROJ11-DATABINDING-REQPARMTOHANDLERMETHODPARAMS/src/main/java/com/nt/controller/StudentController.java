package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	
	@GetMapping("/student")
	public String requestparamsprocessing(Map<String,Object> m,@RequestParam(required = false,defaultValue = "109") int sno,@RequestParam(required =false,defaultValue = "shivaram") String sname)
	{
		m.put("studentno",sno);
		m.put("studentname",sname);
		return "result";
	}

}
