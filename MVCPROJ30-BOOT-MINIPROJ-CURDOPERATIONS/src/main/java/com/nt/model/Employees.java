package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eno;
	private String ename;
	private String eadd;
	private Float esal;
}
