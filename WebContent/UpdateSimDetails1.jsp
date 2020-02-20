<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@page import="com.ibm.factory.DAOFactory"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.ibm.beans.Sim"%>
<%@page import="com.ibm.beans.Login"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.Iterator"%>
<head>
<title>employee details</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" rel="stylesheet" type="text/css" />
<script>
function makeFieldsEditable()  
{  

var frm = document.forms[0]; 
var flag= frm.checkbox.checked;  
if(flag )  
{     
frm.hlr_id.readOnly=false;  
frm.mobile_number.readOnly=false;  

}else  
{  
frm.hlr_id.readOnly=true;   
frm.mobile_number.readOnly=true;   
 
}  
} ;
function selectCB()
{
	var selectAll = document.resfrm.select_all;
	var cb = document.getElementsByName("checkbox");
	if(selectAll.checked == true)
	{
		for(var index = 0;index <= cb.length; index++)
			cb[index].checked = true;
	}
	else
	{
		for(var index = 0;index <= cb.length; index++)
			cb[index].checked = false;
	}
} 
function IsEmpty(){




 return true;
}


  
</script> 
</head>

<body >

<form action="UpdateSim1" method="post" name="resfrm" >
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
		<table border="0" cellspacing="0" cellpadding="0">

			<tr>
				<td align="center" height="134" width="1212">

				<table width="95%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>

						<center>
						<table width="96%" border="0" cellpadding="0" cellspacing="0"
							id="table">
							<tr>

								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="14%">Sim Number</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="10%">Sim Type</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="7%">Circle</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">Mobile
								Number</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">Balance</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="8%">Un Billed
								Amount</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="10%">Due Amount</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="9%">HLR Id</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="9%">Status</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">Comments</td>	
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">Allocated
								to/request</td>
								

							</tr>
							
							<c:forEach var="obj" begin="0" step="1"
								items="${requestScope.data}" varStatus="status">
								<input name="sim_number${status.count}" type="hidden"
									value="${obj.sim_id}">
								<tr>

									<td class="normaltext" align="center" height="42" width="131"><c:out
										value="${obj.sim_number}"></c:out></td>

									<td class="normaltext" align="center" height="42" width="120"><c:out
										value="${obj.type}"></c:out></td>

									<td class="normaltext" align="center" height="42" width="85"><c:out
										value="${obj.circle}"></c:out></td>

									<td class="normaltext" align="center" height="42" width="126">
										<input type="text" name="mobile_number${status.count}"
										style="width: 80" value="${obj.mobile_number}">
									</td>
									
									<td class="normaltext" align="left"  height="42" width="124">
									
										<c:if test="${obj.type == 'prepaid' || obj.type == 'prepaid mnp'||obj.type == 'prepaid data'||obj.type == 'prepaid bb'}">
											<input	type="text" name="balance${status.count}" style="width: 80"  value="${obj.balance}">
										</c:if>
										
										<c:if test="${obj.type == 'postpaid'||obj.type == 'postpaid mnp'||obj.type == 'postpaid data'||obj.type == 'postpaid bb'}">
											<c:out value="${obj.balance}"/> <input	type="hidden"  name="balance${status.count}" style="width: 80"  value="${obj.balance}">
										</c:if>
									</td>
									
									<td class="normaltext" align="left" height="42" width="124">
										<c:if test="${obj.type == 'postpaid'||obj.type == 'postpaid mnp'||obj.type == 'postpaid data'||obj.type == 'postpaid bb'}">
											<input	type="text" name="unbilled_amt${status.count}" style="width: 80"  value="${obj.unbilled_amt}">
										</c:if>
										<c:if test="${obj.type == 'prepaid' || obj.type == 'prepaid mnp'||obj.type == 'prepaid data'||obj.type == 'prepaid bb'}">
											<c:out value="${obj.unbilled_amt}"/> <input	type="hidden"  name="unbilled_amt${status.count}" style="width: 80"  value="${obj.unbilled_amt}">
										</c:if>
									</td>
									
									
									
									<td class="normaltext"  align="left" height="42" width="124">
										<c:if test="${obj.type == 'postpaid'||obj.type == 'postpaid mnp'||obj.type == 'postpaid data'||obj.type == 'postpaid bb'}">
											<input	type="text" name="due_amt${status.count}" style="width: 80"  value="${obj.due_amt}">
										</c:if>
										<c:if test="${obj.type == 'prepaid' || obj.type == 'prepaid mnp'||obj.type == 'prepaid data'||obj.type == 'prepaid bb'}">
											<c:out value="${obj.due_amt}"/> <input	type="hidden"  name="due_amt${status.count}" style="width: 80"  value="${obj.due_amt}">
										</c:if>
									</td>
									
									
									
									
									<td class="normaltext" align="center" height="42" width="109">	<input	type="text" name="hlr_id${status.count}" style="width: 80"	value="${obj.hlr_id}"></td>
									<td class="normaltext" width="243" height="43"><select
													style="width: 85" name="state${status.count}" size="1"
													class="normaltext" id="state" >
													<c:if test="${obj.state == 'active'}">
													<option selected="selected"  value="active">Active</option>
													<option value="inactive">Inactive</option>
													<option  value="lost">Lost</option>
													<option  value="churn">Churn</option>
													</c:if>
													
													<c:if test="${obj.state == 'inactive'}">
													<option  value="active">Active</option>
													<option selected="selected"  value="inactive">Inactive</option>
													<option  value="lost">Lost</option>
													<option  value="churn">Churn</option>
													</c:if>
													
													<c:if test="${obj.state == 'lost'}">
													<option  value="active">Active</option>
													<option  value="inactive">Inactive</option>
													<option  selected="selected" value="lost">Lost</option>
													<option  value="churn">Churn</option>
													</c:if>
													
													<c:if test="${obj.state == 'churn'}">
													<option  value="active">Active</option>
													<option  value="inactive">Inactive</option>
													<option  value="lost">Lost</option>
													<option  selected="selected" value="churn">Churn</option>
													</c:if>
													
													
		
		

												</select></td>
												<td class="normaltext" align="center" height="42" width="109">	
												<textarea name="comment${status.count}"  cols="25" rows="3" />${obj.comment}</textarea></td>
												
												<td class="normaltext" align="center" height="42" width="64"><c:out
										value="${obj.owner}"></c:out></td>
									

								</tr>
							</c:forEach>


						</table>
						</center>
						</td>
					</tr>
				</table>
				<br>
				<center><input name="Submit" type="submit" class="Button"
							value="Update" onclick="return IsEmpty(); ">
							<input name="Reset" type="Reset" class="Button"
							value="Reset" onclick="return IsEmpty(); ">
							<input name="Submit" type="submit" class="Button"
							value="Back" >
							<br>
				<br>
				

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
