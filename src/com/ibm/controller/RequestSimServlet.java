package com.ibm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.beans.Login;

/**
 * Servlet implementation class RequestSimServlet
 */
public class RequestSimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestSimServlet() {
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
		
		Login usercred= (Login)request.getSession().getAttribute("UserCredentials");
		String ename=usercred.getEname();
		
		
		String[] upload_entry = request.getParameterValues("checkbox");
		String upload_entry_key = "";
		if (upload_entry != null) {
			upload_entry_key = upload_entry[0];
			for (int i = 1; i < upload_entry.length; i++) {
				upload_entry_key += "," + upload_entry[i];
			}
			System.out.println(upload_entry_key);
			
			String query="update sim_details1 set ";
		}
	}

}
