package com.ibm.dao;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Calendar;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ibm.beans.Login;
import com.ibm.beans.Sim;
import com.ibm.factory.DAOFactory;
import com.ibm.utility.DatabaseConnectionUtility;

public class LoginValidateDAO {
	public Login UserCredentials(String userId, String pwd) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Login obj = new Login();
		String query = "select * from employee where lower(username)=? and password=? and  flag=1";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, userId);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			while (rs.next()) {
				obj.setEname(rs.getString(1));
				obj.setFname(rs.getString(2));
				obj.setUsername(rs.getString(3));
				obj.setPassword(rs.getString(4));
				obj.setFlag(rs.getInt(5));
				obj.setRole(rs.getString(6));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return obj;
	}
	
	public String getUsername(String emp_name) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Login obj = new Login();
		String query = "select username from employee where ename=?";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, emp_name);
			
			rs = pst.executeQuery();
			while (rs.next()) {
				obj.setUsername(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		System.out.println("new username is ::"+obj.getUsername());
		
		return obj.getUsername();
		
	}
	
	public String getPassword(String username) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Login obj = new Login();
		String query = "select password from employee where username=?";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, username);
			
			rs = pst.executeQuery();
			while (rs.next()) {
				obj.setPassword(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		System.out.println("new password is ::"+obj.getPassword());
		
		return obj.getPassword();
		
	}
	
	

	public ArrayList<Login> getManagers() {
		ArrayList<Login> data = new ArrayList<Login>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = " SELECT DISTINCT ename FROM employee WHERE flag=1 and( role='Manager' or role='Admin') order by ename desc ";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				// System.out.println("Got results:"+rs.getString(3));
				// System.out.println(rs.getInt(4));
				Login obj = new Login();
				obj.setUsername(rs.getString(1));
				data.add(obj);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return data;
	}
	public ArrayList<Login> deactivate_users() {
		ArrayList<Login> data = new ArrayList<Login>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = "  select distinct ename from employee where role not like 'Admin'  and flag=1 order by ename  ";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				// System.out.println("Got results:"+rs.getString(3));
				// System.out.println(rs.getInt(4));
				Login obj = new Login();
				obj.setEname(rs.getString(1));
				data.add(obj);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return data;
	}
	
	
	
	public ArrayList<Login> reactivate_users() {
		ArrayList<Login> data = new ArrayList<Login>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = "  select distinct ename from employee where role not like 'Admin'  and flag=0 order by ename   ";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				// System.out.println("Got results:"+rs.getString(3));
				// System.out.println(rs.getInt(4));
				Login obj = new Login();
				obj.setEname(rs.getString(1));
				data.add(obj);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return data;
	}
	
	
	public ArrayList<Login> get_distinct_Employees() {
		ArrayList<Login> data = new ArrayList<Login>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = " select distinct ename from employee where  flag=1 order by ename   ";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				// System.out.println("Got results:"+rs.getString(3));
				// System.out.println(rs.getInt(4));
				Login obj = new Login();
				obj.setEname(rs.getString(1));
				data.add(obj);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return data;
	}
	
	

	public int CreateNewUser(String ename, String fname, String username,
			String password, String role) {
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		String query = "insert into employee values(?,?,?,?,1,?,emp_id.nextval)";
		System.out.println(query);
		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, ename);
			pst.setString(2, fname);
			pst.setString(3, username);
			pst.setString(4, password);
			pst.setString(5, role);
			r = pst.executeUpdate();
			System.out.println("value of r is " + r);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return r;

	}

	public int changepassword(String username, String password) {
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		String query = "update employee set password=?  where username=?";

		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, password);
			pst.setString(2, username);
			r = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return r;

	}

	public int CreateNewSim(String sim_number, String sim_type, String circle,
			String mobile_number, String balance, String hlrid,
			String unbilledamt, String dueamt, String added_date, String state,String comment) {
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		String query = "insert into sim_details1 values(sim_id.nextval,?,?,?,?,?,?,?,?,'Admin',?,'','',?,0,1,?,?)";
		System.out.println(query);
		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, sim_number);
			pst.setString(2, sim_type);
			pst.setString(3, circle);
			pst.setString(4, mobile_number);
			pst.setString(5, balance);
			pst.setString(6, hlrid);
			pst.setString(7, unbilledamt);
			pst.setString(8, dueamt);
			pst.setString(9, added_date);
			pst.setString(10, added_date);
			pst.setString(11, state);
			pst.setString(12, comment);

			r = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return r;

	}

	public ArrayList<Sim> search_result(String query1) {
		ArrayList<Sim> data = new ArrayList<Sim>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = query1;
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				{

					Sim obj = new Sim();
					obj.setSim_id(rs.getInt(1));
					obj.setSim_number(rs.getString(2));
					obj.setType(rs.getString(3));
					obj.setCircle(rs.getString(4));
					obj.setMobile_number(rs.getString(5));
					obj.setBalance(rs.getString(6));
					obj.setHlr_id(rs.getString(7));
					obj.setUnbilled_amt(rs.getString(8));
					obj.setDue_amt(rs.getString(9));
					obj.setOwner(rs.getString(10));
					obj.setAdded_date(rs.getString(11));
					obj.setAllocated_date(rs.getString(12));
					obj.setExp_return_date(rs.getString(13));
					obj.setSubmitted_date(rs.getString(14));
					obj.setAllocated(rs.getInt(15));
					obj.setStatus(rs.getInt(16));
					obj.setState(rs.getString(17));
					obj.setComment(rs.getString(18));
					data.add(obj);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;

	}

	public ArrayList<Sim> search_result_new(String query1) {
		ArrayList<Sim> data = new ArrayList<Sim>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = query1;
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				{

					Sim obj = new Sim();
					obj.setSim_id(rs.getInt(1));
					obj.setSim_number(rs.getString(2));
					obj.setType(rs.getString(3));
					obj.setCircle(rs.getString(4));
					obj.setMobile_number(rs.getString(5));
					obj.setBalance(rs.getString(6));
					obj.setHlr_id(rs.getString(7));
					obj.setUnbilled_amt(rs.getString(8));
					obj.setDue_amt(rs.getString(9));
					// obj.setOwner(rs.getString(10));
					obj.setAdded_date(rs.getString(10));
					obj.setRequest_id(rs.getInt(11));
					obj.setEmp_name(rs.getString(12));
					obj.setManager_name(rs.getString(13));
					obj.setFrom_date(rs.getString(14));
					obj.setTo_date(rs.getString(15));
					obj.setState(rs.getString(16));
					obj.setComment(rs.getString(17));
					// obj.setAllocated_date(rs.getString(12));
					// obj.setExp_return_date(rs.getString(13));
					// obj.setSubmitted_date(rs.getString(14));
					// obj.setAllocated(rs.getInt(15));
					// obj.setStatus(rs.getInt(16));
					data.add(obj);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;

	}

	public int updatequery(String query1) {
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		String query = query1;
		System.out.println(query1);

		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			r = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return r;

	}

	public int updatequery2(String query1) {
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		String query = query1;
		System.out.println(query1);

		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			r = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return r;

	}

	public int update_sim(ArrayList<Sim> list) {
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();

			for (int index = 0; index < list.size(); index++) {
				String mobilenumber = list.get(index).getMobile_number();
				String hlrId = list.get(index).getHlr_id();
				int SimId = list.get(index).getSim_id();
				String balance = list.get(index).getBalance();
				String unbilled_amt = list.get(index).getUnbilled_amt();
				String due_amt = list.get(index).getDue_amt();
				String state=list.get(index).getState();
				String comment=list.get(index).getComment();
				String query = "update sim_details1 set mobile_number='"
						+ mobilenumber + "',hlrid='" + hlrId + "',balance='"
						+ balance + "' ,unbilledamt='" + unbilled_amt
						+ "' , dueamt='" + due_amt + "',state='"+state+"' , comments='"+comment+"' where sim_id=" + SimId;
				System.out.println("query is ::" + query);
				try {
					pst = con.prepareStatement(query);
				} catch (Exception e) {
					System.out
							.println("Exception occurred while updating the sim details "
									+ e.getMessage());
				}
				r = pst.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return r;

	}

	public int return_sim_update(ArrayList<Sim> list) {
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();

			for (int index = 0; index < list.size(); index++) {
				int SimId = list.get(index).getSim_id();
				String submitted_date = list.get(index).getSubmitted_date();
				String balance=list.get(index).getBalance();
				String unbilled_amt=list.get(index).getUnbilled_amt();
				String due_amt=list.get(index).getDue_amt();
				String state=list.get(index).getState();
				String comment=list.get(index).getComment();
				String query = "update sim_details1 set submitted_date='"
						+ submitted_date
						+ "', balance='"+balance+"', unbilledamt='"+unbilled_amt+"' , dueamt='"+due_amt+"', state='"+state+"', comments='"+comment+"' , allocated=0, owner='Admin'  where sim_id=" + SimId;
				System.out.println("query is ::" + query);
				try {
					pst = con.prepareStatement(query);
				} catch (Exception e) {
					System.out
							.println("Exception occurred while updating the sim details "
									+ e.getMessage());
				}
				r = pst.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return r;

	}

	public int request_sim(ArrayList<Sim> list, String ename, String fname,
			int status) {
		int r = 0;
		int r1 = 0;
		int r2=0;
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2=null;
		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();

			for (int index = 0; index < list.size(); index++) {
				String fromDate = list.get(index).getFrom_date();
				String toDate = list.get(index).getTo_date();
				int SimId = list.get(index).getSim_id();
				String current_day = new SimpleDateFormat("MM/dd/yyyy")
						.format(Calendar.getInstance().getTime());
				String business_justification = list.get(index)
						.getBusiness_justification();
				String query = "insert into sim_requests1 values(" + SimId
						+ ",request_id.nextval,'" + ename + "','" + fname
						+ "','" + current_day + "','" + fromDate + "','"
						+ toDate + "','" + business_justification + "',"
						+ status +",0)";
				String query1 = "update sim_details1 set allocated =1 where sim_id="
						+ SimId;
				String query2="update sim_details1 set owner='"+ename+"' where sim_id="+ SimId;
				// String query =
				// "update sim_details1 set mobile_number="+mobilenumber
				// +",hlrid="+hlrId+",balance="+balance+" where sim_id="+SimId;
				System.out.println("query is ::" + query);
				System.out.println("query is ::" + query1);
				//System.out.println(query2);
				try {
					pst = con.prepareStatement(query);
					pst1 = con.prepareStatement(query1);
					pst2= con.prepareStatement(query2);
				} catch (Exception e) {
					System.out.println("Exception occurred while updating the sim details "	+ e.getMessage());
				}
				r 	= 	pst.executeUpdate();
				r1 	= 	pst1.executeUpdate();
				r2	=	pst2.executeUpdate();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
				if (pst1 != null)
					pst1.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return r;

	}

	public ArrayList<Sim> Pending_requests(String fname, int status) {
		ArrayList<Sim> data = new ArrayList<Sim>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String query = "select * from sim_requests1 where manager_name=? and status=?";
		System.out.println(query);
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, fname);
			pst.setInt(2, status);
			rs = pst.executeQuery();
			while (rs.next()) {

				Sim obj = new Sim();

				obj.setReq_sim_id(rs.getInt(1));
				obj.setRequest_id(rs.getInt(2));
				obj.setEmp_name(rs.getString(3));
				obj.setManager_name(rs.getString(4));
				obj.setApplied_date(rs.getString(5));
				obj.setFrom_date(rs.getString(6));
				obj.setTo_date(rs.getString(7));
				obj.setBusiness_justification(rs.getString(8));
				obj.setReq_status(rs.getInt(9));
				data.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;
	}
	
	public ArrayList<Sim> getstatus(String query1) {
		
		ArrayList<Sim> data = new ArrayList<Sim>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = query1;
		System.out.println(query);
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
		
		
		
			while (rs.next()) {

				Sim obj = new Sim();

				obj.setSim_number(rs.getString(1));
				obj.setType(rs.getString(2));
				obj.setCircle(rs.getString(3));
				obj.setMobile_number(rs.getString(4));
				obj.setBalance(rs.getString(5));
				obj.setUnbilled_amt(rs.getString(6));
				obj.setDue_amt(rs.getString(7));
				obj.setApplied_date(rs.getString(8));
				obj.setStatus(rs.getInt(9));
				obj.setComment(rs.getString(10));
				obj.setBusiness_justification(rs.getString(11));
				
				data.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;
	}

	public ArrayList<Sim> admin_requests(int status) {
		ArrayList<Sim> data = new ArrayList<Sim>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String query = "select * from sim_requests1 where  status=?";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, status);
			rs = pst.executeQuery();
			while (rs.next()) {

				Sim obj = new Sim();

				obj.setReq_sim_id(rs.getInt(1));
				obj.setRequest_id(rs.getInt(2));
				obj.setEmp_name(rs.getString(3));
				obj.setManager_name(rs.getString(4));
				obj.setApplied_date(rs.getString(5));
				obj.setFrom_date(rs.getString(6));
				obj.setTo_date(rs.getString(7));
				obj.setBusiness_justification(rs.getString(8));
				obj.setReq_status(rs.getInt(9));
				data.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;
	}
	public ArrayList<Sim> admin_requests1(int status) {
		ArrayList<Sim> data = new ArrayList<Sim>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query="select  a.sim_id,b.request_id,a.sim_number,a.mobile_number,a.sim_type,a.circle,b.emp_name,b.manager_name,b.applied_date,b.from_date,b.to_date,b.business_justification,b.status,a.balance,a.unbilledamt,a.dueamt   from sim_details1 a,sim_requests1 b where a.sim_id=b.sim_id and b.status=?";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setInt(1, status);
			rs = pst.executeQuery();
			while (rs.next()) {

				Sim obj = new Sim();

				obj.setReq_sim_id(rs.getInt(1));
				obj.setRequest_id(rs.getInt(2));
				obj.setSim_number(rs.getString(3));
				obj.setMobile_number(rs.getString(4));
				obj.setType(rs.getString(5));
				obj.setCircle(rs.getString(6));
				obj.setEmp_name(rs.getString(7));
				obj.setManager_name(rs.getString(8));
				obj.setApplied_date(rs.getString(9));
				obj.setFrom_date(rs.getString(10));
				obj.setTo_date(rs.getString(11));
				
				obj.setBusiness_justification(rs.getString(12));
				obj.setReq_status(rs.getInt(13));
				obj.setBalance(rs.getString(14));
				obj.setUnbilled_amt(rs.getString(15));
				obj.setDue_amt(rs.getString(16));
				data.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;
	}

	public String get_current_day() {
		String current_day = new SimpleDateFormat("MM/dd/yyyy").format(Calendar
				.getInstance().getTime());
		return current_day;
	}
	

	public ArrayList<Sim> assigned_sim_search(String query1) {
		ArrayList<Sim> data = new ArrayList<Sim>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = query1;
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				
				String employee_username=DAOFactory.loginValidateDAO.getUsername(rs.getString(12));
				String manager_username=DAOFactory.loginValidateDAO.getUsername(rs.getString(13));
				String format_fromDate="";
				String format_toDate="";
				String format_appliedDate="";
				
				SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yyyy");
				SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
				try{
					format_fromDate = myFormat.format(fromUser.parse(rs.getString(14)));
					format_toDate=myFormat.format(fromUser.parse(rs.getString(15)));
					format_appliedDate=myFormat.format(fromUser.parse(rs.getString(16)));
				}catch(Exception e){
					e.printStackTrace();
				}
			
				

				Sim obj = new Sim();

				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				String current_day = new SimpleDateFormat("MM/dd/yyyy")
						.format(Calendar.getInstance().getTime());

				int remaining_days = 0;

				try {

					Calendar current_date = Calendar.getInstance();
					current_date.setTime(sdf.parse(current_day));
					Calendar to_date = Calendar.getInstance();
					to_date.setTime(sdf.parse(rs.getString(15)));

					if (current_date.before(to_date)) {

						while (current_date.before(to_date)) {
							remaining_days++;
							current_date.add(Calendar.DATE, 1);
						}
					} else {
						while (!current_date.before(to_date)) {
							remaining_days--;
							to_date.add(Calendar.DATE, 1);
						}
					}

					
					System.out.println("remaining days are ::" + remaining_days );
					

				} catch (Exception e) {
					e.printStackTrace();

				}
				
				
				
				
				obj.setSim_id(rs.getInt(1));
				obj.setSim_number(rs.getString(2));
				obj.setType(rs.getString(3));
				obj.setCircle(rs.getString(4));
				obj.setMobile_number(rs.getString(5));
				obj.setBalance(rs.getString(6));
				obj.setHlr_id(rs.getString(7));
				obj.setUnbilled_amt(rs.getString(8));
				obj.setDue_amt(rs.getString(9));
				
				// obj.setOwner(rs.getString(10));
				
				obj.setAdded_date(rs.getString(10));
				obj.setRequest_id(rs.getInt(11));
				obj.setEmp_name(rs.getString(12));
				obj.setManager_name(rs.getString(13));
				obj.setFrom_date(format_fromDate);
				obj.setTo_date(format_toDate);
				obj.setApplied_date(format_appliedDate);
				obj.setRemaining_days(remaining_days);
				obj.setEmployee_username(employee_username);
				obj.setManager_username(manager_username);
				obj.setReturn_flag(rs.getInt(17));
				obj.setState(rs.getString(18));
				
				// obj.setAllocated_date(rs.getString(12));
				// obj.setExp_return_date(rs.getString(13));
				// obj.setSubmitted_date(rs.getString(14));
				// obj.setAllocated(rs.getInt(15));
				// obj.setStatus(rs.getInt(16));
			


				
				
				data.add(obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;

	}

	public ArrayList<Sim> check_inactive_sims(String query1) {
		ArrayList<Sim> data = new ArrayList<Sim>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = query1;
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				{

					Sim obj = new Sim();

					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					String current_day = new SimpleDateFormat("MM/dd/yyyy")
							.format(Calendar.getInstance().getTime());

					int remaining_days = 0;

					try {

						Calendar current_date = Calendar.getInstance();
						current_date.setTime(sdf.parse(current_day));
						Calendar submitted_date = Calendar.getInstance();
						submitted_date.setTime(sdf.parse(rs.getString(14)));

						if (current_date.after(submitted_date)) {

							while (current_date.after(submitted_date)) {
								remaining_days++;
								submitted_date.add(Calendar.DATE, 1);
							}
						} else {
							while (!current_date.after(submitted_date)) {
								remaining_days--;
								current_date.add(Calendar.DATE, 1);
							}
						}

						//System.out.println("remaining days are ::"
							//	+ remaining_days);

					} catch (Exception e) {
						e.printStackTrace();

					}

					obj.setSim_id(rs.getInt(1));
					obj.setSim_number(rs.getString(2));
					obj.setType(rs.getString(3));
					obj.setCircle(rs.getString(4));
					obj.setMobile_number(rs.getString(5));
					obj.setBalance(rs.getString(6));
					obj.setHlr_id(rs.getString(7));
					obj.setUnbilled_amt(rs.getString(8));
					obj.setDue_amt(rs.getString(9));
					obj.setOwner(rs.getString(10));
					obj.setAdded_date(rs.getString(11));
					obj.setSubmitted_date(rs.getString(14));
					obj.setAllocated(rs.getInt(15));
					obj.setStatus(rs.getInt(16));
					obj.setRemaining_days(remaining_days);
					data.add(obj);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;

	}

	/*
	 * public ArrayList<Sim> Check_inactive_sims_new(String fname, int status) {
	 * ArrayList<Sim> data = new ArrayList<Sim>(); Connection con = null;
	 * PreparedStatement pst = null; ResultSet rs = null;
	 * 
	 * String query = "select * from sim_details1"; try { con =
	 * DatabaseConnectionUtility.getDatabaseConnection(); pst =
	 * con.prepareStatement(query); rs = pst.executeQuery(); while (rs.next()) {
	 * 
	 * Sim obj=new Sim();
	 * 
	 * obj.setSim_id(rs.getInt(1)); obj.setSim_number(rs.getString(2));
	 * obj.setType(rs.getString(3)); obj.setCircle(rs.getString(4));
	 * obj.setMobile_number(rs.getString(5)); obj.setBalance(rs.getString(6));
	 * obj.setHlr_id(rs.getString(7)); obj.setUnbilled_amt(rs.getString(8));
	 * obj.setDue_amt(rs.getString(9)); obj.setOwner(rs.getString(10));
	 * obj.setAdded_date(rs.getString(11));
	 * obj.setSubmitted_date(rs.getString(14)); obj.setAllocated(rs.getInt(15));
	 * obj.setStatus(rs.getInt(16)); data.add(obj);
	 * 
	 * } } catch (SQLException e) { e.printStackTrace(); } finally{ //finally
	 * block used to close resources try{ if(pst!=null) pst.close();
	 * }catch(SQLException se2){ }// nothing we can do try{ if(con!=null)
	 * con.close(); }catch(SQLException se){ se.printStackTrace(); }//end
	 * finally try }
	 * 
	 * return data; }
	 */
	
	public String get_min_date(){
		
		
		String min_date = new SimpleDateFormat("MM/dd/yyyy").format(Calendar.getInstance().getTime());
		System.out.println(min_date);
		min_date=min_date.replace((min_date.substring(2, 6)),"/01/");
		
		
		return min_date;
		
	}
		
	public ArrayList<Sim> search_result_report(String query1) {
		ArrayList<Sim> data = new ArrayList<Sim>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = query1;
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				{

					Sim obj = new Sim();
					obj.setSim_number(rs.getString(1));
					obj.setMobile_number(rs.getString(2));
					
					obj.setEmp_name(rs.getString(3));
					obj.setManager_name(rs.getString(4));
					obj.setApplied_date(rs.getString(5));
					obj.setFrom_date(rs.getString(6));
					obj.setTo_date(rs.getString(7));
					obj.setBusiness_justification(rs.getString(8));
					obj.setStatus(rs.getInt(9));
					obj.setSim_id(rs.getInt(10));
					obj.setRequest_id(rs.getInt(11));
					
					data.add(obj);
					
					
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;

	}
	public String  Generate_Report(String query1,String timeStamp) {
		String path=null;

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = query1;
		int stat=0;
		String status=""; 
		
		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("Report");
			HSSFRow rowhead = sheet.createRow((short) 0);
			rowhead.createCell((short) 0).setCellValue("Sim Number");
			rowhead.createCell((short) 1).setCellValue("Mobile Number");
			rowhead.createCell((short) 2).setCellValue("Employee Name");
			rowhead.createCell((short) 3).setCellValue("Manager Name");
			rowhead.createCell((short) 4).setCellValue("Applied date");
			rowhead.createCell((short) 5).setCellValue("From Date");
			rowhead.createCell((short) 6).setCellValue("To Date");
			rowhead.createCell((short) 7).setCellValue("Business Justification");
			rowhead.createCell((short) 8).setCellValue("Status");
			
			
			
			int index = 1;
			while (rs.next()) {

				SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yyyy");
				SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
				String formatfrom = myFormat.format(fromUser.parse(rs.getString(6)));
				String formatto= myFormat.format(fromUser.parse(rs.getString(7)));
				String formatapplied=myFormat.format(fromUser.parse(rs.getString(5)));
					   
				
				
				
				stat=rs.getInt(9);
				if(stat==1){
					status="Manager Pending ";
				}else if (stat==2){
					status="Manager Rejected";
				}else if(stat==3){
					status="Admin Pending";
				}else if(stat==4){
					status="Admin Rejected";
				}else if(stat==5){
					status="Admin Approved";
				}else if(stat==6){
					status="Returned";
				}

				HSSFRow row = sheet.createRow((short) index);
				row.createCell((short) 0).setCellValue(rs.getString(1));
				row.createCell((short) 1).setCellValue(rs.getString(2));
				row.createCell((short) 2).setCellValue(rs.getString(3));
				row.createCell((short) 3).setCellValue(rs.getString(4));
				row.createCell((short) 4).setCellValue(formatapplied);
				row.createCell((short) 5).setCellValue(formatfrom);
				row.createCell((short) 6).setCellValue(formatto);
				row.createCell((short) 7).setCellValue(rs.getString(8));
				row.createCell((short) 8).setCellValue(status);
				
				index++;
			}
			FileOutputStream fileOut = new FileOutputStream("c:\\"+timeStamp+"-SIMS Report.xls");
			path="c:\\"+timeStamp+"-SIMS Report.xls";
			wb.write(fileOut);
			fileOut.close();

		}  catch (SQLException e) {
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
		         if(con!=null)
		            con.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }

		return path;

	}

		
/*	public ArrayList<Sim> get_return_login() {
		ArrayList<Sim> data = new ArrayList<Sim>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = " select distinct return_flag from sim_requests1 where emp_name='employee'; ";
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				// System.out.println("Got results:"+rs.getString(3));
				// System.out.println(rs.getInt(4));
				S obj = new Login();
				obj.setEname(rs.getString(1));
				data.add(obj);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}
		return data;
	}*/
	
	
	
	public ArrayList<Sim> get_return_login(String query1) {
		ArrayList<Sim> data = new ArrayList<Sim>();

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = query1;
		try {
			con = DatabaseConnectionUtility.getDatabaseConnection();
			st = con.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {
				{

					Sim obj = new Sim();
					obj.setReturn_flag(rs.getInt(1));
					data.add(obj);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (st != null)
					st.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return data;

	}
	public int reactivate_user(String ename) {
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		String query = "update employee set flag=1 where ename=?";

		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, ename);
			r = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return r;

	}
	
	public int deactivate(String ename) {
		int r = 0;
		Connection con = null;
		PreparedStatement pst = null;
		String query = "update employee set flag=0 where ename=?";

		try {

			con = DatabaseConnectionUtility.getDatabaseConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, ename);
			r = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (pst != null)
					pst.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}

		return r;

	}
	
	
	
	
}

