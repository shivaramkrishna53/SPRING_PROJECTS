package com.nt.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.nt.service.ICountries;

public class Countries implements Controller {

	ICountries con;
	 public Countries(ICountries con) {
	this.con=con;	
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<String> countriesList=con.getAllCountries();
		List<String> languagesList=con.getAllCountriesLanguages();
		String[] pair=new String[countriesList.size()+languagesList.size()];
		int i;
		for(i=0;i<countriesList.size();i++)
		{
		pair[i]=countriesList.get(i);	
		}
		
		for(int j=0;j<languagesList.size();j++)
		{
			pair[i+j]=languagesList.get(j);
		}
		String x=Arrays.deepToString(pair);
		return new ModelAndView("result", "AllCountries", x);
	}

}
