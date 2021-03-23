package com.nt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserSignupDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountnumber;
	private String firstname;
	private String lastname;
	private Long phonenumber;
	private String address;
	private String emailid;
	
}
