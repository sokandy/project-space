<!-- 
File: keepDestination.jsp
Written By: Dermot Carroll (CA4) (98680056) 
Final Year Project 2002 
Description: This file stores the target URL entered by a user if they
have not logged in so that when they do login, the target URL they 
specified will be loaded.
-->
<%! public void storeOriginalURL(javax.servlet.http.HttpServletRequest request,
								 javax.servlet.http.HttpSession session)
	{ 
		//store the parameters in string format:
        StringBuffer theBuffer = new StringBuffer(request.getRequestURI());
        java.util.Enumeration enum = request.getParameterNames();
        if(enum.hasMoreElements())
			theBuffer.append("?");
        
		while(enum.hasMoreElements())
		{
            String param = (String) enum.nextElement(); 
            theBuffer.append(param + "=" + request.getParameter(param) + "&");        
        }
        //set the string as a session variable:
        session.setAttribute("originalURL", theBuffer.toString());
    }
%>