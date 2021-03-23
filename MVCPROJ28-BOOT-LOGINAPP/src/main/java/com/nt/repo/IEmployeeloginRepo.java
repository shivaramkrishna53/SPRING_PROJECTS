package com.nt.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.model.employeelogin;

public interface IEmployeeloginRepo extends CrudRepository<employeelogin,String> {

	@Query("select count(*) from employeelogin where username=:user and password=:pass")
	public int isuservalid(@Param("user")  String username,@Param("pass")String password);
}
