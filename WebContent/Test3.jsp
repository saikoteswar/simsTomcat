<!DOCTYPE html>
<html>
<body>

<p>Click the button to demonstrate the prompt box.</p>

<button  onclick="myFunction()">Try it</button>

<p id="demo"></p>

<script>
function myFunction()
{
var x;

var person=prompt("Please enter your name","Harry Potter");

if (person!=null)
  {
  x="Hello " + person + "! How are you today?";
  document.getElementById("demo").innerHTML=x;
  }
}
</script>