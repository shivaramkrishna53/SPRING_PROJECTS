package com.nt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.model.UserCredentials;
import com.nt.model.UserSignupDetails;
import com.nt.model.deposits;
import com.nt.model.withdraws;
import com.nt.repo.DepositsRepo;
import com.nt.repo.IUserCredentialsRepo;
import com.nt.repo.UserSignInDetailsBank;
import com.nt.repo.WithdrawsRepo;
@Service
public class BankServiceImpl implements IBankService {

	@Autowired
	UserSignInDetailsBank repo;
	@Autowired
	IUserCredentialsRepo repo2;
	@Autowired
	DepositsRepo repo3;
	@Autowired
	WithdrawsRepo repo4;
	
	@Override
	public boolean savesignindetails(UserSignupDetails u) {
		UserSignupDetails user=repo.save(u);
		if(user!=null)
			return true;
		else
			return false;
		
	}

	@Override
	public boolean saveusercredentials(UserCredentials uc) {
		
		UserCredentials y=repo2.save(uc);
		if(y!=null)
			return true;
		else
		return false;
	}

	@Override
	public int validateULogin(Long accno,String uname, String pwd) {
		// TODO Auto-generated method stub
		int result=repo2.validate(accno,uname, pwd);
		return result;
	}

	@Override
	public double getbalance(Long accno) {
		// TODO Auto-generated method stub
		//repo2.getbalance(accno);
		Optional<UserCredentials> o=repo2.findById(accno);
		UserCredentials u=o.get();
		return u.getBalance();
	}

	@Override
	public String transferfunds(long frmacc, long toacc, double amnt ,deposits d,withdraws w) {
		// TODO Auto-generated method stub
		String result=null;
		Optional<UserCredentials> op1=repo2.findById(frmacc);
		Optional<UserCredentials> op2=repo2.findById(toacc);
		if(op1.isPresent()==false || op2.isPresent()==false)
		{
			result="Invalid account number's entered please check again and try!!";
            System.out.println("inside null value");		
		
		}
		else
		{
			System.out.println("inside not null value");
			
		UserCredentials uc2=op2.get();
		UserCredentials uc1=op1.get();
		
		
		if(uc1.getBalance()<amnt)
		result="Insuffient funds to transfer";
		else
		{
			double x=uc1.getBalance()-amnt;
			uc1.setBalance(x);
			double y=uc2.getBalance();
			uc2.setBalance(y+amnt);
			
			
			d.setCreditedamount(amnt);
			d.setFrmaccno(uc1.getAccountnumber());
			d.setToaccno(uc2.getAccountnumber());
			d.setDateofcredit(new Date());
			
			w.setDebitedamount(amnt);
			w.setFrmaccno(uc1.getAccountnumber());
		    w.setToaccno(uc2.getAccountnumber());
		    w.setDateofdebit(new Date());
			
			UserCredentials uc3=repo2.save(uc1);
			UserCredentials uc4=repo2.save(uc2);
			
			deposits d1=repo3.save(d);
			withdraws w1=repo4.save(w);
			
			
			if(uc3!=null && uc3!=null && d1!=null && w1!=null)
				result="Successfully funds got transfered!";
		}
		
		
		}
		
		return result;
		
	}

	@Override
	public Iterable<deposits> gettransactionsdeposits(long accno) {
		// TODO Auto-generated method stub
	
		return repo3.getalldepo(accno);
	}

	@Override
	public Iterable<withdraws> gettransactionswithdraws(long accno) {
		// TODO Auto-generated method stub
		
		return repo4.getallwithdraws(accno);
	}

}
