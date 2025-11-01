import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Refund extends HttpServlet
{

  String DRIVER_NAME ="sun.jdbc.odbc.JdbcOdbcDriver";
  String CONNECTION_URL = "jdbc:odbc:ymca";

  String ACTION = "action";
  String ACTION_Print = "print";
  
  String ACTION_Refund = "Refund";
  String CONFIRM_Refund = "Confirm Payment";
  
  String FIELD_USER = "user";

  public void doGet(HttpServletRequest req,
                    HttpServletResponse resp)
    throws ServletException, java.io.IOException
    {
      // Set the content type of the response
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
                 action.equals(ACTION_Refund)) {
          Refund(out, req, uri);  
        }
         else if ((action != null) &&
                 action.equals(ACTION_Print)) {
          Print(out,req);  
        }
        else if ((action != null) &&
                 action.equals(CONFIRM_Refund)) {
          Confirm_Refund(out,req);  
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

  
  
  public void Confirm_Refund(java.io.PrintWriter out, HttpServletRequest req)
    {
	String user = getParameter(req, "HKID");
	
	
	Connection con = null;
	PreparedStatement ps = null;
      	
      	      	
      	try {
      		Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		
		String sql = "UPDATE application, course set cancel_paid = 'Y' where " +
		          "application.app_id=? and course.course_id = application.course_id" +
			  " and cancelled = 'Y' and cancel_paid = 'N'";
		ps = con.prepareStatement(sql);
  		ps.setString(1, user);
  		int count = ps.executeUpdate();
  		
  		if (count > 0) {
  			out.println(count + " records updated");
  		}
  		else
  		{	out.println("No record update");
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
  
  public void Refund(java.io.PrintWriter out, HttpServletRequest req, String uri)
    {
	String user = getParameter(req, FIELD_USER);
	
	Connection con = null;
      	PreparedStatement ps = null;
      	ResultSet rs = null;
      	
      	try {
	       	Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		String sql = "SELECT applicant.app_id , app_name , course.course_id , description" +
		" , cancelled , fee from course, application, applicant" +
		" where application.app_id=? and course.course_id = application.course_id" +
		" and application.app_id = applicant.app_id and cancelled = 'Y' and cancel_paid = 'N'";
        
  		ps = con.prepareStatement(sql);
  		ps.setString(1, user);
  		rs = ps.executeQuery();

	  	out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
		out.println("<TITLE></TITLE>");
		out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");

		int total = 0;
	  	int pay = 0;
  		if (rs.next()) {
  			String APP_HKID = rs.getString("app_id");
  			String APP_NAME = rs.getString("app_name");
  			pay = rs.getInt(6);
  			total = total + pay;
	  	  	out.println("<form method=POST action=\"" + uri + "\">");
			out.println("<table border=0 width=722 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Fee Payment</font></b></td>");
  			out.println("</tr>");
			out.println("<tr>");
     			out.println("<td width=290 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
       			out.println("<font face=Arial size=1 color=#FFFFFF>");
       			out.println("<input type=hidden name=HKID value=\"" + APP_HKID + "\">");
       			out.println("<input type=hidden name=NAME value=\"" + APP_NAME + "\">");
       			out.println("<input type=submit name=" + ACTION +
		      		" value=\"" + ACTION_Print + "\">");
      			out.println("</font> </td>");
 			out.println("<td width=241 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
 	  		out.println("<input type=submit name=" + ACTION +
		      		" value=\"" + CONFIRM_Refund + "\">");
        		out.println("</font>");
 			out.println("</td>");
 			out.println("<td width=181  bgcolor=#9B96D8 align=right><font face=Arial size=1 color=#FFFFFF>");
      			out.println("</td>");
   			out.println("</tr>");
			out.println("</table>");
  			out.println("<table border=0 width=723>");
  			out.println("<tr>");
    			out.println("<td width=63 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>HKID</b></font></td>");
    			out.println("<td width=63 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Name</b></font></td>");
    			out.println("<td width=54 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Course ID</b></font></td>");
    			out.println("<td width=54 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Course Basic</b></font></td>");
    			out.println("<td width=54 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Approved</b></font></td>");
    			out.println("<td width=54 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Paid Amount</b></font></td></tr>");
      			out.println("<tr valign=top bgcolor =#F3F4F5>");
  			out.println("<td width=63><font size=1 face=Arial color=#333333>" +
  					APP_HKID + "</font></td>");
    			out.println("<td width=63><font size=1 face=Arial color=#333333>" +
  					APP_NAME + "</font></td>");
  			out.println("<td width=54><font size=1 face=Arial color=#333333>" +
  					rs.getString("course_id") + "</font></td>");
  			out.println("<td width=54><font size=1 face=Arial color=#333333>" +
  					rs.getString("description") + "</font></td>");
  			out.println("<td width=54><font size=1 face=Arial color=#333333>" +
  					rs.getString("cancelled") + "</font></td>");
  			out.println("<td width=54><font size=1 face=Arial color=#333333>" +
  					pay + "</font></td></tr>");
		   while(rs.next()) {
		   	pay = rs.getInt(6);
  			total = total + pay;
    			out.println("<tr valign=top bgcolor =#F3F4F5>");
  			out.println("<td width=63><font size=1 face=Arial color=#333333>" +
  					APP_HKID + "</font></td>");
    			out.println("<td width=63><font size=1 face=Arial color=#333333>" +
  					APP_NAME + "</font></td>");
  			out.println("<td width=54><font size=1 face=Arial color=#333333>" +
  					rs.getString("course_id") + "</font></td>");
  			out.println("<td width=54><font size=1 face=Arial color=#333333>" +
  					rs.getString("description") + "</font></td>");
  			out.println("<td width=54><font size=1 face=Arial color=#333333>" +
  					rs.getString("cancelled") + "</font></td>");
  			out.println("<td width=54><font size=1 face=Arial color=#333333>" +
  					pay + "</font></td></tr>");
  		    }
			out.println("</table>");
			out.println("Total : " + total);
			out.println("</form></body></html>");
  		}    
  		else {
  			out.println("<table border=0 width=643 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td width=290 bgcolor=#9B96D8><font face=Arial size=3 color=#FFFFFF>");
        		out.println("Cannot found any cancelled course from your ID.");
  	  		out.println("Please use Back arrow to back previous screen try again.");
  	  		out.println("</td>");
  	  		out.println("</tr>");
  	  		out.println("</table>");
			
  		}
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
  
  

  public void Print(java.io.PrintWriter out, HttpServletRequest req)
    {
    	
      String param = getParameter(req, "NAME");	
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Advice Printing Service</title>");
      out.println("</head>");
      out.println("<center>");
      out.println("<table border=0 width=643 cellspacing=1 cellpadding=1>");
      out.println("<tr>");
      out.println("<td width=290 bgcolor=#9B96D8><font face=Arial size=3 color=#FFFFFF>");
      out.println("<h1>" + param + " Advices Print Completed<br>");
      out.println("</h1>");
      out.println("<br><br>");
      out.println("Press the 'Back' button for return");
      out.println("</center>");
      out.println("</td>");
      out.println("</tr>");
      out.println("</table></html>");
      
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