package com.ibm.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.beans.Sim;
import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class NotifyServlet
 */
public class NotifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NotifyServlet() {
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
		String notify=request.getParameter("notify"); 
		notify=notify.substring(6,7);
		System.out.println("notify is ::"+notify);
		
		int i=Integer.parseInt(notify);
		String employee_name = request.getParameter("employee_name"+i);
		String manager_name = request.getParameter("manager_name"+i);
		String type = request.getParameter("type"+i);
		String circle = request.getParameter("circle"+i);
		String from_date = request.getParameter("from_date"+i);
		String to_date = request.getParameter("to_date"+i);
		String sim_number = request.getParameter("sim_number"+i);
		String mobile_number=request.getParameter("mobile_number"+i);
		String parsed_from_date = "";
		String parsed_to_date = "";
		
		
		int request_id=Integer.parseInt(request.getParameter("request_id"+i));
		int return_flag=Integer.parseInt(request.getParameter("return_flag"+i));
		System.out.println("int is"+request_id );
		
		if(return_flag==0){
		String query3="update sim_requests1 set return_flag=1 where request_id in ("+request_id+")";
		DAOFactory.loginValidateDAO.updatequery2(query3);
		}else if(return_flag==1){
			request.setAttribute("msg", "User is already blocked");
			RequestDispatcher rd=request.getRequestDispatcher("AssignedResult1.jsp");
			rd.forward(request, response);
			
		}
		
		String query=(String)request.getSession().getAttribute("AllocatedSearchquery");
		
		ArrayList<Sim> list = DAOFactory.loginValidateDAO.assigned_sim_search(query);
		request.getSession().setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("AssignedResult1.jsp");
		rd.forward(request, response);
		
		/* 
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			Calendar date1 = Calendar.getInstance();
			date1.setTime(sdf.parse(from_date));
			
			Calendar date2 = Calendar.getInstance();
			date2.setTime(sdf.parse(to_date));
			
			parsed_from_date = new SimpleDateFormat("dd-MMM-yyyy").format(date1.getTime());
			parsed_to_date=new SimpleDateFormat("dd-MMM-yyyy").format(date2.getTime());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(employee_name + " " + manager_name + " " + type + " " + circle + " " + parsed_from_date + " " + parsed_to_date + " "	+ sim_number + " "+mobile_number);

		String mail = "mailto:"	+ employee_name	+ "?subject=SIMS%20Notification-Please return the Sim allocated to you&amp;cc="	+ manager_name+ "&amp;body=Hi "+employee_name+",%09%0D%0A%09%0D%0A               Sim Number                     :"+sim_number+"%09%0D%0A               Mobile Number               :"+mobile_number+"%09%0D%0A               Sim Allocated Date       :"+parsed_from_date+"%09%0D%0A               Expected Return Date  :"+parsed_to_date+"%09%0D%0A";
		request.setAttribute("mail", mail);
		RequestDispatcher rd = request.getRequestDispatcher("notify.jsp");
		rd.forward(request, response);*/

		
		
		

		
	}

}
