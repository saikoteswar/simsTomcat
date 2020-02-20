package com.ibm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.beans.Login;
import com.ibm.beans.Sim;
import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class ManagerPendingRequestsServlet
 */
public class ManagerPendingRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerPendingRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Login Usercred= (Login)request.getSession().getAttribute("UserCredentials");
		String ename=Usercred.getEname();
		String fname=Usercred.getFname();
		
		ArrayList<Sim> list=DAOFactory.loginValidateDAO.Pending_requests(ename, 1);
		
		request.getSession().setAttribute("manager_pending_list", list);
		System.out.println("list size is ::" +list.size());
		RequestDispatcher rd = request.getRequestDispatcher("ManagerPendingRequests.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
