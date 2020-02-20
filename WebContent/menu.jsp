<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<%@page import="com.ibm.beans.Login"%>

<head>

<title>menu</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" rel="stylesheet" type="text/css" />

</head>
<%
	Login obj = (Login) request.getSession().getAttribute(
			"UserCredentials");
%>
<body>

<table width="221" border="0" align="left" cellpadding="0"
	cellspacing="0">
	<tr>
		<td width="22%" height="445" valign="top" bgcolor="#FFFFD9"
			class="rightborder">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<%
				if (obj.getRole().equalsIgnoreCase("Admin")) {
			%><tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td width="12" height="25" class="boldblack">&nbsp;</td>
				<td width="196" height="25" class="Blackbutton"><a
					href="AddNewSim.jsp" class="normaltextbold" target="workarea">
				Add New Sim</a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="GlobalSearch.jsp"
				class="normaltextbold" target="workarea">Sim Search </a></td>
			</tr>
			
			
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="AssignedSimSearch.jsp"
				class="normaltextbold" target="workarea">Assigned Sim Search </a></td>
			</tr>
			
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="ReturnSimSearch.jsp"
					class="normaltextbold" target="workarea">Return Sim </a></td>
			</tr>
			
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="RequestNewSim.jsp"
					class="normaltextbold" target="workarea">Request for New Sims </a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
					onmouseout="this.style.backgroundColor='#FFFFD9';">
					<td height="25" class="boldblack">&nbsp;</td>
					<td height="25" class="Blackbutton"><a href="AdminPendingRequests"
						class="normaltextbold" target="workarea">Pending Requests </a></td>
				</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="UpdateSimSearch.jsp"
					class="normaltextbold" target="workarea">Update Sim </a></td>
			</tr>
		
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="InactivateSim.jsp"
					class="normaltextbold" target="workarea">Disable Sim </a></td>
			</tr>
			
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="ActivateSim.jsp"
					class="normaltextbold" target="workarea">Enable Sim </a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="CheckInactiveSims.jsp"
					class="normaltextbold" target="workarea">Inactive Sims-60 Days</a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="CreateNewUser.jsp"
					class="normaltextbold" target="workarea">Create New User </a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="GenerateReports.jsp"
					class="normaltextbold" target="workarea">Generate Reports</a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a
					href="ChangePassword.jsp" class="normaltextbold" target="workarea">Change
				Password </a></td>
			</tr>
			
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="DeactivateUser.jsp"
					class="normaltextbold" target="workarea">Deactivate User </a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="ReactivateUser.jsp"
					class="normaltextbold" target="workarea">Reactivate User </a></td>
			</tr>
			
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="SPOCList.jsp"
					class="normaltextbold" target="workarea">List of SPOCs </a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="Help.jsp"
					class="normaltextbold" target="workarea">Help </a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
					onmouseout="this.style.backgroundColor='#FFFFD9';">
					<td height="25" class="boldblack">&nbsp;</td>
					<td height="25" class="Blackbutton"><a href="logout.jsp"
						class="normaltextbold" target="_parent">Logout </a></td>
				</tr>
			
			<%
				} else if (obj.getRole().equalsIgnoreCase("employee")) {
			%><td width="22%" height="445" valign="top" bgcolor="#FFFFD9"
				class="rightborder">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				
				<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="RequestNewSim.jsp"
					class="normaltextbold" target="workarea">Request for New Sims </a></td>
			</tr>
				
				<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a
					href="ChangePassword.jsp" class="normaltextbold" target="workarea">Change
				Password </a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
					onmouseout="this.style.backgroundColor='#FFFFD9';">
					<td height="25" class="boldblack">&nbsp;</td>
					<td height="25" class="Blackbutton"><a href="status.jsp"
						class="normaltextbold" target="workarea">Status of Requested SIMS</a></td>
				</tr>
				
				<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
					onmouseout="this.style.backgroundColor='#FFFFD9';">
					<td height="25" class="boldblack">&nbsp;</td>
					<td height="25" class="Blackbutton"><a href="Help.jsp"
						class="normaltextbold" target="workarea">Help </a></td>
				</tr>
				
				<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
					onmouseout="this.style.backgroundColor='#FFFFD9';">
					<td height="25" class="boldblack">&nbsp;</td>
					<td height="25" class="Blackbutton"><a href="logout.jsp"
						class="normaltextbold" target="_parent">Logout </a></td>
				</tr>
				
			</table>
			<%
				}
				else if(obj.getRole().equalsIgnoreCase("manager")) {
			%>
			
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
					onmouseout="this.style.backgroundColor='#FFFFD9';">
					<td height="25" class="boldblack">&nbsp;</td>
					<td height="25" class="Blackbutton"><a href="ManagerPendingRequests"
						class="normaltextbold" target="workarea">Pending Requests </a></td>
				</tr>
				<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a href="RequestNewSim.jsp"
					class="normaltextbold" target="workarea">Request for New Sims </a></td>
			</tr>
			<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
					onmouseout="this.style.backgroundColor='#FFFFD9';">
					<td height="25" class="boldblack">&nbsp;</td>
					<td height="25" class="Blackbutton"><a href="status.jsp"
						class="normaltextbold" target="workarea">Status of Requested SIMS</a></td>
				</tr>
			
				
				<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
				onmouseout="this.style.backgroundColor='#FFFFD9';">
				<td height="25" class="boldblack">&nbsp;</td>
				<td height="25" class="Blackbutton"><a
					href="ChangePassword.jsp" class="normaltextbold" target="workarea">Change
				Password </a></td>
			</tr>
				<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
					onmouseout="this.style.backgroundColor='#FFFFD9';">
					<td height="25" class="boldblack">&nbsp;</td>
					<td height="25" class="Blackbutton"><a href="Help.jsp"
						class="normaltextbold" target="workarea">Help </a></td>
				</tr>
				<tr onmouseover="this.style.backgroundColor='#D4E0F6';"
					onmouseout="this.style.backgroundColor='#FFFFD9';">
					<td height="25" class="boldblack">&nbsp;</td>
					<td height="25" class="Blackbutton"><a href="logout.jsp"
						class="normaltextbold" target="_parent">Logout </a></td>
				</tr>
				<%
				}
				 %>
				
			</table>
					</table>
		</td>
	</tr>
</table>

</body>
</html>
