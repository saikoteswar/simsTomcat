package com.ibm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.beans.Login;
import com.ibm.beans.Sim;
import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class EmploginServlet
 */
public class EmploginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmploginServlet() {
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
		
		
		String username = request.getParameter("userid").toLowerCase();
		String password = request.getParameter("pwd").trim();
		RequestDispatcher rd = null;
		Login usercred = null;
		
		
		usercred = DAOFactory.loginValidateDAO.UserCredentials(username,
				password);
		
		//System.out.println(usercred.getFirst_name() + usercred.getUsername()
				//+ usercred.getRole());

		HttpSession s= request.getSession();
		s.setAttribute("UserCredentials", usercred);
		s.setMaxInactiveInterval(30);
		

		if (usercred.getUsername() == null) {
			request.setAttribute("msg",
					"Invalid Credentials.Please login again");
			rd = request.getRequestDispatcher("login5.jsp");
			rd.forward(request, response);

		} else {
			
			String query="select distinct return_flag from sim_requests1 where emp_name='"+usercred.getEname()+"'";
			
			ArrayList<Sim> list=DAOFactory.loginValidateDAO.get_return_login(query);
			
			Iterator<Sim> it = list.iterator();
			while (it.hasNext()) {
				Sim obj5 = it.next();
				int ret=obj5.getReturn_flag();
				System.out.println("int is "+ret);
				
				if (ret==1){
					
					request.setAttribute("msg","Please return the sim to login");
					rd = request.getRequestDispatcher("login5.jsp");
					rd.forward(request, response);
				}
				
				
				
				
			}
			
			//request.setAttribute("msg","Welcome to SIMS");
			rd = request.getRequestDispatcher("main.html");
			rd.forward(request, response);
		}
	}

}
