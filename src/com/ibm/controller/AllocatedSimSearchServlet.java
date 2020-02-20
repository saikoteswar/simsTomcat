package com.ibm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.beans.Sim;
import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class AllocatedSimSearchServlet
 */
public class AllocatedSimSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocatedSimSearchServlet() {
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
				sim_type_key = " and a.sim_type in ('"+ sim_type_key + "')";
				//System.out.println(project_name_key);

			} else {
				sim_type_key=" and a.sim_type in (select distinct a.sim_type from sim_details1)";
				//System.out.println(project_name_key);
			}
		} else{
			sim_type_key="and a.sim_type in (select distinct a.sim_type from sim_details1)";
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
		String Keyword_key=" and a.sim_number like '%"+sim_number+"%' and  a.mobile_number like '%"+mobile_number+"%' and a.hlrid like '%"+hlr_id+"%'  ";
		
		
		String query=null;
		//query="select * from sim_details1 where "+sim_type_key+circle_key+Keyword_key +" and allocated =1 and status=1  ";
		
		query="select distinct a.sim_id,a.sim_number ,a.sim_type,a.circle,a.mobile_number,a.balance,a.hlrid,a.unbilledamt,a.dueamt,a.added_date,b.request_id, b.emp_name,b.manager_name,b.from_date,b.to_date,a.state,a.comments from sim_details1 a,sim_requests1 b    where a.sim_id=b.sim_id and b.status=5 "+sim_type_key+circle_key+Keyword_key ;
		System.out.println(query);
		
		
		HttpSession s=request.getSession();
		s.setAttribute("AllocatedSearchquery", query);
		
		ArrayList<Sim> list = DAOFactory.loginValidateDAO.search_result_new(query);
		
		
		request.getSession().setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("ReturnResult.jsp");
		rd.forward(request, response);
	}

}
