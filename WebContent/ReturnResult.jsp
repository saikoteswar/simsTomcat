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
function selectCB()
{
	var selectAll = document.resfrm.select_all;
	var cb = document.getElementsByName("checkbox[]");
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



  var checks=document.getElementsByName('checkbox[]');
  var haschecked=false;
  var temp="";
  for(var i=0;i<checks.length;i++)
  {
  if(checks[i].checked){
  haschecked=true;
  temp=temp+checks[i].value+",";
  
  }
  
  } 
  if (haschecked==false){
  alert("Please select a sim to Return");
  return false;
    }
    
    
 
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

String query=(String)request.getSession().getAttribute("AllocatedSearchquery");
ArrayList<Sim> list = DAOFactory.loginValidateDAO.search_result_new(query);

%>
<body>
<form action="ReturnSim1" method="post" name="resfrm">
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
						<%if (list.size()>0){ %>
						<table width="94%" border="0" cellpadding="0" cellspacing="0"
							id="table">
							<tr>
								<td align="center" background="images/TableBG.jpg"
							class="boldwhitetext" height="69" width="7%">Select All<input
							type="checkbox" name="select_all"  id="select_all" onclick="selectCB()">
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
									class="boldwhitetext" height="42" width="11%">HLR Id</td>	
									
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="11%">Sim Added Date</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="9%">Allocated to/request</td>	
								 
							</tr>

							<tr>
								<%
			Iterator<Sim> it = list.iterator();
			while(it.hasNext())
			{
				Sim obj= it.next();	
			%>					
								<td align="center" class="normaltext" height="30" width="73"><input	type="checkbox" name="checkbox[]" value=<%="\"" + obj.getRequest_id() + "\""%>></input></td>
								
								
								<td class="normaltext" align="center" height="42" width="131"><%=obj.getSim_number()%></td>
								<td class="normaltext" align="center" height="42" width="120"><%=obj.getType()%></td>
								<td class="normaltext" align="center" height="42" width="156"><%=obj.getCircle()%></td>
								<td class="normaltext" align="center" height="42" width="131"><%=obj.getMobile_number()%></td>
								<td class="normaltext" align="center" height="42" width="111"><%=obj.getBalance()%></td>
								<td class="normaltext" align="center" height="42" width="111"><%=obj.getHlr_id()%></td>
							
								<td class="normaltext" align="center" height="42" width="95"><%=obj.getAdded_date()%></td>
								<td class="normaltext" align="center" height="42" width="105"><%=obj.getEmp_name()%></td>
								
																

							</tr>
							<%} %>

						</table>
						</center>
						</td>
					</tr>
				</table>
				<br>
				<center><input name="Submit" type="submit" class="Button2"
							value="Return Sims" onclick="return IsEmpty(); ">
							<input name="Reset" type="Reset" class="Button"
							value="Reset" onclick="return IsEmpty(); ">
							<br>
				<br><%}else{ %><h3 class="normaltextbold"> No data found</h3><%} %>
				

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
