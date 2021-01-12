package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class employee {
	@Column(name="eno")
	@Id
	Integer eno;
	@Column(name="ename")
	String ename;
	@Column(name="eadd")
	String eadd;
	@Column(name="esal")
	Float esal;
	
	
	

}
