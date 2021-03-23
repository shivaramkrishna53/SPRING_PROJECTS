package com.nt.repo;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.model.deposits;
import com.nt.model.withdraws;

public interface WithdrawsRepo extends CrudRepository<withdraws,Integer> {

	@Query("select frmaccno,toaccno,debitedamount,dateofdebit from withdraws where frmaccno=:acno")
	public Iterable<withdraws> getallwithdraws(@Param("acno") Long accno);
	
}


