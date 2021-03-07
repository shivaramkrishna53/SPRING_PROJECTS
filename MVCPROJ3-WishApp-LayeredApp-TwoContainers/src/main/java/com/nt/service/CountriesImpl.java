package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CountriesImpl implements ICountries {

	
	@Override
	public List getAllCountries() {
		List<String> countries=new ArrayList<String>();
		Locale locs[]=Locale.getAvailableLocales();
		for(Locale l:locs)
		{
			if(l!=null)
			{
				countries.add(l.getDisplayCountry());
			}
		}
		return countries;
	}

	@Override
	public List getAllCountriesLanguages() {
		List<String> lang=new ArrayList<String>();
		Locale[] loc=Locale.getAvailableLocales();
		for(Locale l:loc)
		{
			if(l!=null)
			{
				lang.add(l.getDisplayLanguage());
			}
		}
		return lang;
	}

	

}
