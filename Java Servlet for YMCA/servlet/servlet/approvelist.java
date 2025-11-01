import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class approvelist extends HttpServlet
{

  String DRIVER_NAME ="sun.jdbc.odbc.JdbcOdbcDriver";
  String CONNECTION_URL = "jdbc:odbc:ymca";

  String ACTION = "action";
  String ACTION_Confirm = "Approve";
  
  String ACTION_Print = "Print";
  
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




      String uri = "getapprove";

      // Get the action command (if one exists)
      String hkid = getParameter(req, "getapp1");
      
      try {

        Connection con = null;
      	PreparedStatement ps = null;
      	ResultSet rs = null;
        
    //    Class.forName(DRIVER_NAME).newInstance();  
	// con = DriverManager.getConnection(CONNECTION_URL);
		
	String sql = "SELECT app_name , app_hkid , course.course_id , description" +
	" , confirm , approve from course, application, applicant" +
	" where application.app_id=? and course.course_id = application.course_id" +
	" and application.app_id = applicant.app_id and confirm = 'Y' and approve = 'N'";
        
  	ps = con.prepareStatement(sql);
  	ps.setString(1, hkid);
  	rs = ps.executeQuery();
        
 		String APP_HKID = rs.getString("app_hkid");
  		String APP_NAME = rs.getString("app_name");
  		String DESC = rs.getString("description");
  		String CONFIRM = rs.getString("confirm");
  		String APPROVE = rs.getString("approve");
  		String COU_ID = rs.getString("course_id");
	
        
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
       	out.println("<input type=hidden name=H_ID value=\"" + APP_HKID + "\">");
	out.println("<input type=hidden name=H_NAME value=\"" + APP_NAME + "\">");
       	out.println("<input type=hidden name=DESC value=\"" + DESC + "\">");
	out.println("<input type=hidden name=CONFIRM value=\"" + CONFIRM + "\">");
	out.println("<input type=hidden name=APPROVE value=\"" + APPROVE + "\">");
       	out.println("<input type=hidden name=COU_ID value=\"" + COU_ID + "\">");
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
	out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>COURSEID</b></font></td>");
	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				COU_ID + "</font></td>");
	out.println("</tr><tr>");
        out.println("<td width=250 bgcolor=#C0C0C0><font face=Arial color=#333333 size=2><b>Descrption</b></font></td>");
	out.println("<td width=250 bgcolor=#F3F4F5><font size=2 face=Arial color=#333333>" +
  				DESC + "</font></td>");
	out.println("</tr>");
        
 	out.println("</table>");
	
	
        
             
      }
      
      	catch (Exception ex) {
        // Ignore any errors
          out.println(ex.getMessage());
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