package com.nt.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Customer {

	private String cname;
	private String cadd;
	private Integer billamnt;
	private String vflag="no";
	private String gender;
	private String[] hobbies= {"cricket","sleeping"};
	private Set<String> skills=Set.of("java");
	private String[] countriesvisited= {"India","usa"};
	private List<String> languagesknown= List.of("English","Telugu","Hindi");
	private Date dob;
	private Date doj;
}
