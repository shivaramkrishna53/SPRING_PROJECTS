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
	public String studentformpage()
	{
	return "student_form";	
	}
	
	@PostMapping("/student")
	public String processformpage(Map<String,Object> m,@ModelAttribute("stud") Student st)
	{
	m.put("student",st); //placing the command/model class obj in the map	
		return "result";
	}
}
