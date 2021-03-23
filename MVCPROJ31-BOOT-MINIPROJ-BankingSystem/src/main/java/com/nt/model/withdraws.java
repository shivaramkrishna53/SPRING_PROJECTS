package com.nt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class withdraws {

	@Id
	@GeneratedValue
	private Integer sno;
	private Long frmaccno;
	private Long toaccno;
	private Double debitedamount;
	private Date dateofdebit;
	
}
