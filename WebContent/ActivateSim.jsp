<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	//@page import="com.ibm.dao.ViewEmployeeDAO"
%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.ibm.beans.Login"%>
<%@ page import="java.util.Iterator"%>



<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Apply leave</title>
<link href="css.css" rel="stylesheet" type="text/css" />

<script>
  
  
  
function IsEmpty(){



 
 return true;
}




  </script>
<SCRIPT type="text/javascript">


    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<%
	Login UserCredentials = (Login) request.getSession()
			.getAttribute("UserCredentials");
			
			if(UserCredentials.getEname() == null){
			System.out.println("value is : "+UserCredentials.getEname());
			response.sendRedirect("login5.jsp");
			}
	//View obj1=(View) request.getSession().getAttribute("obj5");
	String a = UserCredentials.getEname();
System.out.println("value of ename is : "+a);
	String b = UserCredentials.getRole();
	
	
%>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
<form action="ActivateSim" method="post" name="frm">

<div style="width: 100%" scrolling="auto">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" height="445" align="left" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center" class="normaltextbold" height="28"><c:out
					value="${msg}" /></td>
			</tr>


			<tr>
				<td align="center" height="339">
				<table border="0" align="center" cellpadding="0"
					cellspacing="0">

					<tr>
						<td height="25" width="568">
						<table border="0" align="center" cellpadding="0"
							cellspacing="0" id="table2">
							<tr>
								<td align="center" width="530" height="207">
								<table border="0" align="center" cellpadding="0" cellspacing="0">

									<tr>
										<td height="25" width="664">
										<table width="545" border="0" align="center" cellpadding="0"
											cellspacing="0" id="table2" height="90">
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="85">Type</td>
												<td class="normaltext" width="243" height="85"><select
													style="width: 195" name="type" size="4" class="normaltext"
													id="myselect" multiple="multiple">

													<option value="All">All</option>
													<option value="prepaid">Prepaid</option>
													<option value="prepaid mnp">Prepaid MNP</option>
													<option value="prepaid data">Prepaid Data</option>
													<option value="prepaid bb">Prepaid BB</option>
													<option value="postpaid">Postpaid</option>
													<option value="postpaid mnp">Postpaid MNP</option>
													<option value="postpaid data">Postpaid Data</option>
													<option value="postpaid bb">Postpaid BB</option>

												</select></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="85">Circle</td>
												<td class="normaltext" width="243" height="85"><select
													style="width: 195" name="circle" size="5"
													class="normaltext" id="myselect" multiple="multiple">
													<option value="All">All</option>
													<option value="AP">AP</option>
													<option value="BI">BI</option>
													<option value="DL">DL</option>
													<option value="GJ">GJ</option>
													<option value="HP">HP</option>
													<option value="HR">HR</option>
													<option value="JK">JK</option>
													<option value="KL">KL</option>
													<option value="KR">KR</option>
													<option value="MH">MH</option>
													<option value="MP">MP</option>
													<option value="MUM">MUM</option>
													<option value="NESA">NESA</option>
													<option value="OD">OD</option>
													<option value="PU">PU</option>
													<option value="RJ">RJ</option>
													<option value="TN">TN</option>
													<option value="UPW">UPW</option>
													<option value="UPE">UPE</option>
												</select></td>
											</tr>

											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="44">Sim Number</td>
												<td class="normaltext" width="299" height="44"><input
													type="text" name="sim_num" id="sim_num" style="width: 195"
													class="normaltext"></td>
											</tr>



											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="46">Mobile Number</td>
												<td class="normaltext" width="299" height="46"><input
													type="text" name="mobile_number" style="width: 195"
													class="normaltext" id="mobile_number"></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="46">HLR Id</td>
												<td class="normaltext" width="299" height="46"><input
													type="text" name="hlr_id" style="width: 195"
													class="normaltext" id="mobile_number"></td>
											</tr>






										</table>
										</td>
									</tr>
								</table>

								</td>
							</tr>


						</table>
						<br>
						<br>
						<center><input name="Submit" type="submit" class="Button"
							value="Submit" onclick="return IsEmpty(); "><br>
						<br>
						<br>
						</center>

						</td>
					</tr>
				</table>
				</div>
				</form>
</body>
</html>