package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.TransferMoney;
import com.nt.model.UserCredentials;
import com.nt.model.UserLogin;
import com.nt.model.UserSignupDetails;
import com.nt.model.deposits;
import com.nt.model.withdraws;
import com.nt.service.IBankService;

@Controller
public class BankController {
	@Autowired
	IBankService ser;
	
	@GetMapping("/")
	public String redirecthomepage()
	{
		return "redirect:home";
	}
	
	@GetMapping("/home")
	public String homepage()
	{
		return "homepage";
	}
	
	@GetMapping("/usignup")
	public String usignuppage(@ModelAttribute("usd")UserSignupDetails u)
	{
		return "usersignuppage";
	}
	
	@PostMapping("/saveregistration")
	public String SaveSignupdetails(@ModelAttribute("usd") UserSignupDetails u,@ModelAttribute("usercre")UserCredentials uc,Map<String,Object> m)
	{
	
		boolean flag=ser.savesignindetails(u);
		uc.setAccountnumber(u.getAccountnumber());
		m.put("result",u.getAccountnumber());
		if(flag)
			return "chooseusernamepasswordpage";
		else
			return "failedtosavepage";
		
	}
	
	@PostMapping("/saveusercredentials")
	public String SaveUserCredentials(@ModelAttribute("usercre")UserCredentials uc,Map<String,Object> m)
	{
		

		if(! uc.getPassword().equalsIgnoreCase(uc.getRepassword()))
		{
			m.put("mismatch","password and reenter password need to match");
			return "chooseusernamepasswordpage";
		}
		else
		{
			boolean flag=ser.saveusercredentials(uc);
			if(flag)
			{
				m.put("result","username and password successfully saved");
				return "resultpageofchooseusernamepassword";
			}
			else
			{
				m.put("result","username and password failed to save");
				return "resultpageofchooseusernamepassword";
				
			}
		}
		
	}
	
	@GetMapping("/ulogin")
	public String UserLogin(@ModelAttribute("ulog") UserLogin ul)
	{
		return "uloginpage";
	}
	
	@PostMapping("/validateulogin")
	public String UserLoginVerify(@ModelAttribute("ulog") UserLogin ul,Map<String,Object> m)
	{
		int res=ser.validateULogin(ul.getAccountnumber(),ul.getUsername(),ul.getPassword());
		if(res>0)
		{
//			m.put("result","userlogged in Successfully");
//			m.put("uname",ul.getUsername());
//			m.put("upass",ul.getPassword());
			m.put("acno",ul.getAccountnumber());
			return "insideloginpage";
			
		}
		else
		{
			m.put("result","Invalid credentials!!! Try Again");
			return "uloginpage";
		}
	}
	
	@GetMapping("/checkbalance")
	public String CheckBalance(@RequestParam("no") Long uaccno,Map<String,Object>m)
	{
		double bal=ser.getbalance(uaccno);
		m.put("balance",bal);
		return "insideloginpage";
	}
	
	@GetMapping("/transfermoney")
	public String transferMoney(@RequestParam("no") Long presentaccno,@ModelAttribute("tm")TransferMoney tm)
	{
		tm.setFromaccount(presentaccno);
		return "transfermoneypage";
		
	}
	
	@PostMapping("/transfernow")
	public String transfernow(@ModelAttribute("tm") TransferMoney tm,Map<String,Object>m ,@ModelAttribute("depo")deposits d,@ModelAttribute("with")withdraws w)
	{
		String result=ser.transferfunds(tm.getFromaccount(),tm.getToaccount(),tm.getAmount(),d,w);
		m.put("result",result);
		return "transferresultpage";
	}
	
	@GetMapping("/transactions")
	public String transactionslist(@RequestParam("no") Long presentac,Map<String,Object> m)
	{
		m.put("depositslst",ser.gettransactionsdeposits(presentac));
		m.put("withdrawslst",ser.gettransactionswithdraws(presentac));
	
		return "listoftransctionspage";
	}
}

