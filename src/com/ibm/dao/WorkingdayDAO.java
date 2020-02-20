/*package com.ibm.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;

import com.ibm.beans.View;

public class WorkingdayDAO {
	public int Workingdays(String startdate, String enddate) {
		// Date stdt = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy"); mm =
		// minute
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		int workingDays = 0;
		try {
			// Date start = sdf.parse(startdate);
			Calendar start = Calendar.getInstance();
			start.setTime(sdf.parse(startdate));
			// Date end = sdf.parse(enddate);
			Calendar end = Calendar.getInstance();
			end.setTime(sdf.parse(enddate));

			while (!start.after(end))// removed ; (semi-colon)
			{
				// int day = start.getDay();
				int day = start.get(Calendar.DAY_OF_WEEK);
				// if ((day != Calendar.SATURDAY) || (day != Calendar.SUNDAY))
				// if it's sunday, != to Saturday is true
				if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY))
					workingDays++;
				// System.out.println(workingDays);//moved
				start.add(Calendar.DATE, 1);// removed comment tags
			}

			//System.out.println("working dao" + workingDays);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return workingDays;
	}

	public boolean inbetween(ArrayList<View> startdate,
			ArrayList<View> enddate, String event, String event2) {
		// Date stdt = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy"); mm =
		// minute
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		int workingDays = 0;
		Iterator<View> it = startdate.iterator();
		Iterator<View> it1 = enddate.iterator();
		boolean flag = true;

		while (it.hasNext() && it1.hasNext()) {

			try {
				// Date start = sdf.parse(startdate);

				Calendar start = Calendar.getInstance();
				start.setTime(sdf.parse(it.next().getFrom()));

				// Date end = sdf.parse(enddate);
				Calendar end = Calendar.getInstance();
				end.setTime(sdf.parse(it1.next().getTo()));

				Calendar nowfrom = Calendar.getInstance();
				nowfrom.setTime(sdf.parse(event));

				Calendar nowto = Calendar.getInstance();
				nowto.setTime(sdf.parse(event2));

				if (start.before(nowfrom) && end.after(nowfrom)
						|| start.equals(nowfrom) || end.equals(nowfrom)) {
					flag = false;
				}
				if (start.before(nowto) && end.after(nowto)
						|| start.equals(nowto) || end.equals(nowto)) {
					flag = false;
				}
				while (!start.after(end))// removed ; (semi-colon)
				{
					// int day = start.getDay();
					int day = start.get(Calendar.DAY_OF_WEEK);
					// if ((day != Calendar.SATURDAY) || (day !=
					// Calendar.SUNDAY))
					// if it's sunday, != to Saturday is true
					if ((day != Calendar.SATURDAY) && (day != Calendar.SUNDAY))
						workingDays++;
					// System.out.println(workingDays);//moved
					start.add(Calendar.DATE, 1);// removed comment tags
				}

				//System.out.println(workingDays);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return flag;
	}

	public int holiday(String startdate, String enddate, ArrayList<View> data) {
		// Date stdt = new Date();
		// SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy"); mm =
		// minute
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		int num = 0;

		Iterator<View> it = data.iterator();
		while (it.hasNext()) {
			try {
				// Date start = sdf.parse(startdate);
				Calendar start = Calendar.getInstance();
				start.setTime(sdf.parse(startdate));
				// Date end = sdf.parse(enddate);
				Calendar end = Calendar.getInstance();
				end.setTime(sdf.parse(enddate));

				Calendar holidaydate = Calendar.getInstance();
				holidaydate.setTime(sdf.parse(it.next().getHdate()));

				while (!holidaydate.after(end) && !holidaydate.before(start)) {
					if (holidaydate.equals(start)) {
						num++;
					}

					start.add(Calendar.DATE, 1);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//System.out.println("holidays" + num);
		return num;
	}

	public boolean exportData(String query1) throws Exception {

		ArrayList<View> details = new ArrayList<View>();

		int numberOfColumns = 0;
		ResultSetMetaData rsmd;
		Label lbl;
		Iterator itr;
		Connection connection = null;
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "sai";
		String password = "ideatest_lms";
		Statement st = null;
		ResultSet rs = null;
		String query = query1;

		try {

			Class.forName(driverName);
			connection = DriverManager.getConnection(url, userName, password);
			st = connection.createStatement();
			rs = st.executeQuery(query);
			rsmd = rs.getMetaData();
			numberOfColumns = rsmd.getColumnCount();

			// Read and store data in list variable.
			while (rs.next()) {

				View obj = new View();
				obj.setEname(rs.getString(1));
				obj.setFname(rs.getString(2));
				obj.setTypeof(rs.getString(3));
				obj.setFrom(rs.getString(4));
				obj.setTo(rs.getString(5));
				obj.setReason(rs.getString(6));
				obj.setStatus(rs.getInt(7));
				obj.setDays(rs.getLong(8));
				obj.setLid(rs.getInt(9));
				details.add(obj);
			}

			// Excel file properties
			File file = new File("c:/data.xls");
			if (!file.exists()) {
				file.createNewFile();
			}
			WorkbookSettings wbSettings = new WorkbookSettings();

			wbSettings.setLocale(new Locale("en", "EN"));
			WritableWorkbook w = Workbook.createWorkbook(file, wbSettings);
			w.createSheet("Table Data", 0);
			WritableSheet s = w.getSheet(0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD);
			WritableCellFormat cf = new WritableCellFormat(wf);
			cf.setWrap(true);

			itr = details.iterator();
			// Write column header
			int col = 0;
			for (int j = 1; j <= numberOfColumns; j++) {
				lbl = new Label(col, 0, rsmd.getColumnName(j), cf);
				s.addCell(lbl);
				col++;
			}
			// Write content
			int row = 1;
			while (itr.hasNext()) {
				for (int column = 0; column < numberOfColumns; column++) {
					lbl = new Label(column, row, (String) itr.next(), cf);
					s.addCell(lbl);
				}
				row++;
			}
			w.write();
			w.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
		      //finally block used to close resources
		      try{
		         if(st!=null)
		            st.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(connection!=null)
		            connection.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }

		return true;
	}

	public String  Generate_Report(String query1,String timeStamp) {
		String path=null;

		Connection connection = null;
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "sai";
		String password = "koteswar";
		Statement st = null;
		ResultSet rs = null;
		String query = query1;
		
		try {

			Class.forName(driverName);
			connection = DriverManager.getConnection(url, userName, password);
			st = connection.createStatement();
			rs = st.executeQuery(query);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Report");
			HSSFRow rowhead = sheet.createRow((short) 0);
			rowhead.createCell((short) 0).setCellValue("Employee Name");
			rowhead.createCell((short) 1).setCellValue("Manager Name");
			rowhead.createCell((short) 2).setCellValue("Type of leave");
			rowhead.createCell((short) 3).setCellValue("From Date ");
			rowhead.createCell((short) 4).setCellValue("To date ");
			rowhead.createCell((short) 5).setCellValue("Number of days ");

			int index = 1;
			while (rs.next()) {

				HSSFRow row = sheet.createRow((short) index);
				row.createCell((short) 0).setCellValue(rs.getString(1));
				row.createCell((short) 1).setCellValue(rs.getString(2));
				row.createCell((short) 2).setCellValue(rs.getString(3));
				row.createCell((short) 3).setCellValue(rs.getString(4));
				row.createCell((short) 4).setCellValue(rs.getString(5));
				row.createCell((short) 5).setCellValue(rs.getLong(8));
				index++;
			}
			FileOutputStream fileOut = new FileOutputStream("c:\\"+timeStamp+"excelFile1.xls");
			path="c:\\"+timeStamp+"excelFile1.xls";
			wb.write(fileOut);
			fileOut.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		      //finally block used to close resources
		      try{
		         if(st!=null)
		            st.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(connection!=null)
		            connection.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }

		return path;

	}
	
	public String get_min_date(){
		
	
		String min_date = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		System.out.println(min_date);
		min_date=min_date.replace((min_date.substring(2, 6)),"/01/");
		
		
		return min_date;
		
	}
		


		
			public String get_current_day(){
		String current_day = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		return current_day;
	}

}
*/