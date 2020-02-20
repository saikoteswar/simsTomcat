package com.ibm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class EnableSim1Servlet
 */
public class EnableSim1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnableSim1Servlet() {
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
		int r=0;
		String[] disable = request.getParameterValues("checkbox[]");
		String disable_key = "";
		if (disable != null) {
			disable_key = disable[0];
			for (int i = 1; i < disable.length; i++) {
				disable_key += "," + disable[i];
			}
			System.out.println(disable_key);
			
			String query="update sim_details1 set status=1 where sim_id in("+disable_key+")  ";
			System.out.println("Servlet"+query);
			
			r=DAOFactory.loginValidateDAO.updatequery(query);
			if(r!=0){
				String msg="Requested Sims were enabled successfully";
				request.setAttribute("msg", msg);
				RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}
		}
	}

}
