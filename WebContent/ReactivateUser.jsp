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

var response=confirm("Reactivate the selected user");
if (!response){
return false;}

    return true;

}
</script>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>

<%
	ArrayList<Login> list1=DAOFactory.loginValidateDAO.reactivate_users(); 
	
	
	request.setAttribute("page","deactivate");
	
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
				
				<td width="8%" align="center">&nbsp;</td>
			</tr>
		</table>
		<%
		if (list1.size()>0){
		
		
		 %>
		<form action="Reactivate" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="12">&nbsp;</td>
			</tr>


			<tr>
				<td align="center" height="139"><table border="0" align="center" cellpadding="0" cellspacing="0"
					height="26" width="511">

					<tr>
						<td height="25" width="572">
						<table width="545" border="0" align="center" cellpadding="0"
							cellspacing="0" id="table2">
							<tr>
								<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
									width="199" height="70">Select Employee's name</td>
								<td class="normaltext" align="center" width="294" height="70"><select
									style="width: 195" name="ename" size="1" class="normaltext">
									<%
										Iterator<Login> it2 = list1.iterator();
										while (it2.hasNext()) {
											Login obj2 = it2.next();
									%>

									<option value=<%="\"" + obj2.getEname() + "\""%>><%=obj2.getEname()%>
									<%
										}
									%>
									</option>


								</select></td>

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
		<input class="Button2" type="Submit" value="Reactivate"
			onclick="return display3(); ">
		</form>
		<%}else{ %>
		
		<center class="normaltextbold">Employee not found to reactivate</center>
		<%} %>
		</center>
		<br>
		<br>
		<center>
		<table>

			<tr>
				<th>
				<td></td>
			</tr>
		</table>
		</center>
</body>
</html>