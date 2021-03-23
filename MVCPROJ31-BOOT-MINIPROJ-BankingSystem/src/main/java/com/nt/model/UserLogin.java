package com.nt.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
public class UserLogin {
	private Long accountnumber;
	private String username;
	private String password;

}
