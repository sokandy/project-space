import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class CheckApplyProcess extends HttpServlet
{

  String DRIVER_NAME ="sun.jdbc.odbc.JdbcOdbcDriver";
  String CONNECTION_URL = "jdbc:odbc:ymca";

  String APP_HKID;
  String APP_COURSEID;
  
  public void doGet(HttpServletRequest req,
                    HttpServletResponse resp)
    throws ServletException, java.io.IOException
    {
      // Get form information
        APP_HKID     = req.getParameter("checkhkid");
        APP_COURSEID = req.getParameter("checkcourseid");
        

      // Set the content type of the response
      resp.setContentType("text/html");

      // Create a PrintWriter to write the response
      java.io.PrintWriter out =
        new java.io.PrintWriter(resp.getOutputStream());
       
      String uri = req.getRequestURI();

                
      // Get the action command (if one exists)
      //String action = getParameter(req, ACTION);
      
      try {

        DisplayStatus(out, uri, APP_HKID, APP_COURSEID);
            
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

  public void DisplayStatus(java.io.PrintWriter out, String uri, String hkid, String courseid)
    {
	
	Connection con = null;
      	PreparedStatement ps = null;
      	ResultSet rs = null;	
        String enrollstatus = "";
	String coursestatus = "";
	String paymentstatus = "";
        String cid = courseid;
        String chkid = hkid;
	String a_approve = "";
	String c_cancelled ="";
	String a_confirm = "";
	String a_paid = "";
	//out.println("cid = " + cid);
	//out.println("hkid = " + chkid);
      	
      	      	
      	try {
      		Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		String sql = "";
                if (courseid.equals("ALL")) {
		       //out.println("sql = 1");
		       sql = "select u.app_name, c.description, c.start_date, c.cancelled, c.course_id, a.approve, a.confirm, a.paid " +
                             " from application a, applicant u, course c " +
                             " where a.app_id = u.app_id and "+
                                    "a.course_id = c.course_id and " +
                                    "u.app_hkid = ?";  
		       ps = con.prepareStatement(sql);
  		       ps.setString(1, chkid);
		       
		}
                else {
		       //out.println("sql=2");
                       sql = "select u.app_name, c.description, c.start_date, c.cancelled, c.course_id, a.approve, a.confirm, a.paid " +
                             " from application a, applicant u, course c " +
                             " where a.app_id = u.app_id and "+
                                    "a.course_id = c.course_id and " +
                                    "u.app_hkid = ? and a.course_id = ?";  
		       ps = con.prepareStatement(sql);
  		       ps.setString(1, chkid);
	               ps.setString(2, cid);
		}
		
  		rs = ps.executeQuery();
  		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
		out.println("<TITLE></TITLE>");
		out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");

  		if (rs.next()) {
			//out.println("have record");
                	a_approve = rs.getString("approve");
			//out.println("approve = " + a_approve);
                        c_cancelled = rs.getString("cancelled");
			//out.println("cancelled = " + c_cancelled);
      			a_confirm = rs.getString("confirm");
			//out.println("confirm = " + a_confirm);
			a_paid = rs.getString("paid");
			//out.println("paid = " + a_paid);
			if (a_confirm.equals("Y") && a_approve.equals("N")) {
			    enrollstatus = "Waiting For Interview";
			    //out.println("enroll = " + enrollstatus);			
			} 
			else if (a_confirm.equals("Y") && a_approve.equals("Y")) {
			   enrollstatus = "Approved";
			   //out.println("enroll = " + enrollstatus);	
			}
			else {
 			    enrollstatus = "In Progress";
			    //out.println("enroll = " + enrollstatus);
		        }	
			if (a_approve.equals("Y")) {
			    if (a_paid.equals("N")) {
				paymentstatus = "Outstanding";
				//out.println("payment = " + paymentstatus);
			    } else {
				paymentstatus = "Settled";
				//out.println("payment = " + paymentstatus);
			    }
			} else {
				paymentstatus = "N/A";
				//out.println("payment = " + paymentstatus);
			}
			if (c_cancelled.equals("Y")) {
			    coursestatus = "Cancelled";
			    enrollstatus = "Cancelled";
			    paymentstatus = "Cancelled";	
			    //out.println("course = " + coursestatus);
			} else {
			    coursestatus = "Open";
			    //out.println("course = " + coursestatus);
			}				
						
                        out.println("<form method=POST action=\"" + uri + "\">");
			out.println("<table border=0 width=722 cellspacing=1 cellpadding=1>");
  			out.println("<tr>");
    			out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Enrollment Status</font></b></td>");
  			out.println("</tr>");
			out.println("<tr>");
     			//out.println("<td width=290 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
       			//out.println("<font face=Arial size=1 color=#FFFFFF>");
       			//out.println("<input type=hidden name=HKID value=\"" + APP_HKID + "\">");
       			//out.println("<input type=hidden name=NAME value=\"" + APP_NAME + "\">");
       			//out.println("<input type=submit name=" + ACTION +
		      	//	" value=\"" + ACTION_Print + "\">");
      			//out.println("</font> </td>");
 			//out.println("<td width=241 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
 	  		//out.println("<input type=submit name=" + ACTION +
		      	//	" value=\"" + CONFIRM_Refund + "\">");
        		//out.println("</font>");
 			//out.println("</td>");
 			out.println("<td width=181  bgcolor=#9B96D8 align=right><font face=Arial size=1 color=#FFFFFF>");
      			out.println("</td>");
   			out.println("</tr>");
			out.println("</table>");
  			out.println("<table border=0 width=723>");
  			out.println("<tr>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>HKID</b></font></td>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Name</b></font></td>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Course ID</b></font></td>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Course Name</b></font></td>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Start Date</b></font></td>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Course Status</b></font></td>");
			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Enrollment Status</b></font></td>");
    			out.println("<td width=50 bgcolor=#C0C0C0><font face=Arial color=#333333 size=1><b>Payment Status</b></font></td></tr>");
			
      			out.println("<tr valign=top bgcolor =#F3F4F5>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					chkid + "</font></td>");
    			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("app_name") + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("course_id") + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("description") + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("start_date") + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					coursestatus + "</font></td>");
			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					enrollstatus + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					paymentstatus + "</font></td></tr>");
  	                while(rs.next()) {
			a_approve = rs.getString("approve");
			c_cancelled = rs.getString("cancelled");
			a_confirm = rs.getString("confirm");
			a_paid = rs.getString("paid");
			
			if (a_confirm.equals("Y") && a_approve.equals("N")) {
			    enrollstatus = "Waiting For Interview";
			    //out.println("enroll = " + enrollstatus);			
			} 
			else if (a_confirm.equals("Y") && a_approve.equals("Y")) {
			   enrollstatus = "Approved";
			   //out.println("enroll = " + enrollstatus);	
			}
			else {
 			    enrollstatus = "In Progress";
			    //out.println("enroll = " + enrollstatus);
		        }	
			if (a_approve.equals("Y")) {
			    if (a_paid.equals("N")) {
				paymentstatus = "Outstanding";
				//out.println("payment = " + paymentstatus);
			    } else {
				paymentstatus = "Settled";
				//out.println("payment = " + paymentstatus);
			    }
			} else {
				paymentstatus = "N/A";
				//out.println("payment = " + paymentstatus);
			}
			if (c_cancelled.equals("Y")) {
			    coursestatus = "Cancelled";
			    enrollstatus = "Cancelled";
			    paymentstatus = "Cancelled";	
			    //out.println("course = " + coursestatus);
			} else {
			    coursestatus = "Open";
			    //out.println("course = " + coursestatus);
			}		
		   	out.println("<tr valign=top bgcolor =#F3F4F5>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					chkid + "</font></td>");
    			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("app_name") + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("course_id") + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("description") + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					rs.getString("start_date") + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					coursestatus + "</font></td>");
			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					enrollstatus + "</font></td>");
  			out.println("<td width=50><font size=1 face=Arial color=#333333>" +
  					paymentstatus + "</font></td></tr>");
  		    }
			out.println("</table>");
			out.println("</form></body></html>");
  		}    
  		else {
			out.println("Cannot found any course from your ID.");
  	  		out.println("Please use Back arrow to back previous screen try again.");
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