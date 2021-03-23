package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class employeelogin {
	@Id
	private String username;
	private String password;

}
