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
		Random rand=new Random();
		transordr.setShippingid(rand.nextInt());
		return transordr;
	}

}
