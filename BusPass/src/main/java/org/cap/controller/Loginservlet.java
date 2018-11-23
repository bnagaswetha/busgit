package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.bean.LoginBean;
import org.cap.service.ILoginService;
import org.cap.service.LoginService;


@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("uname");
		String userPwd=request.getParameter("pwd");  
		LoginBean loginBean=new LoginBean(userName,userPwd);
		ILoginService loginservice=new LoginService();
		
		if(loginservice.isValidLogin(loginBean)) {
			response.sendRedirect("pages/adminportal.html");
		}else {
			
			
			PrintWriter pw=response.getWriter();
			pw.println("<h1>Enter valid username and password</h1>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		
			
		
		
		
		
		
		
	}

}
