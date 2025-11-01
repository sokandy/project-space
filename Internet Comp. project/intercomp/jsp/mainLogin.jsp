<%@ page import="java.util.Enumeration"%>
<%@ include file="./keepDestination.jsp"%>
<%
    String originalURL = (String) session.getAttribute("originalURL");
    if(originalURL == null || originalURL.trim().length() == 0)
	{
        storeOriginalURL(request, session);
        
    }
	else
	{
		//login again:
        out.println("<center><font face=\"Comic Sans MS\" color=\"red\" size=\"+1\"><br>Incorrect  username/password. Please try again...</font></center>");
    }
%>
<body bgcolor="#CCCCCC">
<br>
<center>
<form method="POST" action="processLogon1.jsp">
    <p><font size="+2"><b><font face="Comic Sans MS" color="#000099">Login page</font></b></font></p>
<p><font face="Comic Sans MS" color="#000099"><font size="3">Username:</font> </font> <font color="#000099" size="+1"> </font><font color="#000099"> 
<input type="text" name="userID" size="15">
</font></p>
<p align="center"><font face="Comic Sans MS" color="#000099"> Password: </font> 
<input type="password" name="pwd" size="15">
</p>
<tr><td align="center" colspan="2"><input type="submit" value="Submit"></td></tr>

</form>
<!-- <%=session.getAttribute( "originalURL" )%>  -->


<br><br><br>
<font face="Comic Sans MS" color="#000099"><a href="../frame.html">Return to main index</a> </font>
<br>
<br>
</font></center>
