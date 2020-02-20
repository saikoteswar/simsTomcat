package com.ibm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GlobalSimSearchServlet
 */
public class GlobalSimSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GlobalSimSearchServlet() {
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
		String sim_type[]=request.getParameterValues("type");
		String circle[]=request.getParameterValues("circle");
		String mobile_number=request.getParameter("mobile_number");
		String sim_number=request.getParameter("sim_num");
		String hlr_id=request.getParameter("hlr_id");
		String state[]=request.getParameterValues("state");
		String state_key="";
		
		String sim_type_key="";
		String circle_key="";
		
		
		
		
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
				sim_type_key=" sim_type in (select distinct sim_type from sim_details1)";
				//System.out.println(project_name_key);
			}
		} else{
			sim_type_key=" sim_type in (select distinct sim_type from sim_details1)";
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
				circle_key = "  and circle in ('"+ circle_key + "')";
				System.out.println(circle_key);

			} else {
				//System.out.println(application_name_key);
			}
		} else{
			//System.out.println(application_name_key);
		}
		if (state!= null) {
			if (!state[0].equalsIgnoreCase("All")) {
				for (int i = 1; i < state.length; i++) {
					state_key = state[0] + ','
							+ state[i];
					state[0] = state_key;
				}
				state_key = state[0].replace(",", "','");
				state_key = "  and state in ('"+ state_key + "')";
				System.out.println(state_key);

			} else {
				//System.out.println(application_name_key);
			}
		} else{
			//System.out.println(application_name_key);
		}
		
		String Keyword_key=" and sim_number like '%"+sim_number+"%' and  mobile_number like '%"+mobile_number+"%' and hlrid like '%"+hlr_id+"%'  ";
		
		
		String query=null;
		query="select * from sim_details1 where "+sim_type_key+circle_key+state_key+Keyword_key ;
		System.out.println(query);
		
		HttpSession s=request.getSession();
		s.setAttribute("query", query);
		

		RequestDispatcher rd=request.getRequestDispatcher("GlobalSimResult.jsp");
		rd.forward(request, response);
	}

}
