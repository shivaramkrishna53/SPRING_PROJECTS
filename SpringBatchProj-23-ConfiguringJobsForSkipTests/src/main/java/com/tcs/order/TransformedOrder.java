package com.tcs.order;

import java.util.Random;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class TransformedOrder extends Order {

	private int shippingid;
	
	
	
	public TransformedOrder(Order or)
	{
		BeanUtils.copyProperties(or, this);
		
	}
}
