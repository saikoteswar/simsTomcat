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
 * Servlet implementation class ReturnSim2Servlet
 */
public class ReturnSim2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnSim2Servlet() {
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
		
		int r = 0;
		String submitted_date="";
		String balance="";
		String unbilled_amt="";
		String due_amt="";
		String state="";
		int sim_id=0;
		String comment="";
		
			String disable_key=(String)request.getSession().getAttribute("selected_request_id");
			int length=(Integer)request.getSession().getAttribute("disable_length");
			
			
			for(int i=1;i<length+1;i++){
				 submitted_date=request.getParameter("submitted_date"+i);
				
				 balance=request.getParameter("balance"+i);
				 unbilled_amt=request.getParameter("unbilled_amt"+i);
				 due_amt=request.getParameter("due_amt"+i);
				 state=request.getParameter("state"+i);
				 comment=request.getParameter("comment"+i);
				 
				sim_id=Integer.parseInt(request.getParameter("sim_number"+i));
				System.out.println(submitted_date+" | "+balance+" | "+unbilled_amt+" | "+due_amt+" | "+state+" | "+comment+" | "+sim_id);
				
				ArrayList<Sim> list=new ArrayList<Sim>();
				Sim  obj=new Sim();
				obj.setSubmitted_date(submitted_date);
				obj.setBalance(balance);
				obj.setUnbilled_amt(unbilled_amt);
				obj.setDue_amt(due_amt);
				obj.setState(state);
				obj.setSim_id(sim_id);
				obj.setComment(comment);
				list.add(obj);

				DAOFactory.loginValidateDAO.return_sim_update(list);
				//System.out.println(submitted_date+""+sim_number);
				String query1 ="update sim_requests1 set  status=6   where request_id in("
					+ disable_key + ")  ";
				 r= DAOFactory.loginValidateDAO.updatequery2(query1);

				String query2="update sim_details1 set allocated=0 where sim_id in (select distinct(sim_id) from sim_requests1 where request_id in("+disable_key+"))";
				 DAOFactory.loginValidateDAO.updatequery2(query2);
				 
				 String query3="update sim_requests1 set return_flag=0 where request_id in ("+disable_key+")";
				 DAOFactory.loginValidateDAO.updatequery2(query3);
				 
				 
				 
				 
				}
				  
				 if (r != 0) {
					String msg = "Requested Sims were returned successfully";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request
							.getRequestDispatcher("welcome.jsp");
					rd.forward(request, response);
				}
				
				
			
			
			
/*
			String query1 = "update sim_details1 set  allocated=0   where sim_id in(select distinct sim_id from sim_requests1 where request_id in("
					+ disable_key + "))  ";
			System.out.println("Servlet" + query1);
		
			String query2 = "update sim_details1 set  owner='Admin'   where sim_id in(select distinct sim_id from sim_requests1 where request_id in("
				+ disable_key + "))  ";*/
			
			/*

			r = DAOFactory.loginValidateDAO.updatequery2(query1);
			int r1= DAOFactory.loginValidateDAO.updatequery2(query2);
			 int r2= DAOFactory.loginValidateDAO.updatequery2(query3);
			if (r != 0) {
				String msg = "Requested Sims were returned successfully";
				request.setAttribute("msg", msg);
				RequestDispatcher rd = request
						.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			}*/
		}

	}

