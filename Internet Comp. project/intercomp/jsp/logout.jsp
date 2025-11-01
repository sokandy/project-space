<!-- 
File: logout.jsp
Written By: Dermot Carroll (CA4) (98680056) 
Final Year Project 2002
Description: This file expires an existing session for a user and enables a
different user to log in. The user must log in again in order to use the 
system.
-->
<%
   //expire the session:
   session.invalidate();
   //go back to the main index:
   response.sendRedirect("../frame.html");
%>   
