package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class CustBillDetails implements Serializable{
	@Id
	@GeneratedValue

	private Integer custid;
	private String custname;
	private Float custbillamnt;
	private LocalDate custdob;
	private LocalTime custtob;
	private LocalDateTime custbilldate;
	

}
