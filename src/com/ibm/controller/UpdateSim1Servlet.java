package com.ibm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.beans.Sim;
import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class UpdateSim1Servlet
 */
public class UpdateSim1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSim1Servlet() {
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
		
		String button=request.getParameter("Submit");
		if(button.equalsIgnoreCase("Back")){
			
			RequestDispatcher rd=request.getRequestDispatcher("UpdateSimDetails.jsp");
			rd.forward(request, response);
			
		}else if (button.equalsIgnoreCase("Update"))
		{
	
		int length=(Integer)request.getSession().getAttribute("length");
		String mobile_number="";
		String sim_number="";
		String balance="";
		int sim_id=0;
		String hlr_id="";
		String unbilled_amt="";
		String due_amt="";
		String state="";
		String comment="";
		
		
		
		for(int i=1;i<length+1;i++){
			mobile_number=request.getParameter("mobile_number"+i);
			balance=request.getParameter("balance"+i);
			hlr_id=request.getParameter("hlr_id"+i);
			sim_id=Integer.parseInt(request.getParameter("sim_number"+i));
			unbilled_amt=request.getParameter("unbilled_amt"+i);
			due_amt=request.getParameter("due_amt"+i);
			state=request.getParameter("state"+i);
			comment=request.getParameter("comment"+i);
			
			System.out.println("number"+mobile_number+":"+balance+":"+hlr_id+":"+sim_id);
			ArrayList<Sim> list=new ArrayList<Sim>();
			Sim  obj=new Sim();
			obj.setMobile_number(mobile_number);
			obj.setHlr_id(hlr_id);
			obj.setBalance(balance);
			obj.setSim_id(sim_id);
			obj.setUnbilled_amt(unbilled_amt);
			obj.setDue_amt(due_amt);
			obj.setState(state);
			obj.setComment(comment);
			list.add(obj);
			
		DAOFactory.loginValidateDAO.update_sim(list);	
		}
		request.setAttribute("msg", "Details updated successfully");
		RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
	}

}
}