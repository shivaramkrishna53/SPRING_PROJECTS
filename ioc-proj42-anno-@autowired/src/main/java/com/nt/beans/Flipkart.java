package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Flipkart {
	
	  @Autowired
	  
	  @Qualifier("dhl")
	 
	private Courier c ;
	
	//@Autowired annotation leads to error in case of zero-param constructor
//	@Autowired
//	public Flipkart()
//	{
//		System.out.println("Flipkart 0-param constructor");
//	}
	
	
	  
	  
		//@Autowiring at arbitary method level
		@Autowired()
		@Qualifier("dtdc")
		public void fun(Courier c)
		{
			this.c=c;
			System.out.println("arbitary method");
		}
		
		//@Autowired at constructor
		
		@Autowired(required = false)
		  
		 public Flipkart(@Qualifier("bluedart") Courier c,Dhl d) 
		  { this.c=c;
		  System.out.println("flipkart 2-param 1st constructor");
		  }
		  
		  
		//@Autowired at constructor
			
		  @Autowired(required = false)
		  
		 public Flipkart(@Qualifier("dhl") Courier c,BlueDart bd) 
		  { this.c=c;
		  System.out.println("flipkart 2-param 2nd constructor");
		  }

	 		  
	
	//@Autowired at setter-method
	
	  @Autowired
	  
	  @Qualifier("dhl") 
	  public void setCourier(Courier c) 
	  { this.c=c;
	  System.out.println("flipkart setter method");
	   }
	 
	
	

	
	
	
	
	public void callcouriercompanies()
	{
		System.out.println(c.delivery());
	}

}
