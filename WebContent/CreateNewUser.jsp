<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>


<%@page import="javax.ccpp.SetAttribute"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.ibm.beans.Login"%>
<%@ page import="java.util.Iterator"%>
<%@page import="com.ibm.factory.DAOFactory"%>






<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Details</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<script>


function display1(){


    return true;

}
function display2(){


    return true;

}

function display3(){


    return true;

}
</script>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>

<%
	Login obj1 = (Login) request.getSession().getAttribute("UserCredentials");
	String b = obj1.getRole();
	String a = obj1.getEname();

	ArrayList<Login> list = DAOFactory.loginValidateDAO.getManagers();
%>



<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">


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
		<form action="CreateNewUser" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">&nbsp;</td>
			</tr>


			<tr>
				<td align="center" height="265">
				<table border="0" align="center" cellpadding="0" cellspacing="0">

					<tr>
						<td height="25" width="572">
						<table width="545" border="0" align="center" cellpadding="0"
							cellspacing="0" id="table2">
							<tr>
								<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
									width="199" height="46">Employee's role</td>
								<td class="normaltext" align="center" height="46" width="294"><select
									style="width: 195" name="role" size="1" class="normaltext">
									<option value="Employee">Team Member</option>
									<option value="Manager">Test Manager</option>


								</select></td>

							</tr>
							<tr>
								<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
									width="199" height="47">Employee's Name</td>
								<td class="normaltext" align="center" height="47" width="294"><input
									type="text" name="ename" style="width: 195" class="normaltext"></td>
							</tr>
							<tr>
								<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
									width="199" height="46">Select Manager's Name</td>
								<td class="normaltext" align="center" height="46" width="294"><select
									style="width: 195" name="fname" size="1" class="normaltext">
									<%
										Iterator<Login> it = list.iterator();
										while (it.hasNext()) {
											Login obj5 = it.next();
									%>

									<option value=<%="\"" + obj5.getUsername() + "\""%>><%=obj5.getUsername()%>
									<%
										}
									%>
									</option>


								</select></td>

							</tr>
							
							<tr>
								<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
									width="199" height="49">Enter Username</td>
								<td class="normaltext" align="center" height="49" width="294"><input
									type="text" name="uname" style="width: 195" class="normaltext"></td>
							</tr>


							<tr>
								<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
									width="199" height="45">Enter Password</td>
								<td class="normaltext" align="center" height="45" width="294"><input
									type="text" name="pwd" style="width: 195" class="normaltext"></td>

							</tr>



						</table>
						</td>
					</tr>
				</table>

				</td>
			</tr>


		</table>
		<center><br>
		<br>
		<input class="Button"
					type="Submit" value="Create" onclick="return display3(); "></form></center>
		<br>
		<br>
		<center>
		<table>

			<tr>
				<th>
				<td>
				
				</td>
			</tr>
		</table>
		</center>
</body>
</html>