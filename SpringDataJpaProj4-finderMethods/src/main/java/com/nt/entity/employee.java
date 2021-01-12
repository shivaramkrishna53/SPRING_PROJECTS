package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.repo.employeerepo;

import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class employee {
	
	
	@Id
	private Integer eno;
	private String ename;
	private String eadd;
	private Float esal;
	

}
