package com.ibm.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class RequestSimDetailsServlet
 */
public class RequestSimDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestSimDetailsServlet() {
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
		

		Login usercred = (Login) request.getSession().getAttribute(
				"UserCredentials");
		String ename = usercred.getEname();

		String[] update_rows = request.getParameterValues("checkbox");
		String update_entry_key = "";
		

		if (update_rows != null) {
			update_entry_key = update_rows[0];
			for (int i = 1; i < update_rows.length; i++) {
				update_entry_key += "," + update_rows[i];
			}
			System.out.println("rows length :: "+update_rows.length);
			request.getSession().setAttribute("length", update_rows.length);
			
			System.out.println(update_entry_key);
		}
		
		String query="select * from sim_details1 where sim_id in ("+update_entry_key+")";
		
		ArrayList<Sim> list = DAOFactory.loginValidateDAO.search_result(query);
		request.getSession().setAttribute("data", list);
		
		
		
		RequestDispatcher rd=request.getRequestDispatcher("RequestSimDetails1.jsp");
		rd.forward(request, response);
	}

}
