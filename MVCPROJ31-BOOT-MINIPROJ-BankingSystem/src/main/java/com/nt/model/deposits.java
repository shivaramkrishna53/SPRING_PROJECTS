package com.nt.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class deposits {

	@Id
	@GeneratedValue
	private Integer sno;
	private Long toaccno;
	private Long frmaccno;
	private Double creditedamount;
	private Date dateofcredit;
	
}
