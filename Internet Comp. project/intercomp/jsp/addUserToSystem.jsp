<jsp:useBean id="validator" class="logonBean.adduser" scope="request"/>
<%@ page import="logonBean.*"%>
<% 
	//get all the data from step two:
	String username = validator.getUserID();
	String password = validator.getPasswordOne();
	String firstName = validator.getFirstName();
	String lastName = validator.getLastName();
	String homePhone = validator.getHomePhoneNumber();
	String emailAddress = validator.getEmail();
   
   ParseUsersXML usersXML = new ParseUsersXML();
%>
<% 
   //add the username and password to the users XML file:
   usersXML.addUser(username, password, firstName, lastName, homePhone, emailAddress);
   
%>
   <jsp:forward page="addUserDone.jsp"/>
