package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EmployeeDetails")
@Data
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="eno")
	private Integer eno;
	@Column(name = "ename", length = 20)
	private String ename;
	@Column(name = "eadd",length=20)
	private String eadd;
	@Column(name="esal")
	private Float esal;
	

}
