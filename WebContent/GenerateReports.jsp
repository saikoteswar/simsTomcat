<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.ibm.factory.DAOFactory"%><html>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.ibm.beans.Login"%>
<%@ page import="java.util.Iterator"%>
<head>
<title>GenerateReports</title>
<link href="css.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="dem/demos.css">
<script src="js1/jquery.js"></script>
<script src="js1/jquery-ui-1.9.2.custom.min.js"></script>
<script>
		   $(function() {
                $("#fromDate").datepicker({
                   defaultDate: "+1w",                     
                   // minDate: 0,                    
                    numberOfMonths: 1,
                    changeMonth: true,
                    changeYear:true,
                    showAnim : 'slideDown',
                   // beforeShowDay: $.datepicker.noWeekends,
                    onSelect: function( selectedDate ) {
                        $( "#toDate" ).datepicker( "option", "minDate", selectedDate );
                    }
                });
                $("#toDate").datepicker({
                    defaultDate: "+1w",                    
                   // minDate: 1,
                    changeMonth: true,
                    changeYear:true,
                    numberOfMonths: 1,
                    showAnim : 'slideDown',
                   // beforeShowDay: $.datepicker.noWeekends,
                    onSelect: function( selectedDate ) {
                        $( "#fromDate" ).datepicker( "option", "maxDate", selectedDate );
                    }
                 });
             });
</script>
<script>
 
  
function IsEmpty(){

   
  if(document.forms['frm'].from.value == "")
  {
    alert("enter from date ");
    return false;
  }
  else if(document.forms['frm'].to.value == "")
  {
    alert("enter to date");
    return false;
  }
  
 var st= new Array();
  var st1= new Array();
   st=document.forms['frm'].from.value.split("/");
   st1=document.forms['frm'].to.value.split("/");
   
   					var d =  st[1];
					var m =  st[0];
					var y =  st[2];
					var d1 = st1[1];
					var m1 = st1[0];
					var y1 = st1[2];
   
  if(y==y1&&m==m1&& d>d1){
 
  alert("From  date cannot be greater than To date");
  return false;
  }
  if(y==y1&&m>m1){
  alert("From  date cannot be greater than To date");
  return false;
 
  }
  if(y>y1){
  alert("From  date cannot be greater than To date");
  return false;
 
  }
  
  
  

 return true;
}




  </script>
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<%
ArrayList<Login> list1=DAOFactory.loginValidateDAO.get_distinct_Employees();

String min_date = DAOFactory.loginValidateDAO.get_min_date();
	String current_day = DAOFactory.loginValidateDAO.get_current_day();


 %>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
<form action="GenerateReports" method="post" name="frm">

<div style="width: 100%" scrolling="auto">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" height="445" align="left" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<br>
			
		</table>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center" class="normaltextbold" height="28" width="1279"><c:out
					value="${msg}" /></td>
			</tr>


			<tr>
				<td align="center" height="339" width="1279">
				<table border="0" align="center" cellpadding="0" cellspacing="0">

					<tr>
						<td width="720" height="324">
						<table width="534" border="0" align="center" cellpadding="0"
							cellspacing="0" id="table2" height="19">
							<tr>
								<td align="left" rowspan="2" bgcolor="#f4f4f4"
									class="normaltextbold" width="279" height="97">Select Employee's name</td>
								<td class="normaltext" rowspan="2" width="253" height="97"><select
									multiple="multiple" style="width: 195" name="ename" size="8"
									class="normaltext">
									<option value="ALL" selected="selected">ALL</option>
									<%
										Iterator<Login> it1 = list1.iterator();
										while (it1.hasNext()) {
											Login obj2 = it1.next();
									%>

									<option value=<%="\"" + obj2.getEname() + "\""%>><%=obj2.getEname()%>
									<%
										}
									%>
									</option>


								</select></td>




							</tr>
							<tr></tr>
							<tr>

								<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
									width="279" height="52">From Date</td>
								<td width="253" height="52"><input class="normaltext"
									type="text" style="width: 195"
									value=<%="\"" + min_date + "\""%> name="from" id="fromDate" /></td>

							</tr>
							<tr>


								<td align="left" bgcolor="#f4f4f4" class="normaltextbold"
									width="279" height="52">To Date</td>
								<td width="253" height="52"><input class="normaltext"
									type="text" style="width: 195"
									value=<%="\"" + current_day + "\""%> name="to" id="toDate" /></td>

							</tr>
							<tr>

								<td align="left" rowspan="2" bgcolor="#f4f4f4"
									class="normaltextbold" width="279" height="89">Status</td>
								<td class="normaltext" rowspan="2" width="253" height="89"><select
									multiple="multiple" style="width: 195" name="status" size="8"
									class="normaltext">
									<option value="All" selected="selected">ALL Transactions</option>
									<option value="5">Admin Approved</option>
									<option value="3">Manager Approved</option>
									<option value="4">Admin Rejected</option>
									<option value="2">Manager Rejected</option>
									<option value="1">Manager Pending</option>
									<option value="6">Returned sims</option>

								</select></td>



							</tr>






						</table>
						</td>
					</tr>
				</table><center>
				<br>
				<br><br><input name="Submit" type="submit" class="Button"
					value="Submit" onclick="return IsEmpty(); "><br>
				</td>
			</tr>


		</table>
		<br>

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