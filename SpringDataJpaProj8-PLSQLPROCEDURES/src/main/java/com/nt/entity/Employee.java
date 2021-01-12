package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "EMPLOYEE")
@Data
public class Employee {
	@Id
	@Column(name = "eno")
	private Integer eno;
	@Column(name = "ename")
	private String ename;
	@Column(name="eadd")
	private String eadd;
	@Column(name="esal")
	private Float esal;

}
