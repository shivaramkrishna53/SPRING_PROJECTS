package com.cb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.cb.service.CricbuzzServiceImpl;

public class MainControllerServlet extends HttpServlet {

	ApplicationContext ctx=null;
	String score=null;
	RequestDispatcher rd=null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read req param value
		int matchid=Integer.parseInt(req.getParameter("mid"));
		//get the local Service class obj
		CricbuzzServiceImpl ser=ctx.getBean("crser",CricbuzzServiceImpl.class);
		//use the local service
		score=ser.getScore(matchid);
		//keep score in request scope
		req.setAttribute("scoreinfo",score);
		//forward to result.jsp
		rd=req.getRequestDispatcher("/result.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		((AbstractApplicationContext) ctx).close();
	}

	@Override
	public void init() throws ServletException {
		ctx=new ClassPathXmlApplicationContext("com/cb/ApplicationContext.xml");
	}

}
