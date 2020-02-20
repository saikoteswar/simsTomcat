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
 * Servlet implementation class GenerateReportsServlet
 */
public class GenerateReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateReportsServlet() {
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
		
		
	String ename[]=request.getParameterValues("ename");
	String from=request.getParameter("from");
	String to=request.getParameter("to");
	String status[]=request.getParameterValues("status");
	
	String ename_key="";
	String status_key="";
	
	if (ename != null) {
		if (!ename[0].equalsIgnoreCase("All")) {
			for (int i = 1; i < ename.length; i++) {
				ename_key = ename[0] + ','
						+ ename[i];
				ename[0] = ename_key;
			}
			ename_key = ename[0].replace(",", "','");
			ename_key = " b.emp_name in ('"+ ename_key + "')";
			//System.out.println(ename_key);

		} else {
			ename_key=" b.emp_name in (select distinct emp_name from sim_requests1)";
			//System.out.println(ename_key);
		}
	} else{
		ename_key=" b.emp_name in (select distinct emp_name from sim_requests1)";
		//System.out.println(ename_key);
	}
	
	if (status != null) {
		if (!status[0].equalsIgnoreCase("All")) {
			for (int i = 1; i < status.length; i++) {
				status_key = status[0] + ','
						+ status[i];
				status[0] = status_key;
			}
			status_key = status[0].replace(",", "','");
			status_key = " and b.status in ('"+ status_key + "')";
			//System.out.println(status_key);

		} else {
			//status_key=" sim_type in (select distinct sim_type from sim_details1)";
			//System.out.println(status_key);
		}
	} else{
		//status_key=" sim_type in (select distinct sim_type from sim_details1)";
		////System.out.println(status_key);
	}
	
	String query="select distinct a.sim_number,a.mobile_number,b.emp_name,b.manager_name,b.applied_date,b.from_date,b.to_date,b.business_justification,b.status,b.sim_id,b.request_id from sim_details1 a,sim_requests1 b where "+ename_key+ " and (to_date(b.from_date,'mm/dd/yyyy') between (to_date('"+from+"','mm/dd/yyyy')) and (to_date('"+to+"','mm/dd/yyyy')) or to_date(b.to_date,'mm/dd/yyyy') between (to_date('"+from+"','mm/dd/yyyy')) and (to_date('"+to+"','mm/dd/yyyy')))"+status_key+" and a.sim_id=b.sim_id order by b.status";
	System.out.println("query is "+ query);
	request.getSession().setAttribute("query1", query);
	ArrayList<Sim> list=DAOFactory.loginValidateDAO.search_result_report(query);
	//System.out.println("size is :"+list.size());
	
	
	request.getSession().setAttribute("list", list);
	RequestDispatcher rd=request.getRequestDispatcher("Report.jsp");
	rd.forward(request, response);
	
	
	}

}
