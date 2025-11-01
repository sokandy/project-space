<%
        String theURL = ""; 
	String user_id = (String) session.getAttribute("userID");
	//if no session for the user:
	if (user_id == null) 
	{
       
%>
     <!-- <%=session.getAttribute( "userID" )%>   -->
     <jsp:include page="mainLogin.jsp" flush="true"/>
<%
	}
   
	if (user_id != null)
	{
          theURL = new String(user_id + ".xml");
%>
     
     <jsp:forward page="selection.jsp"/>
<% 
    return;
   }
%>