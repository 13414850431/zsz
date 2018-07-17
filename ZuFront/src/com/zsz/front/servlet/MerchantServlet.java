package com.zsz.front.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Merchant")
public class MerchantServlet extends BaseServlet {
	
	public void Apply(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		
		req.getRequestDispatcher("/WEB-INF/merchant/join.jsp").forward(req, resp);
	
	}
	
	public void LifeService(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("/WEB-INF/merchant/life-service.jsp").forward(req, resp);
		
	}
	
}
