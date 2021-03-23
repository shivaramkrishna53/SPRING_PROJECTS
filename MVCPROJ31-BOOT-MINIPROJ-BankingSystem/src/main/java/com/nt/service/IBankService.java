package com.nt.service;

import com.nt.model.UserCredentials;
import com.nt.model.UserSignupDetails;
import com.nt.model.deposits;
import com.nt.model.withdraws;

public interface IBankService {
	
	public boolean savesignindetails(UserSignupDetails u);
	public boolean saveusercredentials(UserCredentials uc);
	public int validateULogin(Long accno,String uname,String pwd);
	public double getbalance(Long accno);
	public String transferfunds(long frmacc,long toacc,double amnt,deposits d,withdraws w);
	public Iterable<deposits> gettransactionsdeposits(long accno);
	public Iterable<withdraws> gettransactionswithdraws(long accno);

}
