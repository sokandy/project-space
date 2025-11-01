import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class CourseConfirm extends HttpServlet
{

  String DRIVER_NAME ="sun.jdbc.odbc.JdbcOdbcDriver";
  String CONNECTION_URL = "jdbc:odbc:ymca";

  int Max = 10;	
  String APP_COURSEID;
  String cid;
  String ACTION = "action";	
  String ACTION_confirm = "Course Confirm And Send Acknowledgement";
  String ACTION_cancel  = "Course Cancel And Send Notification";
  String ACTION_back = "BACK";	
  
 
  public void doGet(HttpServletRequest req,
                    HttpServletResponse resp)
    throws ServletException, java.io.IOException
    {
      // Get form information
        
      APP_COURSEID = req.getParameter("selcourse");
        

      // Set the content type of the response
      resp.setContentType("text/html");

      // Create a PrintWriter to write the response
      java.io.PrintWriter out =
        new java.io.PrintWriter(resp.getOutputStream());
       
      String uri = req.getRequestURI();

                
      // Get the action command (if one exists)
      String action = getParameter(req, ACTION);
      
     
      
      try {
		
	if ((action != null) &&
            action.equals(ACTION_confirm)) {
          InsertConfirm(out, req, uri);
        }
        else if ((action != null) &&
            action.equals(ACTION_cancel)) {
          InsertCancel(out, req, uri);  
        } 
        else
          
          DisplayCourse(out, uri, APP_COURSEID, req);
            
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
   /**
    * <p>Get Course Name
    *
    * @param req Request from the client
    * @param param Parameter to get
    * @return The parameter value or null if not found
    */
 
  public void init(ServletConfig cfg)
    throws ServletException
    {
      super.init(cfg);

    }

  public void destroy()
    {
      super.destroy();
    }

  public void DisplayCourse(java.io.PrintWriter out, String uri, String courseid, HttpServletRequest req)
    {
	
	Connection con = null;
      	PreparedStatement ps = null;
      	ResultSet rs = null;	
        cid = courseid;
	if (cid == null) {
            cid = getParameter(req, "H_courseid");
	}
	String c_cancelled ="";
	String c_approved = "";
	String c_completed = "";
	String c_description = "";
	String c_deadline = "";
	String c_send = "";
	String c_acknowledgment = "";
	int count = 1;
	String waiting = "N";
	
      	      	
      	try {
      		Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		
		String sql = "select a.app_id, u.app_name, u.app_hkid, c.description, c.deadline, c.cancelled, c.course_id, a.confirm, c.approved, c.completed, a.send " +
                             " from application a, applicant u, course c " +
                             " where a.app_id = u.app_id and "+
                                    "a.course_id = c.course_id and " +
                                    "a.course_id = ? order by apply_id asc";  
		ps = con.prepareStatement(sql);
  		ps.setString(1, cid);
		rs = ps.executeQuery();
  		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
		out.println("<TITLE></TITLE>");
		out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");

  		if (rs.next()) {
		    
		    c_cancelled = rs.getString("cancelled");
		    c_approved =rs.getString("approved");
		    c_completed = rs.getString("completed");	
                    c_description = rs.getString("description");
		    c_deadline = rs.getString("deadline");	
		    c_send = rs.getString("send");
		    	
	            if (c_send.equals("W")) {
                         c_acknowledgment = "waiting";
                    } else if (c_send.equals("A")) {
                         c_acknowledgment = "accept";
                    } else if (c_send.equals("R")) {
                         c_acknowledgment = "reject";
                    } else {
                         c_acknowledgment = c_send;
                    }
		    out.println("<form method=POST action=\"" + uri + "\">");	
		    if (c_cancelled.equals("Y")) {
			out.println("<table border=0 width=730 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Course " + courseid + " - " + c_description + " has been cancelled !!!</font></b></td>");
  			out.println("</tr>");
                        //out.println("Course (" + courseid + ") " + c_description + " has been cancelled !!!");
		    } else if (c_completed.equals("Y")){
			out.println("<table border=0 width=730 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Course " + courseid + " - " + c_description + " has been completed !!!</font></b></td>");
  			out.println("</tr>");
		    } else if (c_approved.equals("Y")){
			out.println("<table border=0 width=730 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Course " + courseid + " - " + c_description + " being approved !!!</font></b></td>");
  			out.println("</tr>");	
		    } else {			
			out.println("<table border=0 width=730 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Course Confirmation For Course " + courseid + " - " + c_description + "</font></b></td>");
  			out.println("</tr>");
			out.println("<tr>");
    			out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Deadline on " + c_deadline + ", Max capacity [10], Min capacity [5] </font></b></td>");
  			out.println("</tr>");
			out.println("<tr>");
    			out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Applicant(s) In Waiting List Is Shown In Blue  </font></b></td>");
  			out.println("</tr>");
			out.println("<tr>");
     			out.println("<td width=290 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
       			out.println("<font face=Arial size=1 color=#FFFFFF>");
       			out.println("<input type=hidden name=APP_COURSEID value=\"" + APP_COURSEID + "\">");
			out.println("<input type=hidden name=H_courseid value=\"" + cid + "\">");
       			//out.println("<input type=hidden name=NAME value=\"" + APP_NAME + "\">");
       			out.println("<input type=submit name=" + ACTION +
		      		" value=\"" + ACTION_confirm + "\">");
      			out.println("</font> </td>");
 			out.println("<td width=241 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
 	  		out.println("<input type=submit name=" + ACTION +
		      		" value=\"" + ACTION_cancel + "\">");
        		out.println("</font>");
 			out.println("</td>");
 			out.println("<td width=181  bgcolor=#9B96D8 align=right><font face=Arial size=1 color=#FFFFFF>");
      			out.println("</td>");
   			out.println("</tr>");
			out.println("</table>");
                        }
  			out.println("<table border=0 width=730>");
  			out.println("<tr>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Item</b></font></td>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>HKID</b></font></td>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Name</b></font></td>");
			
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Being Confirm</b></font></td>");
			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Acknowdleged</b></font></td>");
    						
      			out.println("<tr valign=top bgcolor =#F3F4F5>");
			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					count + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("app_hkid") + "</font></td>");
    			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("app_name") + "</font></td>");
  			
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("confirm") + "</font></td>");
			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					c_acknowledgment + "</font></td></tr>");
  			
  	                while(rs.next()) {
                          c_send = rs.getString("send");
			  count++;
			  if (c_send.equals("W")) {
                              c_acknowledgment = "waiting";
                           } else if (c_send.equals("A")) {
                              c_acknowledgment = "accept";
                           } else if (c_send.equals("R")) {
                              c_acknowledgment = "reject";
                           } else {
                              c_acknowledgment = c_send;
                           }
			  if ((count > Max)) {
                             out.println("<tr valign=top bgcolor =#9B96DD>");
			     out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					count + "</font></td>");
  			     out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  			 		rs.getString("app_hkid") + "</font></td>");
    			     out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("app_name") + "</font></td>");
  			     out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("confirm") + "</font></td>");
			     out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					c_acknowledgment + "</font></td></tr>");
			  } else {
		   	  out.println("<tr valign=top bgcolor =#F3F4F5>");
			  out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					count + "</font></td>");
  			  out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("app_hkid") + "</font></td>");
    			  out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("app_name") + "</font></td>");
  			  //out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  			  //		rs.getString("course_id") + "</font></td>");
  			  //out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  			  //		rs.getString("description") + "</font></td>");
  			  //out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  			  //		rs.getString("start_date") + "</font></td>");
  			  out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("confirm") + "</font></td>");
			  out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					c_acknowledgment + "</font></td></tr>");
 			  }	
  		        }
			out.println("</table>");
			out.println("</form></body></html>");
		     }    
  		else {
			out.println("<table border=0 width=730 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>No one applied the course " + courseid + " - " + c_description + " up to this moment !!!</font></b></td>");
  			out.println("</tr>");
			out.println("</table>");
			out.println("</form></body></html>");
  	  		
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
   	
    };
  public void InsertConfirm(java.io.PrintWriter out, HttpServletRequest req, String uri)
    {
	
	cid = getParameter(req, "H_courseid");
        int count = 0;
	int accept = 0;
	int wait = 0;
	int upd = 0;
	Connection con = null;
      	PreparedStatement ps = null;
	ResultSet rs = null;	
              	
      	try {
	       	Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		String sql1 = "UPDATE course set approved = 'Y', cancelled = 'N' where course_id = ?";
		ps = con.prepareStatement(sql1);
  		ps.setString(1,cid);
		ps.executeUpdate();
		
		String sql2 = "select apply_id from application where course_id = ? order by apply_id asc";
                ps = con.prepareStatement(sql2);
		ps.setString(1,cid);
		rs = ps.executeQuery();
  		
  		if (rs.next()) {
		   
  		   count++;
		   String sql3 = "UPDATE application set confirm = 'Y', send = 'A' where apply_id = ?";
		   ps = con.prepareStatement(sql3);
		   ps.setString(1,rs.getString("apply_id"));	
		   upd = ps.executeUpdate();
		   accept++;	
		   while(rs.next()) {
			  count++;
			  String applyid = rs.getString("apply_id");
		          if ((count > Max)) {	
			      String sql4a = "UPDATE application set confirm = 'N', send = 'W' where apply_id = ?"; 
		              ps = con.prepareStatement(sql4a);					
  		  	      ps.setString(1,applyid);	
		              wait++;	
		          } else {
		              String sql4b = "UPDATE application set confirm = 'Y', send = 'A' where apply_id = ?"; 
		              ps = con.prepareStatement(sql4b);					
  		  	      ps.setString(1,applyid);	;
		              accept++;		
		      
		          }
		          upd = ps.executeUpdate();
		  }	
		} else {
		   out.println("no record for COURSE ID = " + cid);
		}

		out.println("<HTML>");
                out.println("<HEAD>");
                out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
          	out.println("<TITLE></TITLE>");
        	out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");	  	
	  	
	        out.println("<form method=POST action=\"" + uri + "\">");
	        out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
	
  	        out.println("<tr>");
    	        out.println("<td colspan=3 bgcolor=#8B9000 height=20><b><font face=Arial size=4 color=#666666>Course " + cid + " confirm open and acknowledgment has been sent out to applicants</font></b></td>");
  	        out.println("</tr>");
                out.println("<input type=hidden name=APP_COURSEID value=\"" + cid + "\">");
		out.println("<input type=hidden name=H_courseid value=\"" + cid + "\">");
		out.println("<tr>");
    	        out.println("<td colspan=3 bgcolor=#9B96D8 height=20><b><font face=Arial size=2 color=#666666>Total " + accept + " acceptance mails have been sent out to asking for interview.</font></b></td>");
  	        out.println("</tr>");
		out.println("<tr>");
    	        out.println("<td colspan=3 bgcolor=#9B96D8 height=20><b><font face=Arial size=2 color=#666666>Total " + wait + " waiting list mails have been sent out to notify applicants.</font></b></td>");
  	        out.println("</tr>");
		out.println("<tr><td width=241 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
 	  	out.println("<input type=submit name=" + ACTION +
		     		" value=\"" + ACTION_back + "\">");
        	out.println("</font>");
 		out.println("</td></tr>");
	        out.println("</Table>");
		 
  	    }
    	catch (Exception ex) {
          out.println(ex.getMessage());
	  out.println("Sorry, Server Is Busy, Please Registate Later.");	
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

  public void InsertCancel(java.io.PrintWriter out, HttpServletRequest req, String uri)
    {
	
	cid = getParameter(req, "H_courseid");
       	int reject = 0;
	Connection con = null;
      	PreparedStatement ps = null;
	ResultSet rs = null;	
              	
      	try {
	       	Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		String sql5 = "UPDATE course set approved = 'N', cancelled = 'Y' where course_id = ?";
		ps = con.prepareStatement(sql5);
  		ps.setString(1,cid);
		ps.executeUpdate();
		
		String sql6 = "UPDATE application set confirm = 'N', send = 'R' where course_id = ?";
		
		ps = con.prepareStatement(sql6);
  		ps.setString(1,cid);
		reject = ps.executeUpdate();
		
		out.println("<HTML>");
                out.println("<HEAD>");
                out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
          	out.println("<TITLE></TITLE>");
        	out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");	  	
	  	
	        out.println("<form method=POST action=\"" + uri + "\">");
	        out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
	
  	        out.println("<tr>");
    	        out.println("<td colspan=3 bgcolor=#8B9000 height=20><b><font face=Arial size=4 color=#666666>Course " + cid + " was cancelled and acknowledgment has been sent out to applicants</font></b></td>");
  	        out.println("</tr>");
                out.println("<input type=hidden name=APP_COURSEID value=\"" + cid + "\">");
		out.println("<input type=hidden name=H_courseid value=\"" + cid + "\">");
		out.println("<tr>");
    	        out.println("<td colspan=3 bgcolor=#9B96D8 height=20><b><font face=Arial size=2 color=#666666>Total " + reject + " mails have been sent out to notify the course cancellation.</font></b></td>");
  	        out.println("</tr>");
		out.println("<tr><td width=241 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
 	  	out.println("<input type=submit name=" + ACTION +
		     		" value=\"" + ACTION_back + "\">");
        	out.println("</font>");
 		out.println("</td></tr>");
	        out.println("</Table>");
  	  		 
  	    }
    	catch (Exception ex) {
          out.println(ex.getMessage());
	  out.println("Sorry, Server Is Busy, Please Registate Later.");	
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