package com.ibm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class AdminActionServlet
 */
public class AdminActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminActionServlet() {
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

		String button = request.getParameter("Submit");
		String query="";
		System.out.println("button value is ::" + button);

		if (button.equalsIgnoreCase("Approve")) {

			String[] update_rows = request.getParameterValues("checkbox");
			String update_entry_key = "";
			if (update_rows != null) {
				update_entry_key = update_rows[0];
				for (int i = 1; i < update_rows.length; i++) {
					update_entry_key += "," + update_rows[i];

				}
				System.out.println("rows length :: " + update_rows.length);

				// request.getSession().setAttribute("length",
				// update_rows.length);

				System.out.println(update_entry_key);
				query = "update sim_requests1 set status=5 where request_id in ("
						+ update_entry_key + ")";
				System.out.println(query);
				DAOFactory.loginValidateDAO.updatequery(query);
				request.setAttribute("msg", "Requests accepted successfully");
				RequestDispatcher rd =request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}

		} else {
			String[] update_rows = request.getParameterValues("checkbox");
			String update_entry_key = "";
			if (update_rows != null) {
				update_entry_key = update_rows[0];
				for (int i = 1; i < update_rows.length; i++) {
					update_entry_key += "," + update_rows[i];

				}
				System.out.println("rows length :: " + update_rows.length);

				// request.getSession().setAttribute("length",
				// update_rows.length);

				System.out.println(update_entry_key);
				query = "update sim_requests1 set status=4 where request_id in ("+ update_entry_key + ")";
				System.out.println(query);
				DAOFactory.loginValidateDAO.updatequery(query);
				String query1="update sim_details1 set allocated=0 where sim_id in (select distinct(sim_id) from sim_requests1 where request_id in("+update_entry_key+"))";
				System.out.println("query1 is ::"+query1 );
				DAOFactory.loginValidateDAO.updatequery(query1);
				request.setAttribute("msg", "Requests rejected successfully");
				RequestDispatcher rd =request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			
			}
		}
		System.out.println("final query is :: "+query);

	}

}
