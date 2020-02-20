
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

function IsEmpty(){




 return true;
}

</script>
</head>
<% 
Login UserCredentials = (Login) request.getSession()
			.getAttribute("UserCredentials");
	//View obj1=(View) request.getSession().getAttribute("obj5");
	String a = UserCredentials.getEname();

	String b = UserCredentials.getRole();
	
	String current_day = DAOFactory.loginValidateDAO.get_current_day();
	
	ArrayList<Sim> list=(ArrayList<Sim>)request.getSession().getAttribute("list");
	


%>
<body>
<form action="Notify" method="post" name="resfrm">
<div style="width: 100%" scrolling="auto">
<table border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="445" align="left" valign="top" width="1368">
		<table width="92%" border="0" cellspacing="0" cellpadding="0">
			<tr>
			<tr>
				<td align="center" class="normaltextbold" height="28"><c:out
					value="${msg}" /></td>
			</tr>
				<br>
				<br>
				<br>
				
				</td>
				<td align="center" width="8%">&nbsp;</td>
			</tr>
		</table>
		<center>
		<%if(list.size()>0){  %>
		<table border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td align="center" height="134" width="1212">

				<table width="95%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>

						<table width="90%" border="0" cellpadding="0" cellspacing="0"
							id="table">
							<tr>

								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="8%">Sim Number</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="8%">Mobile Number</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="10%">Employee
								Name</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="9%">Manager Name</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="5%">Sim Type</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="6%">Circle</td>


								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="8%">Balance</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="9%">UnBilled
								Amount</td>

								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="8%">Due Amount</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="9%">Applied_Date</td>	

								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="8%">From_Date
								</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="7%">Return_Date  
								</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="13%">Remaining
								Days</td>

								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="7%">Send_Email</td>
								
								</tr>

							<c:forEach var="obj" begin="0" step="1"
								items="${sessionScope.list}" varStatus="status">
								
								
							
								<input name="employee_name${status.count}" type="hidden"
									value="${obj.employee_username}">
								<input name="manager_name${status.count}" type="hidden"
									value="${obj.manager_username}">
								<input name="sim_number${status.count}" type="hidden"
									value="${obj.sim_number}">
								<input name="mobile_number${status.count}" type="hidden"
									value="${obj.mobile_number}">
								<input name="type${status.count}" type="hidden"
									value="${obj.type}">
								<input name="circle${status.count}" type="hidden"
									value="${obj.circle}">
								<input name="from_date${status.count}" type="hidden"
									value="${obj.from_date}">
								<input name="to_date${status.count}" type="hidden"
									value="${obj.to_date}">
								<input name="request_id${status.count}" type="hidden"
									value="${obj.request_id}">	
								<input name="return_flag${status.count}" type="hidden"
									value="${obj.return_flag}">	
									
									


								<tr>
									<td class="normaltext" align="center" height="42" width="131"><c:out
										value="${obj.sim_number}"></c:out></td>
									<td class="normaltext" align="center" height="42" width="67"><c:out
										value="${obj.mobile_number}"></c:out></td>
									<td class="normaltext" align="center" height="42" width="37"><c:out
										value="${obj.emp_name}"></c:out></td>
									<td class="normaltext" align="center" height="42" width="201"><c:out
										value="${obj.manager_name}"></c:out></td>

									<td class="normaltext" align="center" height="42" width="186"><c:out
										value="${obj.type}"></c:out></td>
									<td class="normaltext" align="center" height="42" width="33"><c:out
										value="${obj.circle}"></c:out></td>
									<td class="normaltext" align="center" height="42" width="45"><c:if
										test="${obj.type == 'prepaid'}">
										<c:out value="${obj.balance}"></c:out>
									</c:if><c:if test="${obj.type != 'prepaid'}">
										<c:out value="N/A"></c:out>
									</c:if></td>
									<td class="normaltext" align="center" height="42" width="164"><c:if
										test="${obj.type == 'postpaid'}">
										<c:out value="${obj.unbilled_amt}"></c:out>
									</c:if><c:if test="${obj.type != 'postpaid'}">
										<c:out value="N/A"></c:out>
									</c:if></td>
									<td class="normaltext" align="center" height="42" width="111"><c:if
										test="${obj.type == 'postpaid'}">
										<c:out value="${obj.due_amt}"></c:out>
									</c:if><c:if test="${obj.type != 'postpaid'}">
										<c:out value="N/A"></c:out>
									</c:if></td>
									<td class="normaltext" align="center" height="42" width="138"><c:out
										value="${obj.applied_date}"></c:out></td>
									<td class="normaltext" align="center" height="42" width="122"><c:out
										value="${obj.from_date}"></c:out></td>	
									<td class="normaltext" align="center" height="42" width="105"><c:out
										value="${obj.to_date}"></c:out></td>
									<td class="normaltext" align="center" height="42" width="212"><c:if
										test="${obj.remaining_days>0}">
										<c:out value="${obj.remaining_days}"></c:out>
									</c:if>
									<c:if test="${obj.remaining_days<0 && obj.return_flag==0}">
										<input name="notify" type="submit" class="Button2"
											value="Notify${status.count}" onclick="return IsEmpty(); ">
												<input name="count" type="hidden"
									value="${status.count}" >
									</c:if>
									<c:if test="${obj.remaining_days<0 && obj.return_flag>0}">
										<input name="notify" type="submit" class="Button2"
											value="Notify${status.count}" disabled="disabled" onclick="return IsEmpty(); ">
												<input name="count" type="hidden"
									value="${status.count}" >
									</c:if>
									
									
									</td>
									<td class="normaltext" align="center" height="42" width="217"><c:if
										test="${obj.remaining_days>0}">
										<c:out value="N/A"></c:out>
									</c:if><c:if test="${obj.remaining_days<0}">
										<a
											href="mailto:${obj.employee_username}?subject=SIMS%20Notification-Please return the Sim allocated to you&amp;cc=${obj.manager_username},rohitsax@in.ibm.com&amp;body=Hi ${obj.emp_name},%09%0D%0A%09%0D%0A               Sim Number                     :${obj.sim_number}%09%0D%0A               Mobile Number               :${obj.mobile_number}%09%0D%0A               Sim Applied Date           :${obj.applied_date}%09%0D%0A               Sim Allocated Date       :${obj.from_date}%09%0D%0A               Expected Return Date  :${obj.to_date}%09%0D%0A">
										<h5 class="normaltextbol">Send Email
										</h3>
										</a>
									</c:if></td>




								</tr>
							</c:forEach>

						</table>
						</center>
						</td>
					</tr>
					
				</table>
				<br>
				<center>
				<%}else{ %><h3 class="normaltextbold"> No data to display</h3><%} %><br>
				

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






								