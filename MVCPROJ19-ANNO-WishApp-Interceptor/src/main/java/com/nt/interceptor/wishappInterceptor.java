package com.nt.interceptor;


import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component("wishinter")
public class wishappInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
           
		LocalDateTime l=LocalDateTime.now();
		int hr=l.getHour();
		RequestDispatcher rd=req.getRequestDispatcher("/timeout.jsp");
		if(hr<9 || hr>17)
		{
			rd.forward(req, res);
		return false;
		}
		else
			return true;
	}
}
