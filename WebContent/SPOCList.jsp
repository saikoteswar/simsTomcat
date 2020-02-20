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
  alert("Please select a sim to disable");
  return false;
    }
    
    
 
 return true;
}

</script>
</head>

<body>
<form action="InacticateSim1" method="post" name="resfrm">
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
						<table width="94%" class="normaltext"  border="0" cellpadding="0" cellspacing="0"
							id="table">
							<tr>
								
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="18%">Name</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="19%">Contact Number</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="24%">Email Address</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="15%">Circle</td>
							</tr>



							<tr  align="center"  height="42" width="95"><td>	Balacassy M		</td><td>	9092005792</td><td>	balacassy.m@idea.adityabirla.com</td><td>	TN</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Ritutpal Bhuyan	</td><td>9085008879</td><td>	-	</td><td>AS</td></tr>	
							<tr  align="center"  height="42" width="95"><td>	Ritutpal Bhuyan	</td><td>9085008879</td><td>	-	</td><td>NE</td></tr>	
							<tr  align="center"  height="42" width="95"><td>	Diana Mascarenhas</td><td>	9702004617	</td><td>diana.mascarenhas@idea.adityabirla.com	</td><td>MUM</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Gagandeep Mahal	</td><td>9814694511	</td><td>gagandeep.mahal@idea.adityabirla.com	</td><td>PB</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Gagandeep Mahal	</td><td>9814694511	</td><td>gagandeep.mahal@idea.adityabirla.com	</td><td>JK</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Gagandeep Mahal	</td><td>9814694511	</td><td>gagandeep.mahal@idea.adityabirla.com	</td><td>HP</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Hitesh Kundhal	</td><td>9826470004	</td><td>hitesh.kundhal@idea.adityabirla.com	</td><td>MP</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Swapan Mistri</td>	<td>9088008881	</td><td>-	</td><td>KOL</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Swapan Mistri</td>	<td>9088008881	</td><td>-	</td><td>WB</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Michelle D'Costa</td>	<td>9847058202	</td><td>-	</td><td>KL</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Mahima Bajpai</td>	<td>9889009209	</td><td>mahima.bajpai@idea.adityabirla.com	</td><td>UPE</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Pratyush Sharma	</td> <td>9887005805	</td><td>Pratyush.sharma@idea.adityabirla.com	</td><td>RJ</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Ilina Banerjee</td>	<td>9921002708	</td><td>-	</td><td>MH</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Munindra Sapia</td>	<td>9990009146	</td><td>-	</td><td>HR</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Munindra Sapia</td>	<td>9990009146	</td><td>-	</td><td>DL</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Siddharth Mathur </td>	<td>9090009245	</td><td>-	</td><td>OR</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Rashmi Prasad	</td><td>9708097444	</td><td>rashmi.prasad@idea.adityabirla.com	</td><td>BIH</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Sheetal Chatwal	</td><td>9824004266	</td><td>sheetal.chatwal@idea.adityabirla.com	</td><td>GJ</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Malleswari Voleti	</td><td>9848002054	</td><td>-	</td><td>AP</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Udayakiran K S	</td><td>9844215750	</td><td>Udayakiran.K.S@idea.adityabirla.com	</td><td>KK</td></tr>
							<tr  align="center"  height="42" width="95"><td>	Ashutosh Thakur	</td><td>9990035142	</td><td>-	</td><td>UPW</td></tr>
							
							
							
							
							
														
						</table>
						</center>
						</br></br>
						
					<table width="95%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>

						<center>
						<table width="94%" class="normaltext"  border="0" cellpadding="" cellspacing="0"
							id="table">
							<tr>
								
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="18%"></td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="19%">For Escalation</td>
								<td align="center" background="images/TableBG.jpg"
									class="boldwhitetext" height="42" width="24%"></td>
								
							</tr>

							
							
							<tr  align="center"  height="42" width="95">
								<td>Khushboo Chirmade</td>
								<td>3854</td>
								<td>khushboo.chirmade@idea.adityabirla.com</td>
							</tr>

							
						</table></center>
						
						</td>
					</tr>
				</table>
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
