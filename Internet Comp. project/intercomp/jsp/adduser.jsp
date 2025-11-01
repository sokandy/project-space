<jsp:useBean id="validator" class="logonBean.adduser" scope="request"/>
<html>
<head>
<meta name="description" content="Register New User.">
<meta name="keywords" content="Post Post">
<title>Register new user</title>
</head>
<body bgcolor="#CCCCCC">
<form name="registration" method="post" action="validateStepOne.jsp">
<center>
<p><font size="+2"><b><font face="Comic Sans MS" color="#000099">Register new user (Step 1)</font></b></font></p>

<font face="Comic Sans MS" size="2">(Fields marked with <font color="#FF0000" size="3">*</font> are required)</font> 
	
	<br>
	<br>
	<br>

    <table width="49%" border="0">
      <tr>
        <td width="49%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS"color="#000099">First 
          name</font><font face="Comic Sans MS" size="2"></font><font face="Comic Sans MS"color="#000099">: 
          </font></td>
        
		
        <td width="51%"><%=validator.getError("firstName")%> 
          <input type="text" name="firstName" size="30" value="<%= validator.getFirstName()%>"/></td>
	  
	  </tr>
      
	  <tr>
        <td width="49%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS"color="#000099">Surname</font><font face="Comic Sans MS" size="2"></font><font face="Comic Sans MS"color="#000099">: 
          </font></td>

		
        <td width="51%"><%=validator.getError("lastName")%> 
          <input type="text" name="lastName" size="30" value="<%= validator.getLastName()%>"/></td>
	  </tr>
      
	  
	  <tr>
        <td width="49%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS"color="#000099">Username</font><font face="Comic Sans MS" size="2"></font><font face="Comic Sans MS"color="#000099">: 
          </font></td>
        
		
        <td width="51%"><%=validator.getError("userID")%> 
          <input type="text" name="userId" size="30" value="<%= validator.getUserID()%>"/></td>
      </tr>
    
	  <tr>
        <td width="49%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS"color="#000099">Email 
          address</font><font face="Comic Sans MS" size="2"></font><font face="Comic Sans MS"color="#000099">: 
          </font></td>
        
		
        <td width="51%"><%=validator.getError("email")%> 
		<input type="text" name="email" size="30" value="<%=validator.getEmail()%>"/></td>
      </tr>
	
	<tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3"></font></font><font face="Comic Sans MS" size="3" color="#000099">Home phone:</font></td>
        <td width="62%"><%=validator.getError("homePhoneNumber")%>
          <input type="text" name="homePhoneNumber" size="30" value="<%= validator.getHomePhoneNumber()%>"/>
        </td>
      </tr>
	
	
	<tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS" size="3" color="#000099">Password:</font></td>
        <td width="62%"><%=validator.getError("passwordOne")%> 
          <input type="password" name="passwordOne" size="30" value="<%= validator.getPasswordOne()%>"/>
        </td>
      </tr>
      <tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS" color="#000099">Confirm 
          password:</font></td>
        <td width="62%"><%=validator.getError("passwordTwo")%> 
          <input type="password" name="passwordTwo" size="30" value="<%= validator.getPasswordTwo()%>"/>
        </td>
      </tr>
      <tr> 
	
	
	
	
	</table>
	<br>

    <center>
      <input type="Submit" value="Step Two" name="Submit">
      <input type="Reset" name="Reset" value="Clear Form">
    </center>
    </center>
  


</form>
<div align="center"> <br>
  <br>
  <a href="../frame.html"><font face="Comic Sans MS" size="2">Return 
  to main index</font></a><br>
  <br>
</div>
</body>
</html>
