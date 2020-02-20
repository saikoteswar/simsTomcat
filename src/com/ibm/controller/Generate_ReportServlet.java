package com.ibm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ibm.factory.DAOFactory;

/**
 * Servlet implementation class Generate_ReportServlet
 */
public class Generate_ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "Search Audit";
	private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generate_ReportServlet() {
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
		String submit=request.getParameter("Submit");
		if(submit.equalsIgnoreCase("Generate")){

		String filePath = null;

		String timeStamp = new SimpleDateFormat("dd-MMM-yy_HH-mm-ss")
				.format(Calendar.getInstance().getTime());
		// configures some settings

		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(REQUEST_SIZE);

		// constructs the directory path to store upload file
		String uploadPath = "C:\\" + UPLOAD_DIRECTORY;
		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		String query = (String) request.getSession().getAttribute("query1");
		//System.out.println("Genereate Servlet ");
		
		filePath = DAOFactory.loginValidateDAO.Generate_Report(query, timeStamp);

		//System.out.println(filePath);
		File fo = null;

		try {

			fo = new File(filePath);
		} catch (Exception e) {
			System.out.println("Error occured while creating the file"
					+ e.getMessage());
		}
		OutputStream outStream = response.getOutputStream();

		FileInputStream instream = new FileInputStream(fo);
		response.setContentType("application/xls");
		response.setHeader("Content-disposition", "attachment; filename=\""
				+ fo.getName() + "\"");
		byte[] buffer = new byte[1024];
		while (true) {
			int bytes = instream.read(buffer);
			if (bytes <= 0) {
				break;
			}
			outStream.write(buffer, 0, bytes);
		}
		instream.close();
		outStream.flush();
		outStream.close();
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("GenerateReports.jsp");
			rd.forward(request, response);
			
		}
	}

}
