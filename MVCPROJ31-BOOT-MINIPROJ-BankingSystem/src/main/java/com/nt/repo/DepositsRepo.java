package com.nt.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.model.deposits;

public interface DepositsRepo extends CrudRepository<deposits, Integer> {

	@Query("select toaccno,frmaccno,creditedamount,dateofcredit from deposits where toaccno=:acno")
	public Iterable<deposits> getalldepo(@Param("acno") Long accno);
}


