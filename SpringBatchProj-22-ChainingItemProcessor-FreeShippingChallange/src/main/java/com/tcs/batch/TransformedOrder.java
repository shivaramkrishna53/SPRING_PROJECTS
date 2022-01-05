package com.tcs.batch;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class TransformedOrder extends Order {

	private String isShipping;
	private long trackingid;
	public TransformedOrder(Order or)
	{
		BeanUtils.copyProperties(or, this);
	}
}
