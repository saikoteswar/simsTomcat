package com.ibm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.factory.DAOFactory;



/**
 * Servlet implementation class CreateNewUserServlet
 */
public class CreateNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ename=request.getParameter("ename");
		String uname=request.getParameter("uname");
		String fname=request.getParameter("fname");
		String pwd=request.getParameter("pwd");
		String role=request.getParameter("role");
		int r=0;
		System.out.println(ename+""+uname+""+fname+""+pwd+""+role);
		
		r=DAOFactory.loginValidateDAO.CreateNewUser(ename, fname, uname, pwd, role);
		
		
		if(r!=0){
		
		String msg="New user created";
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
		}else{
			request.setAttribute("msg", "Enter details correctly");
			RequestDispatcher rd=request.getRequestDispatcher("CreateNewUser.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
