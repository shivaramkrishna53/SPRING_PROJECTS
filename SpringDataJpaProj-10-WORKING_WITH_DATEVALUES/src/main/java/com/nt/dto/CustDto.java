package com.nt.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Data;
@Data
public class CustDto implements Serializable {
	private Integer custid;
	private String custname;
	private Float custbillamnt;
	private LocalDate custdob;
	private LocalTime custtob;
	private LocalDateTime custbilldate;

}
