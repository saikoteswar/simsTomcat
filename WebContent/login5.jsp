<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script type="text/javascript">
  window.parent.handleResponse();
</script>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Login</title>
<style type="text/css">
<!--

-->
</style>
<link href="css.css" rel="stylesheet" type="text/css" />
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
</head>
<body onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">


<form id="form1" name="form1" method="post" action="Emplogin" >
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="248" height="20"><img src="images/top1.jpg" width="248" height="97" /></td>
    <td width="100%" background="images/top2BG.jpg">&nbsp;</td>
    <td width="214" align="right"><img src="images/Top3.jpg" width="214" height="97" /></td>
  </tr>
</table>
<center>

</center>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
<tr></tr><tr></tr>
  <tr></tr>
  <tr>
    <td  class="normaltextbold" height="442" align="center"><table width="540" height="186" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top" background="images/LoginBG.jpg"><table width="540" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="60" align="left">&nbsp;</td>
            </tr>
            <tr>
              <td><table width="540" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="143" height="25" align="right" class="normaltextbold" >User ID </td>
                    <td width="13" height="25" align="center" class="normaltextbold">:</td>
                    <td width="180" height="25" align="left" class="normaltext"><input name="userid" type="text" class="normaltext" size="25" /></td>
                    <td width="204" height="25" align="left" class="normaltextbold"></td>
                  </tr>
                  <tr>
                    <td height="25" align="right" class="normaltextbold">Password</td>
                    <td height="25" align="center" class="normaltextbold">:</td>
                    <td height="30" align="left" class="normaltext"><input name="pwd" type="password" class="normaltext" size="25" /></td>
                    <td height="25" align="left">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="25" align="right" class="normaltext">&nbsp;</td>
                    <td height="25" align="center" class="normaltext">&nbsp;</td>
                    <td height="30" align="left" class="normaltext"><table width="150" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td align="center"70"><form id="form1" name="form1" method="post" action="Emplogin" >
                              <input name="Submit" type="submit" class="Button" value="Submit"  />
                          </form></td>
                           
                         
                        </tr>
                    </table></td>
                    <td height="25" align="center" class="normaltextbold">&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
      </tr>
    </table><c:out  value="${msg}"/></td>
  </tr>
  
</table>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="20" background="images/Bottom-BG.jpg">&nbsp;</td>
  </tr>
</table>
</form>
</body>
</html>