package com.tcs.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.tcs.order.Order;

public class OrderFieldSetMapper implements FieldSetMapper<Order> {

	@Override
	public Order mapFieldSet(FieldSet fieldSet) throws BindException {
		// TODO Auto-generated method stub
		Order or=new Order();
		or.setOrderId(fieldSet.readLong("order_id"));
		or.setFirstName(fieldSet.readString("first_name"));
		or.setLastName(fieldSet.readString("last_name"));
		or.setEmail(fieldSet.readString("email"));
		or.setCost(fieldSet.readBigDecimal("cost"));
		or.setItemId(fieldSet.readString("item_id"));
		or.setItemName(fieldSet.readString("item_name"));
		or.setShipDate(fieldSet.readDate("ship_date"));

		return or;
	}

}
