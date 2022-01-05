package com.tcs.batch;

import java.util.Random;

import org.springframework.batch.item.ItemProcessor;

import com.tcs.order.Order;
import com.tcs.order.TransformedOrder;

public class process implements ItemProcessor<Order, TransformedOrder> {

	@Override
	public TransformedOrder process(Order item) throws Exception {
		// TODO Auto-generated method stub
		TransformedOrder transordr=new TransformedOrder(item);
		transordr.setShippingid(getshippingId());
		return transordr;
	}
	
	private int getshippingId() throws Exception
	{
		if(Math.random()<0.01)
		{
			throw new Exception();
		}
		
			return new Random().nextInt();
	}

}
