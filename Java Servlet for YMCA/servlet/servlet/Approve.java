import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Approve extends HttpServlet
{

  String DRIVER_NAME ="sun.jdbc.odbc.JdbcOdbcDriver";
  String CONNECTION_URL = "jdbc:odbc:ymca";

  String FIELD_USER = "user";
  String ACTION = "action";
  String ACTION_Confirm = "Confirm";
  String ACTION_Approve = "Approve";
  
  public void doGet(HttpServletRequest req,
                    HttpServletResponse resp)
    throws ServletException, java.io.IOException
    {
      // Get form information
      resp.setContentType("text/html");

      // Create a PrintWriter to write the response
      java.io.PrintWriter out =
        new java.io.PrintWriter(resp.getOutputStream());


      
      String uri = req.getRequestURI();

                
      // Get the action command (if one exists)
      String action = getParameter(req, ACTION);
      
      try {

        // Figure out what was requested
        
        if ((action != null) &&
            action.equals(ACTION_Approve)) {
          Approve(out, req, uri);
        }
        else if ((action != null) &&
            action.equals(ACTION_Confirm)) {
          Confirm(out, req);
        }
            
      }
      catch (Exception ex) {
        // Catch any exceptions and send the stack trace back
        // to the client
        ex.printStackTrace(out);
      }

      // Set the response header to force the browser to
      // load the html from the Web instead of it's cache
      resp.setHeader("Expires", "Tues, 01 Jan 1980 00:00:00 GMT");
      
      // Wrap up
      out.flush();
      out.close();
    }
  
  /**
    * <p>Performs the HTTP POST operation
    *
    * @param req The request from the client
    * @param resp The response from the servlet
    */
  public void doPost(HttpServletRequest req,
                     HttpServletResponse resp)
    throws ServletException, java.io.IOException
    {
      // Same as get
      doGet(req, resp);
    }
  
  /**
    * <p>Gets the given parameter from the request header
    *
    * @param req Request from the client
    * @param param Parameter to get
    * @return The parameter value or null if not found
    */
  private String getParameter(HttpServletRequest req,
                              String param)
    {
      String value = null;
      String values[] = req.getParameterValues(param);
      if (values != null) {
        value = values[0];
        if (value != null) {
          value = value.trim();
        }
      }
      return value;
    }
  public void init(ServletConfig cfg)
    throws ServletException
    {
      super.init(cfg);

    }

  public void destroy()
    {
      super.destroy();
    }

  public void Approve(java.io.PrintWriter out, HttpServletRequest req, String uri)
    {
    	String user = getParameter(req, FIELD_USER);
	
	Connection con = null;
      	PreparedStatement ps = null;
      	ResultSet rs = null;
    	int i=0;
  	String a_id = null;
    	
    	try {
	       	Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		String sql = "SELECT c.course_id , description , p.app_id from course c, application a, applicant p" +
		" where app_hkid=? and c.course_id = a.course_id and p.app_id = a.app_id" +
		" and approve = 'N' and confirm = 'Y' and paid = 'N'";
        	
        	// String applicant_id;
  		ps = con.prepareStatement(sql);
  		ps.setString(1, user);
  		rs = ps.executeQuery();
  		
  		
  			
  		
  		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
		out.println("<TITLE></TITLE>");
		out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");
  		
  		out.println("<table border=0 width=722 cellspacing=1 cellpadding=1>");
  		out.println("<tr>");
 		out.println("<td width=181  bgcolor=#9B96D8 align=right><font face=Arial size=1 color=#FFFFFF>");
      		out.println("</td>");
   		out.println("</tr>");
		out.println("</table>");
		out.println("<table border=0 width=600>");
		out.println("<tr>");	
  		out.println("<td width=300 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Course ID</b></font></td>");
    		out.println("<td width=300 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Course Basic</b></font></td>");
    		out.println("</tr>");	
    		out.println("<tr valign=top bgcolor =#F3F4F5>");
  		while (rs.next()) {
  			
  			i++;
  			a_id = rs.getString("app_id");
		out.println("<tr>");	  			
    		out.println("<td width=100 bgcolor=#C0C0C0><font size=1 face=Arial color=#333333>" +
  			rs.getString("course_id") + "</font></td>");
  		out.println("<td width=100 bgcolor=#C0C0C0><font size=1 face=Arial color=#333333>" +
  			rs.getString("description") + "</font></td>");
  		out.println("</tr>");	
		}
    		out.println("</table>");		
  		out.println("<table border=0 width=722 cellspacing=1 cellpadding=1>");
		out.println("<tr>");
		out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>" +
		     "There are found " + i + " Records waiting approve</font></b></td>");
		out.println("</tr>");
  		out.println("</table>");
		out.println("</form></body></html>");
  	}
  	
  	catch (Exception ex) {
        // Ignore any errors
          out.println(ex.getMessage());
      	}
      	finally {
          try {
          // Always close properly
          if (rs != null) {
            rs.close();
          }
          if (ps != null) {
            ps.close();
          }
          if (con != null) {
            // Put the connection back into the pool
           con.close();
          }
        }
        catch (Exception ex) {
          // Ignore any errors here
          out.println(ex.getMessage());
        }
      }
      
      if (i != 0)
      	DisplayApp(out , a_id ,uri);
      
}    	

public void Confirm(java.io.PrintWriter out, HttpServletRequest req)
    {
	String user = getParameter(req, "APP_ID");
	
	
	Connection con = null;
	PreparedStatement ps = null;
      	
      	      	
      	try {
      		Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		
		String sql = "UPDATE application set approve = 'Y' where " +
		          "application.app_id=? and confirm = 'Y' and paid = 'N'";
		ps = con.prepareStatement(sql);
  		ps.setString(1, user);
  		int count = ps.executeUpdate();
  		
  		if (count > 0) {
  			out.println("<table border=0 width=643 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td width=290 bgcolor=#9B96D8><font face=Arial size=3 color=#FFFFFF>");
        		out.println("There are <bold>" + count + "</bold> record updated by your approve.");
  	  		out.println("Please use left screen try other operation.");
  	  		out.println("</td>");
  	  		out.println("</tr>");
  	  		out.println("</table>");
  		}
  		else
  		{	
  			out.println("<table border=0 width=643 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td width=290 bgcolor=#9B96D8><font face=Arial size=3 color=#FFFFFF>");
        		out.println("There are no record update by your approve.");
  	  		out.println("Please use left screen try other operation.");
  	  		out.println("</td>");
  	  		out.println("</tr>");
  	  		out.println("</table>");
  	}
	    }
    	catch (Exception ex) {
          out.println(ex.getMessage());
      	}
      	finally {
          try {
          if (ps != null) {
            ps.close();
          }
          if (con != null) {
            // Put the connection back into the pool
           con.close();
          }
        }
        catch (Exception ex) {
          // Ignore any errors here
          out.println(ex.getMessage());
        }
      }	
  }	

public void DisplayApp(java.io.PrintWriter out, String user, String uri)
    {
    	Connection con = null;
      	PreparedStatement ps = null;
      	ResultSet rs = null;
    	
    	try {
	       	Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		String sql = "SELECT * from applicant where applicant.app_id=?";
        
  		ps = con.prepareStatement(sql);
  		ps.setString(1, user);
  		rs = ps.executeQuery();
    	
    		ResultSetMetaData rsmd = rs.getMetaData();
    		int columnCount1 = rsmd.getColumnCount();
    	
    		out.println("<HTML>");
        	out.println("<HEAD>");
        	out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
  		out.println("<TITLE></TITLE>");
		out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");	  	
	  	
		out.println("<form method=POST action=\"" + uri + "\">");
		out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
		out.println("<tr>");
    		out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Applicant Information</font></b></td>");
  		out.println("</tr>");
		out.println("<tr>");
     		out.println("<input type=hidden name=APP_ID value=\"" + user + "\">");
     		out.println("<td width=250 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
 		out.println("<input type=submit name=" + ACTION +
	      		" value=\"" + ACTION_Confirm + "\">");
        	out.println("</font>");
 		out.println("</td>");
 	   	out.println("</tr>");
		out.println("</table>");
		out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
        	out.println("<tr>");
    		out.println("<td width=500 bgcolor=#9B96DD height=20><b><font face=Arial size=3 color=#666666>PERSONAL PARTICULARS</font></b></td>");
  		out.println("</tr>");
		out.println("</table>");
		out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
		out.println("<tr>");
		while (rs.next()) {
		for (int k = 0; k < columnCount1; k++) {
    		  out.println("<tr><td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>" +
    		        rsmd.getColumnLabel(k + 1) + "</b></font></td>");
    		  out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  			rs.getString(k + 1) + "</font></td></tr>");
  		     
                  }
    		}
        	out.println("</tr>");
  		out.println("</table>");
		out.println("</body></html>");	  	
	}
  	
  	catch (Exception ex) {
        // Ignore any errors
          out.println(ex.getMessage());
      	}
      	finally {
          try {
          // Always close properly
          if (rs != null) {
            rs.close();
          }
          if (ps != null) {
            ps.close();
          }
          if (con != null) {
            // Put the connection back into the pool
           con.close();
          }
        }
        catch (Exception ex) {
          // Ignore any errors here
          out.println(ex.getMessage());
        }
      }
    }
  
  

  /**
    * <p>Formats an error message for the client
    *
    * @param out Output stream
    * @param msg Error message
    */
  public void formatError(java.io.PrintWriter out,
                          String msg)
    {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet Connection Error</title>");
      out.println("</head>");
      out.println("<center>");
      out.println("<img src=\"/images/ServletConnectionHeader.jpg" +
                  "\">");
      out.println("<br>");
      out.println("<h1>Error:<br>");
      out.println(msg + "</h1>");
      out.println("<br><br>");
      out.println("Press the 'Back' button and correct the error");
      out.println("</center>");
    }



  
}