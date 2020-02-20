<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<%@page import="com.ibm.beans.Login"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>
<link href="css.css" rel="stylesheet" type="text/css" />

</head>
<%
Login obj1=(Login)request.getSession().getAttribute("UserCredentials");
String a=obj1.getEname();
String b=obj1.getRole();
%>
<body>
<div style="width:100%" scrolling="auto">
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td width="100%" height="445" align="left" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="3%" height="30" bgcolor="#FFFFFF">&nbsp;</td>
          <td width="89%"><span class="boldblacktext">Name : </span><span class="normaltext"><%=a %></span><span class="boldblacktext">  Role. : </span><span class="normaltext"><%=b %></span><br>
				<br>
				<br>
				</td>
          <td width="8%" align="center">&nbsp;</td>
        </tr>
      </table>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="10" height="25">&nbsp;</td>
            <td width="772" class="normaltextbold" align="center"><c:out  value="${msg}"/></td>
            <tr></tr>
          </tr>
          <tr>
            <td height="25">&nbsp;</td>
            <td align="center" class="boldblack"><table width="612" height="250" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td background="images/WelcomeBG.jpg">&nbsp;</td>
                </tr>
            </table></td>
          </tr>
          <tr>
            <td height="25">&nbsp;</td>
            <td align="center" class="boldblack">&nbsp;</td>
          </tr>
          <tr>
            <td height="25">&nbsp;</td>
            <td align="center" class="boldblack">&nbsp;</td>
          </tr>
          <tr>
            <td height="25">&nbsp;</td>
            <td align="center" class="boldblack">&nbsp;</td>
          </tr>
          <tr>
            <td height="25">&nbsp;</td>
            <td align="center" class="boldblack">&nbsp;</td>
          </tr>
          <tr>
            <td height="25">&nbsp;</td>
            <td align="center" class="boldblack">&nbsp;</td>
          </tr>
        </table></td>
    </tr>
  </table>
</div>
</body>
</html>
