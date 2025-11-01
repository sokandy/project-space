<%
String userID = (String) session.getAttribute("userID");
%>

<body bgcolor="#CCCCCC">
<br>
<center>
<form method="POST" action="proselect.jsp">
    <p><font size="+2"><b><font face="Comic Sans MS" color="#000099">Main page</font></b></font></p>
<p><font face="Comic Sans MS" color="#000099"><font size="3">Section:</font> </font> <font color="#000099" size="+1"> </font><font color="#000099"> 

<select name=section size="1">
    <option value="Notices">Notices</option>
    <option value="Motors">Motors</option>
    <option value="Jobs">Jobs</option>
    <option value="Services">Service Guide</option>
    </select>
</font></p>
<tr><td align="center" colspan="2"><input type="submit" value="Submit"></td></tr>
 

</form>
<br>


<br>

<font face="Comic Sans MS" color="#000099"><a href="../frame.html">Return to main index</a> </font>
<br>
<br>
</font></center>
