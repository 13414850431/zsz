package com.zsz.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet  extends HttpServlet {
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        System.out.println("成功访问到Servlet");
	        System.out.println(request.getRequestURI());
	    }
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        doGet(request, response);
	    }
	
}
