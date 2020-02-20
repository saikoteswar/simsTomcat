package com.ibm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.beans.Login;
import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class ChangePasswordServlet
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
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
		Login obj = (Login) request.getSession()
				.getAttribute("UserCredentials");
		int r = 0;
		
		
		String username = obj.getUsername();
		String oldpwd = DAOFactory.loginValidateDAO.getPassword(username);
		String pwd = request.getParameter("opwd");
		String newpwd = request.getParameter("npwd");
		String confirmpwd = request.getParameter("cpwd");

		if (pwd.length() != 0) {
			if (newpwd.length() != 0) {
				if (confirmpwd.length() != 0) {

					if (oldpwd.equals(pwd) && newpwd.equals(confirmpwd)) {
						r = DAOFactory.loginValidateDAO.changepassword(
								username, confirmpwd);

						if (r != 0) {
							RequestDispatcher rd = null;
							request.setAttribute("msg", "Password Updated");
							rd = request.getRequestDispatcher("welcome.jsp");
							rd.forward(request, response);
						}

					} else if (!oldpwd.equals(pwd)) {
						RequestDispatcher rd = null;
						request.setAttribute("msg",
								"The  old  password given is incorrect");
						rd = request.getRequestDispatcher("ChangePassword.jsp");
						rd.forward(request, response);
					} else if (!newpwd.equals(confirmpwd)) {
						RequestDispatcher rd = null;
						request.setAttribute("msg",
								"The  new passwords given do not match");
						rd = request.getRequestDispatcher("ChangePassword.jsp");
						rd.forward(request, response);
					}
				} else {
					RequestDispatcher rd = null;
					request.setAttribute("msg", "Confirm new password");
					rd = request.getRequestDispatcher("ChangePassword.jsp");
					rd.forward(request, response);

				}
			} else {
				RequestDispatcher rd = null;
				request.setAttribute("msg", "Enter new password");
				rd = request.getRequestDispatcher("ChangePassword.jsp");
				rd.forward(request, response);

			}

		} else {
			RequestDispatcher rd = null;
			request.setAttribute("msg", "Enter old password");
			rd = request.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request, response);
		}
	}

}
