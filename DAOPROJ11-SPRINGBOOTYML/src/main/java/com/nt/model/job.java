package com.nt.model;

import lombok.Data;

@Data
public class job {
	private String company;
	private String location;
	private String designation;
	private int salary;
	private job j;

}
