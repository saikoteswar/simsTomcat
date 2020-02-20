package com.ibm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.beans.Login;

/**
 * Servlet implementation class StatusServlet
 */
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
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
		Login UserCredentials = (Login) request.getSession().getAttribute("UserCredentials");
		String a = UserCredentials.getEname();

		String sim_type[]=request.getParameterValues("type");
		String circle[]=request.getParameterValues("circle");
		String mobile_number=request.getParameter("mobile_number");
		String sim_number=request.getParameter("sim_num");
		//String hlr_id=request.getParameter("hlr_id");
		String status[]=request.getParameterValues("status");
		
		String sim_type_key="";
		String circle_key="";
		String status_key="";
		
		
		if (sim_type != null) {
			if (!sim_type[0].equalsIgnoreCase("All")) {
				for (int i = 1; i < sim_type.length; i++) {
					sim_type_key = sim_type[0] + ','
							+ sim_type[i];
					sim_type[0] = sim_type_key;
				}
				sim_type_key = sim_type[0].replace(",", "','");
				sim_type_key = " sim_type in ('"+ sim_type_key + "')";
				//System.out.println(project_name_key);

			} else {
				sim_type_key=" a.sim_type in (select distinct sim_type from sim_details1)";
				//System.out.println(project_name_key);
			}
		} else{
			sim_type_key=" a.sim_type in (select distinct sim_type from sim_details1)";
			//System.out.println(project_name_key);
		}
		
		
		if (circle!= null) {
			if (!circle[0].equalsIgnoreCase("All")) {
				for (int i = 1; i < circle.length; i++) {
					circle_key = circle[0] + ','
							+ circle[i];
					circle[0] = circle_key;
				}
				circle_key = circle[0].replace(",", "','");
				circle_key = "  and a.circle in ('"+ circle_key + "')";
				System.out.println(circle_key);

			} else {
				//System.out.println(application_name_key);
			}
		} else{
			//System.out.println(application_name_key);
		}
		if (status!= null) {
			if (!status[0].equalsIgnoreCase("All")) {
				for (int i = 1; i < status.length; i++) {
					status_key = status[0] + ','
							+ status[i];
					status[0] = status_key;
				}
				status_key = status[0].replace(",", "','");
				status_key = "  and b.status in ('"+ status_key + "')";
				System.out.println(status_key);

			} else {
				//System.out.println(application_name_key);
			}
		} else{
			//System.out.println(application_name_key);
		}
		
		String Keyword_key=" and a.sim_number like '%"+sim_number+"%' and  a.mobile_number like '%"+mobile_number+"%' and a.sim_id=b.sim_id and b.emp_name in ('"+a+"') order by b.status" ;
		
		
		String query=null;
		query="select distinct a.sim_number,a.sim_type,a.circle,a.mobile_number,a.balance,a.unbilledamt,a.dueamt,b.applied_date,b.status,a.comments,b.business_justification from sim_details1 a,sim_requests1 b where "+sim_type_key+circle_key+status_key+Keyword_key ;
		System.out.println(query);
		
		HttpSession s=request.getSession();
		s.setAttribute("query", query);
		

		RequestDispatcher rd=request.getRequestDispatcher("StatusResult.jsp");
		rd.forward(request, response);
		
	}

}
