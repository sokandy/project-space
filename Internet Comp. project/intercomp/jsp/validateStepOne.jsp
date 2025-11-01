<jsp:useBean id="validator" class="logonBean.adduser" scope="request">
   <jsp:setProperty name="validator" property="*"/>
</jsp:useBean>

<% 
	//if there are errors:
	if(!validator.process()) 
	{
	
%> 
   <jsp:forward page="adduser.jsp"/>
<%	} 
	else
	//otherwise, continue to step two:
	{
%>
	<jsp:forward page="addUserToSystem.jsp"/>
<%	}
%>