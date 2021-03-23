package com.nt.model;

import lombok.Data;

@Data
public class TransferMoney {

	private Long fromaccount;
	private Long toaccount;
	private Double amount;
}
