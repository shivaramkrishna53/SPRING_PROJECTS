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
	
	@PostMapping("/student")   //P--->Post in PRG
	public String studentrecordstoringintodbanddisplaying(Map<String,Object>m,@ModelAttribute("stud")Student st,RedirectAttributes redirectatt)
	{
		String x=ser.registerStudent(st);
		redirectatt.addFlashAttribute("studentresultredirect",x);//redirectattriibute.addflashattributes store the data and it is visible in all the request scopes so that the redirected handler method can use this data
		m.put("studentresult",x); //BindingAwareModelMap object is specific to the cuurent scope(request scope) and the data is not visible in the redirected url handler method as the each handler methods use has its specific req,res obj and req,res objs change from handler method to other handler method.
		return "redirect:show"; //R-->redirect in PRG
	}
	
	@GetMapping("/show") //G-->Get in PRG
	public String showresult()
	{
		return "result";
	}
	
	

	
}
