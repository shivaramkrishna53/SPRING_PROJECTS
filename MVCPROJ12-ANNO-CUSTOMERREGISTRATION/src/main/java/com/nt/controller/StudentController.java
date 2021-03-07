package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Student;
import com.nt.service.IStudentService;


@Controller
public class StudentController {

	@Autowired
	IStudentService ser;
	
	@GetMapping("/student")
	public String studentregisterform(@RequestParam String sadd,@ModelAttribute("stud")Student st)
	{
		st.setSadd(sadd);
		return "student_form";
	}
	
	@PostMapping("/student")
	public String studentrecordstoringintodbanddisplaying(Map<String,Object>m,@ModelAttribute("stud")Student st)
	{
		String x=ser.registerStudent(st);
		m.put("studentresult",x);
		return "result";
	}
}
