package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Employee")
@Data
public class Employee implements Serializable {
	@Column(name = "eno")
	@Id
	private Integer eno;
	@Column(name = "ename")
	private String ename;
	@Column(name = "eadd")
	private String eadd;
	@Column(name = "esal")
	private Float esal;

}
