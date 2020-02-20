<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@page import="com.ibm.factory.DAOFactory"%><html>
<%@ page import="java.util.ArrayList"%>
<%@page import="com.ibm.beans.Sim"%>
<%@page import="com.ibm.beans.Login"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.Iterator"%>
<head>
<title>employee details</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="dem/demos.css">
<script src="js1/jquery.js"></script>
<script src="js1/jquery-ui-1.9.2.custom.min.js"></script>
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
var size=document.getElementById("size").value;

var size1=parseInt(size);


for( var i=1;i<=size1;i++){ 


var sim_number=document.getElementsByName('sim_number_real'+i)[0].value;


var from_date=document.getElementsByName('from_date'+i)[0].value.length;
	if(from_date == 0){
		alert(" Please enter the ' From Date ' for Sim Number '"+sim_number+"' ");
	return false;
	}

var to_date=document.getElementsByName('to_date'+i)[0].value.length;
	if(to_date == 0){
		alert("Please enter the 'To Date' for Sim Number '"+sim_number+"' ");
	return false;
	}

var business_justification=document.getElementsByName('business_justification'+i)[0].value.length;
	if(business_justification == 0){
		alert("Please enter Business Justification for Sim Number '"+sim_number+"' ");
	return false;
	}
	
	var st= new Array();
  	var st1= new Array();
   st=document.getElementsByName('from_date'+i)[0].value.split("/");
   st1=document.getElementsByName('to_date'+i)[0].value.split("/");
   
   					var d =  st[1];
					var m =  st[0];
					var y =  st[2];
					var d1 = st1[1];
					var m1 = st1[0];
					var y1 = st1[2];
   
  if(y==y1&&m==m1&& d>d1){
 
  alert("'From Date' cannot be greater than 'To Date' for Sim Number ' "+sim_number+" ' ");
  return false;
  }
  if(y==y1&&m>m1){
	  alert("'From Date' cannot be greater than 'To Date' for Sim Number ' "+sim_number+" ' ");
  return false;
 
  }
  if(y>y1){
	  alert("'From Date' cannot be greater than 'To Date' for Sim Number ' "+sim_number+" ' ");
  return false;
 
  }
  
	
	

}
 return true;
}
 $(function() {
                $(".fromDate").datepicker({
                   defaultDate: "+1w",                     
                   // minDate: 0,                    
                    numberOfMonths: 1,
                    changeMonth: true,
                    changeYear:true,
                    showAnim : 'slideDown',
                   // beforeShowDay: $.datepicker.noWeekends,
                    onSelect: function( selectedDate ) {
                        $( "toDate" ).datepicker( "option", "minDate", selectedDate );
                    }
                });
                $(".toDate").datepicker({
                    defaultDate: "+1w",                    
                   // minDate: 1,
                    changeMonth: true,
                    changeYear:true,
                    numberOfMonths: 1,
                    showAnim : 'slideDown',
                   // beforeShowDay: $.datepicker.noWeekends,
                    onSelect: function( selectedDate ) {
                        $( "fromDate" ).datepicker( "option", "maxDate", selectedDate );
                    }
                 });
             });
</script>
</head>
<% 
Login UserCredentials = (Login) request.getSession()
			.getAttribute("UserCredentials");
	//View obj1=(View) request.getSession().getAttribute("obj5");
	String a = UserCredentials.getEname();

	String b = UserCredentials.getRole();

String query=(String)request.getSession().getAttribute("query");

ArrayList<Sim> list=(ArrayList<Sim>)request.getSession().getAttribute("data");
int size=list.size();


%>
<body>

<form action="RequestSim1" method="post" name="resfrm">
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
		<%//if(list.size()>0){ %>
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
									class="boldwhitetext" height="42" width="11%">Unbilled Amount</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">Due Amount</td>		
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">HLR Id</td>	
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">From Date</td>	
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">To Date</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">Business Justification</td>
									
								
								 
							</tr>



<c:forEach var="obj" begin="0" step="1" items="${sessionScope.data}" varStatus="status">
							<input value=<%="\""+size+"\""%> type="hidden" id="size" />
							<input name="sim_number${status.count}" type="hidden" value="${obj.sim_id}">
							<input name="sim_number_real${status.count}" type="hidden" value="${obj.sim_number}">
							<tr>
								<td class="normaltext" align="center" height="42" width="131"><c:out value="${obj.sim_number}"></c:out></td>
								<td class="normaltext" align="center" height="42" width="120"><c:out value="${obj.type}"></c:out></td>
								<td class="normaltext" align="center" height="42" width="156"><c:out value="${obj.circle}"></c:out></td>
								<td class="normaltext" align="center" height="42" width="131"><c:out value="${obj.mobile_number}"></c:out></td>
								
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
								<td class="normaltext" align="center" height="42" width="111"><c:out value="${obj.hlr_id}"></c:out></td>
								<td class="normaltext" align="center" height="42" width="105"><input type="text" name="from_date${status.count}" style=width:80   value="${obj.from_date}" class="fromDate" ></td>
								<td class="normaltext" align="center" height="42" width="105"><input type="text" name="to_date${status.count}" style=width:80   value="${obj.to_date}" class="toDate" ></td>	
								<td class="normaltext" align="center" height="42" width="111"><input type="text" name="business_justification${status.count}" style=width:80   value="${obj.business_justification}"></td>

							</tr>
							</c:forEach>
							

						</table>
						</center>
						</td>
					</tr>
				</table>
				<br>
				<center><input name="Submit" type="submit" class="Button"
							value="Request" onclick="return IsEmpty(); ">
							
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
<%//}else{%>
<center><h3 class="normaltext" ><b>No data to display </b></h3><%//} %></center>
</body>
</form>
</html>
