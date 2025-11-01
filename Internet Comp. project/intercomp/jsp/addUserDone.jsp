<jsp:useBean id="validator" class="logonBean.adduser" scope="request"/>
<% 
	
	String firstName = validator.getFirstName();
	String name = firstName + " " + validator.getLastName(); 
%>
<html>
<title>Successful Registration</title>
<body bgcolor="#CCCCCC">
<center>
<p><font face="Comic Sans MS" color="#000099">
  <h1><font size="+2">Registration complete</font></h1>


Thank you, <i><%= name%></i>  for registering, 

<p>

You can now login <a href="verifyUser.jsp">here</a>

<br><br><br>

</font></center>

</body>
</html>

