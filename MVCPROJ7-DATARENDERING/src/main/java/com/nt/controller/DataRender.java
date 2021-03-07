package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.dto.EmployeeDto;

@Controller
public class DataRender {
	
	@RequestMapping("/data")
	public String fun(Map<String,Object> m)
	{
		m.put("name","shiva");
		m.put("age",23);
		m.put("address","hyd");
		
		// creating a List and pass it as data redering
		List<String> names=List.of("shiva","sai","roopesh","varu");
		//set
		Set<Float> phones=Set.of(1.0f,2.0f,3.0f,4.0f);
		//map
		Map<String,Integer> details=Map.of("shiva",1,"sai",2,"roopesh",3,"varu",4);
		//String[]
		String[] colors= {"red","yellow","black"};
		
		m.put("colors",colors);
		m.put("names",names);
		m.put("phones",phones);
		m.put("details",details );
		
		//creating dto obj and placing in model
		EmployeeDto dto=new EmployeeDto(101,"suresh",2000,"mumbai");
		m.put("empdto",dto);
		//adding list of employeedto objects
		List<EmployeeDto> lstempdto=List.of(new EmployeeDto(105,"hari",1000,"hyd"),new EmployeeDto(110,"roopesh",2000,"vizag"),new EmployeeDto(190,"varu",2000,"vizag"));
		m.put("lstempdto",lstempdto);
		return "home";
		
	}

}
