package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserCredentials {

	@Id
	private Long accountnumber;
	private String username;
    private String password;
    private String repassword;
    private Double balance=0.0;
}
