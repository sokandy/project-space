<%@ page import="logonBean.*"%>
<jsp:useBean id="selector" scope="request" class="logonBean.selector">
<jsp:setProperty name="selector" property="*"/>
</jsp:useBean>

<%
  String xmlfile = selector.getSection();
  String userid = (String) session.getAttribute("userID");
  String title = selector.getTitle();
  String subsection = selector.getSubselect();
  String body = selector.getBody();
  String prio = selector.getPrio();
  String day = selector.getDay();
  
  ParsePostXML addpost = new ParsePostXML(xmlfile);
  addpost.addPost(userid,title,subsection,body,prio,day);
%> 

<jsp:forward page="result1.jsp"/>


