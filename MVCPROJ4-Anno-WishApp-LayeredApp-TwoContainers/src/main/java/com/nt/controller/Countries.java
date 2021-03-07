package com.nt.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.service.ICountries;
@org.springframework.stereotype.Controller
public class Countries {
    @Autowired
	ICountries con;
    
    @RequestMapping("/welcome.htm")
    public String gethomepage()
    {
    return "welcome";
    }
    
    @RequestMapping("/countries.htm")
	public String countriespage(Model m)
	{
		List<String> countriesList=con.getAllCountries();
		List<String> languagesList=con.getAllCountriesLanguages();
		m.addAttribute("countries", countriesList);
		m.addAttribute("languages", languagesList);
		return "result";
	}

	
	

}
