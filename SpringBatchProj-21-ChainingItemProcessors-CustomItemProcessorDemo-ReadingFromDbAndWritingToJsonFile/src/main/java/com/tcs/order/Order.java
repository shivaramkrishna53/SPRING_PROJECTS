package com.tcs.order;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Order {
	
	private Long orderId;
	
	private String firstName;
	
	private String lastName;
	
    @Pattern(regexp=".*\\.gov")
	private String email;
	
	private BigDecimal cost;
	
	private String itemId;
	
	private String itemName;
	
	private Date shipDate;

}
