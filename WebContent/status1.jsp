<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@page import="com.ibm.factory.DAOFactory"%><html>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.ibm.beans.Sim"%>
<%@page import="com.ibm.beans.Login"%>


<%@ page import="java.util.Iterator"%>
<head>
<title>employee details</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" rel="stylesheet" type="text/css" />
<script>
</script>
</head>
<% 
Login UserCredentials = (Login) request.getSession()
			.getAttribute("UserCredentials");
	//View obj1=(View) request.getSession().getAttribute("obj5");
	String a = UserCredentials.getEname();

	String b = UserCredentials.getRole();

String query="select distinct a.sim_number,a.sim_type,a.circle,a.mobile_number,a.balance,a.unbilledamt,a.dueamt,b.applied_date,b.status from sim_details1 a , sim_requests1 b where a.sim_id=b.sim_id and b.emp_name in ('"+a+"') order by b.status";

ArrayList<Sim> list= DAOFactory.loginValidateDAO.getstatus(query);


%>
<body>
<form action="" method="post" name="resfrm">
<div style="width: 100%" scrolling="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="445" align="left" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr><br>
				<br>
				<br>
				</td>
				<td width="8%" align="center">&nbsp;</td>
			</tr>
		</table>
		<center><% if(list.size()>0){%></center>
		<table border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td align="center" height="134" width="1212">

				<table width="95%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>

						<center>
						<table width="94%" border="0" cellpadding="0" cellspacing="0"
							id="table">
							<tr>
								
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="18%">Sim Number</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="13%">Sim Type</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="12%">Circle</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="15%">Mobile Number</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="13%">Balance</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="6%">Unbilled Amount</td>	
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="6%">Due Amount</td>	
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="8%">Requested Date</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="19%">Status</td>	
								 
							</tr>

							<tr>
								<%
			Iterator<Sim> it = list.iterator();
			while(it.hasNext())
			{
				Sim obj= it.next();	
			%>					
								<td class="normaltext" align="center" height="42" width="131"><%=obj.getSim_number()%></td>
								<td class="normaltext" align="center" height="42" width="120"><%=obj.getType()%></td>
								<td class="normaltext" align="center" height="42" width="156"><%=obj.getCircle()%></td>
								<td class="normaltext" align="center" height="42" width="131"><%=obj.getMobile_number()%></td>
								<td class="normaltext" align="center" height="42" width="111"><%=obj.getBalance()%></td>
								<td class="normaltext" align="center" height="42" width="35"><%=obj.getUnbilled_amt()%></td>
								
								<td class="normaltext" align="center" height="42" width="33"><%=obj.getDue_amt()%></td>
								<td class="normaltext" align="center" height="42" width="45"><%=obj.getApplied_date()%></td>
								<%if(obj.getStatus()==1){ %>
								<td class="normaltext" align="center" height="42" width="105">Manager Pending</td> <%} %>
								<% if(obj.getStatus()==2){ %>
								<td class="normaltext" align="center" height="42" width="105">Manager Rejected</td> <%} %>
								<%  if(obj.getStatus()==3){ %>
								<td class="normaltext" align="center" height="42" width="105"> Admin Pending</td> <%} %>
								<%  if(obj.getStatus()==4){ %>
								<td class="normaltext" align="center" height="42" width="105">Admin Rejected</td> <%} %>
								<%  if(obj.getStatus()==5){ %>
								<td class="normaltext" align="center" height="42" width="105">Admin Approved</td> <%} %>
								<%  if(obj.getStatus()==6){ %>
								<td class="normaltext" align="center" height="42" width="105">Returned Sims</td> <%} %>
																

							</tr>
							<%} %>

						</table>
						</center>
						</td>
					</tr>
				</table>
				
							
				<br>
				<center><%}else{%><h3 class="normaltextbold"> There are no Requests raised </h3> <% }%></center>
				
				

				</td>
			</tr>


		</table>
		</td>
	</tr>
</table>
</div>
</body>
</form>
</html>
