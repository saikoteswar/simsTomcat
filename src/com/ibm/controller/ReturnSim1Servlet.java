package com.ibm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.beans.Sim;
import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class ReturnSim1Servlet
 */
public class ReturnSim1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReturnSim1Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int r = 0;
		String[] disable = request.getParameterValues("checkbox[]");
		String disable_key = "";
		if (disable != null) {
			disable_key = disable[0];
			for (int i = 1; i < disable.length; i++) {
				disable_key += "," + disable[i];
			}

			HttpSession s1=request.getSession();
			s1.setAttribute("selected_request_id", disable_key);
			
			HttpSession s2=request.getSession();
			s2.setAttribute("disable_length", disable.length);
		
			
			//System.out.println(disable_key);
			
			String query=(String)request.getSession().getAttribute("AllocatedSearchquery");
			//System.out.println("old ::"+query);
			String query1="";
			
			query1=query+" and   b.request_id in("+disable_key+")";
			System.out.println("new ::"+query1);

			HttpSession s=request.getSession();
			s.setAttribute("query1", query1);
			
			
			ArrayList<Sim> list = DAOFactory.loginValidateDAO.search_result_new(query1);
			
			request.setAttribute("data", list);
			
			System.out.println("size :: "+list.size());
			RequestDispatcher rd=request.getRequestDispatcher("ReturnResult2.jsp");
			rd.forward(request, response);
			
		}

	}
}
