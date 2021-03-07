package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentController {

	@GetMapping("/student")
	public String getFormPage(@ModelAttribute("stud")Student s)
	{
		s.setSadd("hyderabad");
		
		return "student_form";
	}
	@PostMapping("/student")
	public String getResult(Map<String,Object> m, @ModelAttribute("stud")Student s)
	{
		m.put("studentformdata",s);
		return "result";
	}
}
