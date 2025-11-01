<!-- 
File: error.jsp
Written By Dermot Carroll (CA4) (98680056) 
Final Year Project 2002
Description: This file is used for debugging purposes. When a system error
occurs, the user is informed of such and a debug email is sent to the 
administrator with the contents of the server window at the time of the error.
-->
<%@ page isErrorPage="true" %>

<html>
<head>
<title></title>
</head>
<body bgcolor="#CCCCCC">
<h1 align="center"><font size="+2"><b><font face="Comic Sans MS" color="#000099">An 
  error has occured</font></b></font></h1>
<div align="center"><br>
  <br>
  <font size="2" face="Comic Sans MS">We're sorry, the page you have just tried 
  to access contained some errors. Our staff have been notified of the error and 
  will fix the problem as soon as possible.</font></div>
<p>


<p align="center"> <font face="Comic Sans MS" size="2">We're sorry for any inconvenience 
  caused</font><br>
  <br>
  <br>
  <a href="../../ItemsForSale/categories.xml"><font face="Comic Sans MS" size="2">Return 
  to main index</font></a><br>
  <br>
</body>
</html>