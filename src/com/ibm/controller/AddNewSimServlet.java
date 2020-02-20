package com.ibm.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class AddNewSimServlet
 */
public class AddNewSimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewSimServlet() {
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
		String unbilled_amt="";
		String due_amt="";
		String hlr_id="-";
		String sim_number = request.getParameter("sim_num");
		String sim_type = request.getParameter("subscriber_type");
		String circle = request.getParameter("circle");
		String mobile_number=request.getParameter("mobile_number");
		String balance=request.getParameter("balance");
		if(balance.equals("")){
			balance="-";
		}
		hlr_id=request.getParameter("hlr_id");
		if(hlr_id.equals("")){
			hlr_id="-";
		}
		unbilled_amt=request.getParameter("unbilled_amt");
		if(unbilled_amt.equals("")){
			unbilled_amt="-";
		}
		due_amt=request.getParameter("due_amt");
		if(due_amt.equals("")){
			due_amt="-";
		}
		String current_day = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		String state = request.getParameter("state");
		String comment=request.getParameter("comment");
		System.out.println(state);
		int r=0;
		
		r=DAOFactory.loginValidateDAO.CreateNewSim(sim_number, sim_type, circle, mobile_number, balance, hlr_id, unbilled_amt, due_amt, current_day,state,comment);
		System.out.println();
		
		if(r!=0){
			String msg="New SIM created";
			request.setAttribute("msg", msg);
			RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}else{
			request.setAttribute("msg", "Enter details correctly");
			RequestDispatcher rd=request.getRequestDispatcher("AddNewSim.jsp");
			rd.forward(request, response);
		}
	}
}
