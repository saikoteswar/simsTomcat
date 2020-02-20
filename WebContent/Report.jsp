<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<%@page import=" java.text.SimpleDateFormat"%>
<%@page import=" java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.ibm.beans.Sim"%>
<%@ page import="java.util.Iterator"%>
<head>
<title>employee details</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" rel="stylesheet" type="text/css" />

</head>
<%
	ArrayList<Sim> data = (ArrayList<Sim>) request.getSession()	.getAttribute("list");
	int stat = 0;
	String c = "-";
%><body>
<form action="Generate_Report" method="post">
<div style="width: 100%" scrolling="auto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="445" align="left" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="4%" height="30" bgcolor="#FFFFFF">&nbsp;</td>
				<br>
				<br>
				</td>
				<td width="8%" align="center">&nbsp;</td>
			</tr>

		</table>
		<%
			if (data.size() > 0) {
		%>
		<table border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td align="center" height="134" width="1212">

				<table width="95%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>

						<center>
						<table width="95%" border="0" cellpadding="0" cellspacing="0"
							id="table">
							<tr>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="17%">Sim Number</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="13%">Mobile
								Number</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="12%">Employee
								Name</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">Manager Name</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">Applied Date
								</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">From Date</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="10%">To Date</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="8%">Business
								Justification</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="7%">Status</td>


							</tr>

							<tr>
								<%
									Iterator<Sim> it = data.iterator();
									
									
										while (it.hasNext()) {
									
											Sim obj = it.next();
									
									
									SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yyyy");
									SimpleDateFormat myFormat = new SimpleDateFormat("dd-MMM-yyyy");
									String formatfrom = myFormat.format(fromUser.parse(obj.getFrom_date()));
									String formatto= myFormat.format(fromUser.parse(obj.getTo_date()));
									String formatapplied=myFormat.format(fromUser.parse(obj.getApplied_date()));
										   
									
									
									        stat=obj.getStatus();
											if(stat==1){
											c="Manager Pending ";
											}else if (stat==2){
											c="Manager Rejected";
											}else if(stat==3){
											c="Admin Pending";
											}else if(stat==4){
											c="Admin Rejected";
											}else if(stat==5){
											c="Admin Approved";
											}else if(stat==6){
											c="Returned";
											}
								%>
								<td class="normaltext" align="center" height="42" width="186"><%=obj.getSim_number()%></td>
								<td class="normaltext" align="center" height="42" width="140"><%=obj.getMobile_number()%></td>
								<td class="normaltext" align="center" height="42" width="140"><%=obj.getEmp_name()%></td>
								<td class="normaltext" align="center" height="42" width="129"><%=obj.getManager_name()%></td>
								<td class="normaltext" align="center" height="42" width="124"><%=formatapplied%></td>
								<td class="normaltext" align="center" height="42" width="120"><%=formatfrom%></td>
								<td class="normaltext" align="center" height="42" width="115"><%=formatto%></td>
								<td class="normaltext" align="center" height="42" width="114"><%=obj.getBusiness_justification()%></td>
								<td class="normaltext" align="center" height="42" width="86"><%=c%></td>

							</tr>
							<%
								}
							%>

						</table>

						</center>
						</td>
					</tr>
				</table>
				<br>
				<br>
				<br>
				<input name="Submit" type="submit" class="Button2" value="Generate">
				<input name="Submit" type="submit" class="Button2" value="Back">
				<br><br>
				</td>
			</tr>



		</table>
		<%
			} else {
		%>
		<center><span class="boldblacktext">No data Found to
		display</span></center>


		<%
			}
		%>
		</td>
	</tr>
</table>

</div>
</body>

</html>
