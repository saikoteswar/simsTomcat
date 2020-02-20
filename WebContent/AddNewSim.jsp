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

<script><!--
  
  
  
function IsEmpty(){





if(document.getElementById("sim_num").value.length ==0){
alert("Please enter Sim Number");
return false;
}

var select=document.getElementById("myselect").value;
if(select=="select"){
alert ("Please select subscription type of the sim");
return false;
}

if(document.getElementById("mobile_number").value.length ==0){
alert("Please enter Mobile Number");
return false;

}
if(document.getElementById("balance").value.length ==0){
alert("Please enter the Balance");
return false;

}
if(document.getElementById("unbilled_amt").value.length ==0){
alert("Please enter the Unbilled Amount");
return false;

}
if(document.getElementById("due_amt").value.length ==0){
alert("Please enter the Due Amount");
return false;

}




var p = /^\d+$/;
if(!p.test(document.getElementById("sim_num").value)){
alert("Enter only  numbers in Sim Number");
return false;
}
var m=/^\d{10}$/;
if(!m.test(document.getElementById("mobile_number").value)){
alert("Enter  Mobile number correctly");
return false;
}

   
 
 
 return true;
}

var select=document.getElementById("myselect");
var balance=document.getElementById("balance");
var unbilled_amt=document.getElementById("unbilled_amt");
var due_amt=document.getElementById("due_amt");
function diablebalance(){

var select=document.getElementById("myselect");
var balance=document.getElementById("balance");
var unbilled_amt=document.getElementById("unbilled_amt");
var due_amt=document.getElementById("due_amt");

//alert("hi");


if(balance.readOnly)
{
return false;
}


}

function diableunbilled(){

var select=document.getElementById("myselect");
var balance=document.getElementById("balance");
var unbilled_amt=document.getElementById("unbilled_amt");
var due_amt=document.getElementById("due_amt");
//alert("hi");


if(unbilled_amt.readOnly)
{
return false;
}


}

function diabledueamount(){

var select=document.getElementById("myselect");
var balance=document.getElementById("balance");
var unbilled_amt=document.getElementById("unbilled_amt");
var due_amt=document.getElementById("due_amt");
//alert("hi");


if(due_amt.readOnly)
{
return false;
}


}



function hide(){

var select=document.getElementById("myselect");
var balance=document.getElementById("balance");
var unbilled_amt=document.getElementById("unbilled_amt");
var due_amt=document.getElementById("due_amt");
var select_value=select.value;



	if(select_value=="prepaid"||select_value=="prepaid data"||select_value=="prepaid mnp"||select_value=="prepaid bb")
	{
		
		balance.readOnly=false;
		balance.value="";
		unbilled_amt.value="N/A";
		unbilled_amt.readOnly=true;
		due_amt.value="N/A";
		due_amt.readOnly=true;
	}
	
	if(select_value=="postpaid"||select_value=="postpaid mnp"||select_value=="postpaid data"||select_value=="postpaid bb")
	{
		balance.value="N/A";
		balance.readOnly=true;
		unbilled_amt.readOnly=false;
		unbilled_amt.value="";
		due_amt.readOnly=false;
		due_amt.value="";
	}
	if(select_value=="select"){
		balance.value="";
		unbilled_amt.value="";
		due_amt.value="";
		balance.readOnly=true;
		unbilled_amt.readOnly=true;
		
		due_amt.readOnly=true;
	}
	
}
  --></script>
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
<form action="AddNewSim" method="post" name="frm">

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
											cellspacing="0" id="table2" height="61">
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="52">Sim Number</td>
												<td class="normaltext" width="299" height="46"><input
													type="text" name="sim_num" id="sim_num" style="width: 195"
													class="normaltext"></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="43">Type</td>
												<td class="normaltext" width="243" height="43"><select
													style="width: 195" name="subscriber_type" size="1"
													class="normaltext" id="myselect" onchange="hide();">

													<option value="select">Select</option>
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
													width="268" height="48">Circle</td>
												<td class="normaltext" width="243" height="48"><select
													style="width: 195" name="circle" size="1"
													class="normaltext">

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
													width="268" height="47">Mobile Number</td>
												<td class="normaltext" width="299" height="47"><input
													type="text" name="mobile_number" style="width: 195"
													class="normaltext" id="mobile_number"></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="46">Balance</td>
												<td class="normaltext" width="299" height="46"><input
													type="text" name="balance" id="balance" style="width: 195"
													class="normaltext" readonly="readonly"
													onkeydown="return diablebalance();"></td>
											</tr>

											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="46">HLR Id</td>
												<td class="normaltext" width="299" height="46"><input
													type="text" name="hlr_id" id="balance" style="width: 195"
													class="normaltext"></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="46">UnBilled Amount</td>
												<td class="normaltext" width="299" height="46"><input
													type="text" name="unbilled_amt" id="unbilled_amt"
													style="width: 195" class="normaltext" readonly="readonly"
													onkeydown="return diableunbilled();"></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="46">Due Amount</td>
												<td class="normaltext" width="299" height="46"><input
													type="text" name="due_amt" id="due_amt" style="width: 195"
													class="normaltext" readonly="readonly"
													onkeydown="return diabledueamount();"></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="46">State</td>
												<td class="normaltext" width="299" height="46"><select
													style="width: 195" name="state" size="1" class="normaltext">


													<option value="active">Active</option>
													<option value="inactive">Inactive</option>
													<option value="churned">Churned</option>
													<option value="lost">Lost</option>



												</select></td>
											</tr>
											<tr>
												<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
													width="268" height="70">Comment</td>
												<td class="normaltext" width="299" height="70"><textarea
													name="comment" cols="25" rows="3" /></textarea>
											
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