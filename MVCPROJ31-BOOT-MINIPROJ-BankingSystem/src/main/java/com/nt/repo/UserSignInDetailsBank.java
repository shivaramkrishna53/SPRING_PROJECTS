package com.nt.repo;

import org.springframework.data.repository.CrudRepository;

import com.nt.model.UserSignupDetails;

public interface UserSignInDetailsBank extends CrudRepository<UserSignupDetails,Long> {

}
