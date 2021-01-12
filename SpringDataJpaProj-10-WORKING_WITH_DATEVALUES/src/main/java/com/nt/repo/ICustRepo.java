package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CustBillDetails;

public interface ICustRepo extends JpaRepository<CustBillDetails,Integer> {
	
	public CustBillDetails findById(int id);

}
