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
 * Servlet implementation class RequestSim1
 */
public class RequestSim1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestSim1() {
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
			RequestDispatcher rd = request.getRequestDispatcher("RequestSimDetails.jsp");
			rd.forward(request, response);
		}
		else if(button.equalsIgnoreCase("Request")){
		
		Login usercred = null;
		usercred=(Login)request.getSession().getAttribute("UserCredentials");
		
		String ename=usercred.getEname();
		String fname=usercred.getFname();
		
		int length=(Integer)request.getSession().getAttribute("length");
		int sim_id=0;
		String from_date="";
		String to_date="";
		String business_justification="";
		int status=1;
		if (usercred.getRole().equalsIgnoreCase("manager")){
			status=3;
			
		}
		if (usercred.getRole().equalsIgnoreCase("Admin")){
			status=5;
			
		}
		
		
		
		
		for(int i=1;i<length+1;i++){
			
			from_date=request.getParameter("from_date"+i);
			to_date=request.getParameter("to_date"+i);
			business_justification=request.getParameter("business_justification"+i);

			sim_id=Integer.parseInt(request.getParameter("sim_number"+i));
			
			System.out.println("number"+from_date+":"+to_date+":"+business_justification+":"+sim_id);
			ArrayList<Sim> list=new ArrayList<Sim>();
			Sim  obj=new Sim();
			obj.setFrom_date(from_date);
			obj.setTo_date(to_date);
			obj.setBusiness_justification(business_justification);
			obj.setSim_id(sim_id);
			list.add(obj);
			
		DAOFactory.loginValidateDAO.request_sim(list,ename,fname,status);	
		
		}
		
		request.setAttribute("msg", "Sim Request raised successfully");
		RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
	}
	}
}