package com.nucleus.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nucleus.model.UserLogin;
import com.nucleus.pojo.LoginPOJO;
import com.nucleus.service.SetData;
import com.nucleus.service.Validation;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		RequestDispatcher rd=null;
		if(session.getAttribute("username")==null)
		{
			rd=request.getRequestDispatcher("Index.jsp");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		String role = null;
	    UserLogin userlogin=new UserLogin();
		Validation v=new Validation();
		SetData data=new SetData();
		
		
		String uname=request.getParameter("username");
		String pwd=request.getParameter("password");
		if(uname!=null && pwd!=null)
		{
		
		try 
		{
			
//			pojo.setUsername(uname);
//			pojo.setPassword(pwd);
			
			role= data.set(uname,pwd);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("role is "+role);
		
		if(role.equalsIgnoreCase("maker"))
		{
			session.setAttribute("username", uname);
			RequestDispatcher rd=request.getRequestDispatcher("Maker.jsp");
			rd.include(request, response);
		}
		else if(role.equalsIgnoreCase("checker"))
		{
			response.sendRedirect("Checker.jsp");
		}
		}
		else
		{
			RequestDispatcher rd2=request.getRequestDispatcher("Index.jsp");
			rd2.include(request, response);
		}
	}

}
