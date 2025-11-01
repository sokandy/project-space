import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ApplyProcessv2 extends HttpServlet
{

  String DRIVER_NAME ="sun.jdbc.odbc.JdbcOdbcDriver";
  String CONNECTION_URL = "jdbc:odbc:ymca";

  String ACTION = "action";
  String subject = "Registration";
  String ACTION_Confirm = "Confirm";
  String ACTION_Correction = "Correction";
  String ACTION_Home = "Home";
  String APP_NAME;
  String APP_ID;
  String APP_HKID;
  String APP_SEX;
  String APP_TELNO;
  String APP_DOB;
  String APP_DOBDDMMYY;
  String APP_AGE;
  String APP_EMAIL;
  String APP_EDUCATE;
  String APP_JOB;
  String APP_COURSE;
  String APP_COURSENAME;
  String APP_ADDR;
  String APP_MEMID;
  
  public void doGet(HttpServletRequest req,
                    HttpServletResponse resp)
    throws ServletException, java.io.IOException
    {
      // Get form information
        APP_NAME    = req.getParameter("appname");
        String APP_HKIDN   = req.getParameter("apphkidn");
        String APP_HKIDC   = req.getParameter("apphkidc");
        String APP_HKIDH   = req.getParameter("apphkidh");
        APP_SEX            = req.getParameter("appsex");
        APP_TELNO          = req.getParameter("apptelno");
	String APP_DOBDD   = req.getParameter("appdobdd");
        String APP_DOBMM   = req.getParameter("appdobmm");
        String APP_DOBYY   = req.getParameter("appdobyy");	
        String APP_AGE1    = req.getParameter("appage1");
        String APP_AGE2    = req.getParameter("appage2");
        APP_EMAIL          = req.getParameter("appemail");
        APP_EDUCATE        = req.getParameter("appeducate");
        APP_JOB            = req.getParameter("appjob");
        APP_COURSE         = req.getParameter("appcourse");
	APP_ADDR	   = req.getParameter("appaddr");
        APP_MEMID	   = req.getParameter("appmemid");		
        
        APP_HKID  = APP_HKIDH + APP_HKIDN + APP_HKIDC;
        APP_ID    = APP_HKIDN;
        APP_AGE   = APP_AGE1 + APP_AGE2;
        APP_DOB   = APP_DOBDD + APP_DOBMM + APP_DOBYY;
        APP_DOBDDMMYY = APP_DOBDD + "/" + APP_DOBMM + "/" + APP_DOBYY;
      
      // Date inputDate = new Date();

      // Set the content type of the response
      resp.setContentType("text/html");

      // Create a PrintWriter to write the response
      java.io.PrintWriter out =
        new java.io.PrintWriter(resp.getOutputStream());


      APP_COURSENAME = getCourseName(out, APP_COURSE);
      
      String uri = req.getRequestURI();

                
      // Get the action command (if one exists)
      String action = getParameter(req, ACTION);
      
      try {

        // Figure out what was requested
        
        if ((action != null) &&
            action.equals(ACTION_Confirm)) {
          InsertApp(out, req, uri);
        }
        //else if ((action != null) &&
        //         action.equals(ACTION_Correction)) {
        //  ReEnterApp(out, uri);  
        //} 
        else
          DisplayApp(out, uri);
            
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
   private String getCourseName(java.io.PrintWriter out,String courseid)
    {

	Connection con = null;
      	PreparedStatement ps = null;
      	ResultSet rs = null;	
        String desc = "";
        String cid = courseid;
      	
      	      	
      	try {
      		Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		
		String sql = "select description from course where course_id =?";
		
		ps = con.prepareStatement(sql);
  		ps.setString(1, cid);
  		rs = ps.executeQuery();
  		
  		if (rs.next()) {
                	desc = rs.getString("description");
  	        }
                else {
                        desc = "unknown";
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
       return desc;
    }
//* end of getCourseName
  public void init(ServletConfig cfg)
    throws ServletException
    {
      super.init(cfg);

    }

  public void destroy()
    {
      super.destroy();
    }

  public void DisplayApp(java.io.PrintWriter out, String uri)
    {
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
  	out.println("<TITLE></TITLE>");
	out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");	  	
	  	
	out.println("<form method=POST action=\"" + uri + "\">");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
	//out.println("<table border=0 cellspacing=1 cellpadding=1>");
  	out.println("<tr>");
    	out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Applicant Information</font></b></td>");
  	out.println("</tr>");
	out.println("<tr>");
     	//out.println("<td width=250 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
       	//out.println("<font face=Arial size=1 color=#FFFFFF>");
       	out.println("<input type=hidden name=H_ID value=\"" + APP_ID + "\">");
       	out.println("<input type=hidden name=H_HKID value=\"" + APP_HKID + "\">");
	out.println("<input type=hidden name=H_NAME value=\"" + APP_NAME + "\">");
       	out.println("<input type=hidden name=H_SEX value=\"" + APP_SEX + "\">");
	out.println("<input type=hidden name=H_DOB value=\"" + APP_DOB + "\">");
	out.println("<input type=hidden name=H_TELNO value=\"" + APP_TELNO + "\">");
       	out.println("<input type=hidden name=H_AGE value=\"" + APP_AGE + "\">");
	out.println("<input type=hidden name=H_EMAIL value=\"" + APP_EMAIL + "\">");
       	out.println("<input type=hidden name=H_EDUCATE value=\"" + APP_EDUCATE + "\">");
	out.println("<input type=hidden name=H_COURSE value=\"" + APP_COURSE + "\">");
	out.println("<input type=hidden name=H_ADDR value=\"" + APP_ADDR + "\">");
	out.println("<input type=hidden name=H_MEMID value=\"" + APP_MEMID + "\">");
       	//out.println("<input type=submit name=" + ACTION +
	//     		" value=\"" + ACTION_Correction + "\">");
      	//out.println("</font> </td>");
 	out.println("<td width=250 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
 	out.println("<input type=submit name=" + ACTION +
	      		" value=\"" + ACTION_Confirm + "\">");
        out.println("</font>");
 	out.println("</td>");
 	//out.println("<td width=181  bgcolor=#9B96D8 align=right><font face=Arial size=1 color=#FFFFFF>");
      	//out.println("</td>");
   	out.println("</tr>");
	out.println("</table>");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
        out.println("<tr>");
    	out.println("<td width=500 bgcolor=#9B96DD height=20><b><font face=Arial size=3 color=#666666>PERSONAL PARTICULARS</font></b></td>");
  	out.println("</tr>");
	out.println("</table>");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
  			
        out.println("<tr>");
    	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Name</b></font></td>");
	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_NAME + "</font></td>");
        out.println("</tr><tr>");
    	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>HKID</b></font></td>");
	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_HKID + "</font></td>");
	out.println("</tr><tr>");
	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Sex</b></font></td>");
	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_SEX + "</font></td>");
	out.println("</tr><tr>");
    	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Contact Tel No</b></font></td>");
    	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_TELNO + "</font></td>");
	out.println("</tr><tr>");
	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Address</b></font></td>");
    	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_ADDR + "</font></td>");
        out.println("</tr><tr>");
        out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Date Of Birth</b></font></td>");
    	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_DOBDDMMYY + "</font></td>");
	out.println("</tr><tr>");
        out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Age</b></font></td>");
    	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_AGE + "</font></td>");
        out.println("</tr><tr>");
 	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>E-mail</b></font></td>");
	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_EMAIL + "</font></td>");
        out.println("</tr><tr>");
	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>YMCA Member ID</b></font></td>");
    	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_MEMID + "</font></td></tr>");
 	out.println("</table>");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
        out.println("<tr>");
 	out.println("<td width=500 bgcolor=#9B96DD height=20><b><font face=Arial size=3 color=#666666>QUALIFICATION</font></b></td>");
  	out.println("</tr>");
	out.println("</table>");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
 
    	out.println("<tr>");
	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Education Level</b></font></td>");
	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_EDUCATE + "</font></td>");
        out.println("</tr><tr>");
	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Occupation</b></font></td>");
      	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_JOB + "</font></td>");
        out.println("</tr>");
        out.println("</table>");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");	
	out.println("<tr>");
    	out.println("<td width=500 bgcolor=#9B96DD height=20><b><font face=Arial size=3 color=#666666>COURSE SELECTION</font></b></td>");
  	out.println("</tr>");
		
        out.println("</table>");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");	
	out.println("<tr>");
	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Course ID</b></font></td>");
	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_COURSE + "</font></td>");
        out.println("</tr><tr>");
	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Course Name</b></font></td>");
	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				APP_COURSENAME + "</font></td>");
        out.println("</tr>");
	out.println("</table>");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");	
        out.println("<tr>");
    	out.println("<td width=500 bgcolor=#9B86DD height=20><b><font face=Arial size=3 color=#666666>Click [BACK] Button For Correction</font></b></td>");
  	out.println("</tr>");
        out.println("</table>");
	
    };
	
  
  public void InsertApp(java.io.PrintWriter out, HttpServletRequest req, String uri)
    {
	
	APP_ID      = getParameter(req, "H_ID");
        APP_HKID    = getParameter(req, "H_HKID");
 	APP_NAME    = getParameter(req, "H_NAME");
        APP_TELNO   = getParameter(req, "H_TELNO");
	APP_SEX     = getParameter(req, "H_SEX");
	APP_AGE     = getParameter(req, "H_AGE");
        APP_DOB     = getParameter(req, "H_DOB");
	APP_EMAIL   = getParameter(req, "H_EMAIL");
        APP_EDUCATE = getParameter(req, "H_EDUCATE");
 	APP_COURSE  = getParameter(req, "H_COURSE");
	APP_MEMID   = getParameter(req, "H_MEMID");
 	APP_ADDR    = getParameter(req, "H_ADDR");	

	Connection con = null;
      	PreparedStatement ps = null;
	ResultSet rs = null;	
              	
      	try {
	       	Class.forName(DRIVER_NAME).newInstance();  
		con = DriverManager.getConnection(CONNECTION_URL);
		
		String sql = "SELECT * from applicant where app_id = ?";
		ps = con.prepareStatement(sql);
  		ps.setString(1, APP_ID);
  		rs = ps.executeQuery();
  		
  		if (!rs.next()) {
  		
		String sql1 = "INSERT into applicant" + "(app_id, app_hkid, app_name, mobile_no, sex, age, dob, email,education, member_id, address) " +
                             "values (?,?,?,?,?,?,?,?,?,?,?)";
		
		ps = con.prepareStatement(sql1);
  		ps.setString(1, APP_ID); 
                ps.setString(2, APP_HKID);
		ps.setString(3, APP_NAME);
                ps.setString(4, APP_TELNO);
                ps.setString(5, APP_SEX);
		ps.setString(6, APP_AGE);
                ps.setString(7, APP_DOB);
                ps.setString(8, APP_EMAIL); 
                ps.setString(9, APP_EDUCATE);
		ps.setString(10, APP_MEMID); 
                ps.setString(11, APP_ADDR);
		ps.execute();
		}

		String sql2 = "INSERT into application" + "(course_id, app_id, cancel_paid, paid) " +
                             "values (?,?,?,?)";
		
 		ps = con.prepareStatement(sql2);
		ps.setString(1,APP_COURSE);
		ps.setString(2,APP_ID);
		ps.setString(3,"N");
		ps.setString(4,"N");
		ps.execute();
  		
  		out.println("<HTML>");
                out.println("<HEAD>");
                out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
          	out.println("<TITLE></TITLE>");
        	out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");	  	
	  	
	        out.println("<form method=POST action=\"" + uri + "\">");
	        out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
	
  	        out.println("<tr>");
    	        out.println("<td colspan=3 bgcolor=#8B9000 height=20><b><font face=Arial size=4 color=#666666>Your Registration Form Has Been Received </font></b></td>");
  	        out.println("</tr>");
                
		out.println("<tr>");
    	        out.println("<td colspan=3 bgcolor=#9B96D8 height=20><b><font face=Arial size=2 color=#666666>You will be contacted for further interview.</font></b></td>");
  	        out.println("</tr>");
		out.println("<tr>");
    	        out.println("<td colspan=3 bgcolor=#9B96D8 height=20><b><font face=Arial size=2 color=#666666>Meanwhile, Enjoy your visit in our YMCA site.</font></b></td>");
  	        out.println("</tr>");
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


  public void ReEnterApp(java.io.PrintWriter out, String uri){
     out.println("Insert ..");
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