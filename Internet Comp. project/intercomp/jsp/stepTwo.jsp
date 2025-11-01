<!-- 
File: stepTwo.jsp
Written By: Dermot Carroll (CA4) (98680056) 
Final Year Project 2002 
Description: This file displays the second of two sign up pages for new users to
the system. The file uses Java Beans 'StepTwo.java' and 'StepOne.java' to 
validate the data entered. The form submitted is passed to 'validateStepTwo.jsp' 
for validation. Useful error messages are also displayed if errors occur.
-->
<%@ taglib uri="as-taglib.tld" prefix="as" %>
<%@ page errorPage="error.jsp" %>
<jsp:useBean id="validator" class="ting.StepOne" scope="request"/>
<jsp:useBean id="validator2" class="ting.StepTwo" scope="request"/>
<html>
<HEAD>
<META name="description" content="Register New User.">
<META name="keywords" content="auction, register, bidding">
<title>Register new user</title>
</HEAD>
<body bgcolor="#CCCCCC">
<form name="registration" method="post" action="validateStepTwo.jsp">
<center>
<p><font size="+2"><b><font face="Comic Sans MS" color="#000099">Register new user (Step 2 of 2)</font></b></font></p>


  
<font face="Comic Sans MS" size="2">(Fields marked with <font color="#FF0000" size="3">*</font> are required)</font> 
   
	<br>
	<br>
	<br>
     
    <table width="61%" border="0" height="224">
      <tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS" size="3" color="#000099">Password:</font></td>
        <td width="62%"><as:error><%= validator2.getError("passwordOne")%></as:error> 
          <input type="password" name="passwordOne" size="30" value="<%= validator2.getPasswordOne()%>"/>
        </td>
      </tr>
      <tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS" color="#000099">Confirm 
          password:</font></td>
        <td width="62%"><as:error><%= validator2.getError("passwordTwo")%></as:error> 
          <input type="password" name="passwordTwo" size="30" value="<%= validator2.getPasswordTwo()%>"/>
        </td>
      </tr>
      <tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS" color="#000099">Street 
          Address: </font></td>
        <td width="62%"><as:error><%= validator2.getError("street")%></as:error> 
          <input type="text" name="street" size="40" value="<%= validator2.getStreet()%>"/>
        </td>
      </tr>
      <tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS" color="#000099">Town:</font></td>
        <td width="62%"><as:error><%= validator2.getError("town")%></as:error> 
          <input type="text" name="town" size="25" value="<%= validator2.getTown()%>"/>
        </td>
      </tr>
      <tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS" color="#000099">City:</font></td>
        <td width="62%"><as:error><%= validator2.getError("city")%></as:error> 
          <input type="text" name="city" size="25" value="<%= validator2.getCity()%>"/>
        </td>
      </tr>
      <tr> 
        <td width="38%"><font face="Comic Sans MS" color="#000099"> Postcode:</font></td>
        <td width="62%"><as:error><%= validator2.getError("postcode")%></as:error> 
          <input type="text" name="postcode" size="5" value="<%= validator2.getPostcode()%>"/>
        </td>
      </tr>
      <tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS" color="#000099">Country:</font></td>
        <td width="62%"><as:error><%= validator2.getError("country")%></as:error> 
          <!--<input type="text" name="country" size="25" value="<%= validator2.getCountry()%>"/>  -->
		  <select name="country">
  
  <option value="Afghanistan" Afghanistan</option>
  <option value="Albania"> Albania</option>
  <option value="Algeria">Algeria</option>
  <option value="American Samoa">American Samoa</option>
  <option value="Andorra">Andorra</option>
  <option value="Angola">Angola</option>
  <option value="Anguilla"> Anguilla</option>
  <option value="Antarctica"> Antarctica</option>
  <option value="Antigua and Barbuda">Antigua and Barbuda</option>
  <option value="Argentina">Argentina</option>
  <option value="Armenia">Armenia</option>
  <option value="Aruba">Aruba</option>
  <option value="Australia">Australia</option>
  <option value="Austria">Austria</option>
  <option value="Azerbaijan">Azerbaijan</option>
  <option value="Bahamas">Bahamas</option>
  <option value="Bahrain">Bahrain</option>
  <option value="Bangladesh">Bangladesh</option>
  <option value="Barbados">Barbados</option>
  <option value="Belarus">Belarus</option>
  <option value="Belgium">Belgium</option>
  <option value="Belize">Belize</option>
  <option value="Benin">Benin</option>
  <option value="Bermuda">Bermuda</option>
  <option value="Bhutan">Bhutan</option>
  <option value="Bolivia">Bolivia</option>
  <option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
  <option value="Botswana">Botswana</option>
  <option value="Brazil">Brazil</option>
  <option value="Bulgaria">Bulgaria</option>
  <option value="Canada">Canada</option>
  <option value="China">China</option>
  <option value="Cuba">Cuba</option>
  <option value="Cyprus">Cyprus</option>
  <option value="Czech Republic">Czech Republic</option>
  <option value="Denmark">Denmark</option>
  <option value="Egypt">Egypt</option>
  <option value="Finland">Finland</option>
  <option value="France">France</option>
  <option value="Germany">Germany</option>
  <option value="Greece">Greece</option>
  <option value="Hong Kong">Hong Kong</option>
  <option value="Hungary">Hungary</option>
  <option value="Iceland">Iceland</option>
  <option value="Ireland" selected>Ireland</option>
  <option value="Italy">Italy</option>
  <option value="Luxembourg">Luxembourg</option>
  <option value="Malta">Malta</option>
  <option value="Netherlands">Netherlands</option>
  <option value="Norway">Norway</option>
  <option value="Poland">Poland</option>
  <option value="Portugal">Portugal</option>
  <option value="Spain">Spain</option>
  <option value="Sri Lanka">Sri Lanka</option>
  <option value="Sweden">Sweden</option>
  <option value="Switzerland">Switzerland</option>
  <option value="Turkey">Turkey</option>
  <option value="United Kingdom">United Kingdom</option>
</select>
        </td>
      </tr>
      <tr> 
        <td width="38%"><font face="Comic Sans MS" size="2"><font color="#FF0000" size="3">*</font></font><font face="Comic Sans MS" color="#000099">Work 
          phone:</font></td>
        <td width="62%"><as:error><%= validator2.getError("workPhoneNumber")%></as:error> 
          <input type="text" name="workPhoneNumber" size="25" value="<%= validator2.getWorkPhoneNumber()%>"/>
        </td>
      </tr>
      <tr> 
        <td width="38%"><font face="Comic Sans MS" color="#000099">Home phone:</font></td>
        <td width="62%"> 
          <input type="text" name="homePhoneNumber" size="25" value="<%= validator2.getHomePhoneNumber()%>"/>
        </td>
      </tr>
    </table>
      
    <p> 
      <input type="Submit" value="Register" name="Submit">
      <input type="Reset" name="Reset" value="Clear Form">
    </p>
    <p>&nbsp; </p>
    </center>
    <center>
  </center>
  


  
  
  
  
  <!-- 
  take all the details from step one also: 
  -->
  <input type="hidden" name="userId" value="<%= validator.getUserID()%>">
  <input type="hidden" name="firstName" value="<%= validator.getFirstName()%>">
  <input type="hidden" name="lastName" value="<%= validator.getLastName()%>">
  <input type="hidden" name="email" value="<%= validator.getEmail()%>">

</form>

<div align="center"><a href="../../ItemsForSale/categories.xml"><font face="Comic Sans MS" size="2">Return 
  to main index</font></a><br>
  <br>
</div>
</body>
