package com.nt.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Customer;
import com.nt.service.ICustomerService;
import com.nt.validator.CustomerFormValidator;


@Controller
public class CustomerController {

	@Autowired
	CustomerFormValidator cv;
	@Autowired
	ICustomerService ser;
	
	@GetMapping("/customer")
	public String CustomerRegistrationPage(@RequestParam String cadd,@ModelAttribute("cust") Customer c)
	{
		c.setCadd(cadd);
		return "customer_registration_form";
	}
	@PostMapping("/customer") //P->POST IN PRG
	public String CustomerFormValidation(Map<String,Object> m, @ModelAttribute("cust")Customer c,Errors e,RedirectAttributes redirectatt)
	{
		
		System.out.println("Gender::"+c.getGender()+" Hoobies:: "+Arrays.deepToString(c.getHobbies())+" Skills:: "+c.getSkills()+ " Countries Visited::"+c.getCountriesvisited()+" Languages Known::"+ c.getLanguagesknown());
		if(c.getVflag().equalsIgnoreCase("no"))
		{
		if(cv.supports(c.getClass()))
			cv.validate(c,e);
		
		if(e.hasErrors())
			return "customer_registration_form";
		
		}
		String x=ser.registerCustomer(c);
		redirectatt.addFlashAttribute("studentresultredirect",x);//redirectattriibute.addflashattributes store the data and it is visible in all the request scopes so that the redirected handler method can use this data
		m.put("studentresult",x); //BindingAwareModelMap object is specific to the cuurent scope(request scope) and the data is not visible in the redirected url handler method as the each handler methods use has its specific req,res obj and req,res objs change from handler method to other handler method.
		return "redirect:show"; //R-->redirect in PRG
		
	}
	
	@GetMapping("/show")
	public String showresultpage()
	{
		return "result";
	}
	
	//creating the @ModelAttribute for the radio buttons
	@ModelAttribute("genderradio")
	public List<String> addradiobuttons()
	{
		List<String> gen=List.of("male","female","transgender");
		return gen;
	}
	
	//using @modelAttribute for generating the checkboxes items 
	
	@ModelAttribute("hobbiescheckboxes")
	public List<String> getcheckboxes()
	{
		List<String> chkbxs=List.of("cricket","sleeping","watching movies","music");
		return chkbxs;
	}
	
	//using @modelattribute on top of method for dynamic generation of the items in the form page and use @modelAttribute as param value to make the class as model class and store the selected items from the form as inputs

	@ModelAttribute("skillsoptions")
	public Set<String> getselectoptions()
	{
		Set<String> optns=Set.of("java","python",".net","php");
		return optns;
	}
	
	//for selecting country
	@ModelAttribute("countriesoptions")
	public Set<String> getcountries()
	{
		Set<String> countries=new HashSet<String>();
		Locale[] locs=Locale.getAvailableLocales();
		for(Locale l:locs)
		{
			countries.add(l.getDisplayCountry());
		}
		return countries;
	}
	
	//for selecting the languages known
	@ModelAttribute("languagesoptions")
	public Set<String> languagesknown()
	{
		Set<String> languages=new HashSet<String>();
		Locale[] locs=Locale.getAvailableLocales();
		for(Locale l:locs)
		{
			languages.add(l.getDisplayLanguage());
		}
		return languages;
	}

}
