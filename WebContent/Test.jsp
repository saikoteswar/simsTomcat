<html>
< head >  
<script>  
function makePayeeDetailsEditable()  
{  
var frm = document.forms[0];  
var flag= frm.diffPayeeAddrFlag.checked;  
if(flag )  
{     
frm.payeeAgentAddress1.readOnly=false;  
frm.payeeAgentAddress2.readOnly=false;  
frm.payeeAgentCity.readOnly=false;  
frm.payeeAgentState.readOnly=false  ;
}else  
{  
frm.payeeAgentAddress1.readOnly=true;   
frm.payeeAgentAddress2.readOnly=true;   
frm.payeeAgentCity.readOnly=true;  
frm.payeeAgentState.readOnly=true;  
}  
} ;  
</script>  
</head>  
<form  name="testform" action="# ">  
   
check Box: <input type="checkbox" name="diffPayeeAddrFlag" value="checked"   onclick="makePayeeDetailsEditable()" /> <br/>  
   
address1 :<input type="text" name="payeeAgentAddress1" readonly="readonly"/> <br/>  
address2 :<input type="text" name="payeeAgentAddress2" readonly="readonly"/> <br/>  
City :<input type="text" name="payeeAgentCity" readonly/> <br/>  
City :<input type="text" name="payeeAgentState" readonly/> <br/>  
</form>  