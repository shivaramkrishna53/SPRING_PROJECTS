package com.nt.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.model.UserCredentials;

public interface IUserCredentialsRepo extends CrudRepository<UserCredentials, Long> {

	@Query("select count(*) from UserCredentials where accountnumber=:acno and username=:uname and password=:pwd")
	public int validate(@Param("acno") Long accno,@Param("uname") String username, @Param("pwd")String password);
	
//	@Query("select balance from UserCredentials where accountnumber=:ano")
//	public double getbalance(@Param("ano")Long accno);
	
	
//	@Query("update UserCredentials set balance=:balance-amt where accountnumber=:fac ")
//	public int deductmoney(@Param("fac") Long frmaccno,@Param("amt") double amnt);
}
