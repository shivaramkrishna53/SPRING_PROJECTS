package com.nt.model;

import lombok.Data;

@Data
public class Customer {

	private String cname;
	private String cadd;
	private Integer billamnt;
	private String vflag="no";
}