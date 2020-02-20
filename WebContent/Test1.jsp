<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Test1</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function hide(){

var select=document.getElementById("select");
var other=document.getElementById("other");


var val=select.value;


if (val=="other"){

other.readOnly=false;
}else{
other.readOnly=true;

}


}
</script>
</head>

<body>
<form name="myform">
<table>
<tr>
<td>
<select name="one" id="select" onchange="hide();">
<option value="" selected="selected">Select...</option>
<option value="1">1</option>
<option value="2">3</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="other">Other</option>
</select>
<input type="textbox" name="other" id="other" value="a" readonly="readonly""/>
</td>
</tr>
</table>
</form>

</body>
</html>