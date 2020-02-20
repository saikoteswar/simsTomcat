<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>logout</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<%
request.getSession().removeAttribute("obj5");




RequestDispatcher rd= request.getRequestDispatcher("login5.jsp");
rd.forward(request,response);
 %>
<body onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">

</body>
</html>	