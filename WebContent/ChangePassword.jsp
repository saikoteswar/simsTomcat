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
	//View obj1=(View) request.getSession().getAttribute("obj5");
	String a = UserCredentials.getEname();

	String b = UserCredentials.getRole();
%>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
<form action="ChangePassword" method="post" name="frm">

<div style="width: 100%" scrolling="auto">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" height="445" align="left" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="4%" height="30" bgcolor="#FFFFFF">&nbsp;</td>
				<td width="88%"><span class="boldblacktext">Name : </span><span
					class="normaltext"> <%=a%></span> <span class="boldblacktext">
				Role : </span><span class="normaltext"><%=b%></span></td>
				<td width="8%" align="center">&nbsp;</td>
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
											cellspacing="0" id="table2" height="100">
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="52">Username</td>
												<td class="normaltext" width="299" height="52"><%=UserCredentials.getUsername()%></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="46">Enter Old Password</td>
												<td class="normaltext" width="299" height="46"><input
													type="password" name="opwd" style="width: 195"
													class="normaltext"></td>
											</tr>

											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="43">Enter New Password</td>
												<td class="normaltext" width="299" height="43"><input
													type="password" name="npwd" style="width: 195"
													class="normaltext"></td>
											</tr>

											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="52">Confirm New Password</td>
												<td class="normaltext" width="299" height="52"><input
													type="password" name="cpwd" style="width: 195"
													class="normaltext"></td>
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