package com.nt.service;

import com.nt.dto.CustDto;

public interface ICustBill {
	public String registerCustomer(CustDto dto);
    public CustDto getCustByid(int id);
}
