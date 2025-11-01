<%
String section = request.getParameter("section");
%>

<body bgcolor="#CCCCCC">
<center>

<br>
<font color="#000099" size="+2" face="Comic Sans MS"><b><%=section%> Post: </b></font><br/>

<form method="POST" action="prosub.jsp">
<br><br>
<table width="49%" border="0">
    <tr>
        <td width="49%"><font face="Comic Sans MS"color="#000099">Title
          </font><font face="Comic Sans MS" size="2"></font><font face="Comic Sans MS"color="#000099">: 
          </font></td>
        <td width="51%"><input type="text" name="title" size="15"></td>
	  </tr>
      <tr>
        <td width="49%"><font face="Comic Sans MS"color="#000099">Sub  
          section</font><font face="Comic Sans MS" size="2"></font><font face="Comic Sans MS"color="#000099">: 
          </font></td>
        <td width="51%">
        <%
	if (section.equals("Notices"))
	{
	%>
	<select name=subselect size="1">
    	<option value="Anniversaries">Anniversaries</option>
    	<option value="Births">Births</option>
    	<option value="Engagments">Engagments</option>
    	<option value="Public Notices">Public Notices</option>
    	<option value="Tender">Tender</option>
    	<option value="Weddings">Weddings</option>
    	</select>
        
        <%
        }
        %>
        
        <%
        if (section.equals("Motors"))
	{
	%>
	
	<select name=subselect size="1">
          <option value="aircraft">aircraft</option>
          <option value="motorcycle">motorcycle</option>
          <option value="bicycle">bicycle</option>
          <option value="auto">auto</option>
          <option value="atv">atv</option>
    	</select>
        
        <%
        }
        %>
        
        <%
        if (section.equals("Jobs"))
	{
	%>
	
        <select name=subselect size="1">
          <option value="Engineering">Engineering</option>
    	  <option value="Finance">Finance</option>
    	  <option value="General">General</option>
    	  <option value="IT">IT</option>
    	</select>

        
        <%
        }
        %>
        
        <%
        if (section.equals("Services"))
	{
	%>
	
	<select name=subselect size="1">
         <option value="Accounting Taxation">Accounting Taxation</option>
         <option value="Business Centres">Business Centres</option>
         <option value="Computer Service">Computer Service</option>
    	 <option value="Decoration">Decoration</option>
    	 <option value="Domestic">Domestic</option>
    	 <option value="Travel">Travel</option>
        </select>
        
        <%
        }
        %>
          
        </td>
	  
	  </tr>

       <tr>
       <td width="49%"><font face="Comic Sans MS"color="#000099">Priority  
          </font><font face="Comic Sans MS" size="2"></font><font face="Comic Sans MS"color="#000099">: 
          </font></td>
        <td width="51%">
   	   <select name=prio size="1">
         	<option value="1">1</option>
         	<option value="2">2</option>
         	<option value="3">3</option>
         	<option value="4">4</option>
         	<option value="5">5</option>
         	<option value="6">6</option>
         	<option value="7">7</option>
         	<option value="8">8</option>
         	<option value="9">9</option>
           </select>
   	 </td>
   	 </tr>
   	 
   	 <tr>
       <td width="49%"><font face="Comic Sans MS"color="#000099">Day of Post  
          </font><font face="Comic Sans MS" size="2"></font><font face="Comic Sans MS"color="#000099">: 
          </font></td>
        <td width="51%">
   	   <select name=day size="1">
         	<option value="1">1</option>
         	<option value="2">2</option>
         	<option value="3">3</option>
         	<option value="4">4</option>
         	<option value="5">5</option>
           </select>
   	 </td>
   	 </tr>
   	
	<tr>
        <td width="49%"><font face="Comic Sans MS"color="#000099">Body
          </font><font face="Comic Sans MS" size="2"></font><font face="Comic Sans MS"color="#000099">: 
          </font></td>
        
		
        <td width="51%"><textarea name="body" cols="35" rows="4"></textarea></td>
	  
	  </tr>
    
<input type="hidden" name="section" value=<%=section%>>

</table>
	<br>

    <center>
      <input type="Submit" value="Submit">
      <input type="Reset" name="Reset" value="Clear Form">
    </center>
 
</form>
<br>

<br>

<font face="Comic Sans MS" color="#000099"><a href="../frame.html">Return to main index</a> </font>
<br>
<br>
</font></center>


