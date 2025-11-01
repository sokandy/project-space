import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Report extends HttpServlet
{

  String DRIVER_NAME ="sun.jdbc.odbc.JdbcOdbcDriver";
  String CONNECTION_URL = "jdbc:odbc:ymca";

  String ACTION = "action";
  String REPORT1 = "Financial Report";
  String REPORT2 = "Statistical Report";
  
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
            action.equals(REPORT1)) {
          Fin_report(out, req);
        }
        else if ((action != null) &&
            action.equals(REPORT2)) {
          Sta_report(out, req);
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

  public void Sta_report(java.io.PrintWriter out, HttpServletRequest req)
    {
    	Connection con=null;
	Statement stmt=null;
	ResultSet rs = null;
    	
    	try {
  	  	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  		con = DriverManager.getConnection("jdbc:odbc:ymca");
    
  		stmt = con.createStatement();
  
  		rs = stmt.executeQuery("SELECT a.course_id , Count(app_id) As sum" +
  		" from course c, application a where c.course_id = a.course_id" +
		" Group By a.course_id");
    	
    	out.println("<html>");

	out.println("<head><center><b>Report Statistic</b></center></head>");

	out.println("<body topmargin=0 leftmargin=0>");
	out.println("<form>");
	out.println("<table border=0 width=500>");
		out.println("<tr><center><b>COURSE VS PERSON</b></center></tr>");
		  out.println("<OBJECT ID=iechart1 CLASSID=CLSID:FC25B780-75BE-11CF-8B01-444553540000 border=2"
			      + " STYLE=\"TOP:58pt;LEFT:25pt;ZINDEX:0;\"" 
			      + " codebase=http://activex.microsoft.com/controls/iexplorer/x86/iechart.cab >");
		  out.println("<PARAM NAME=Title VALUE=Statistic>");
		  out.println("<PARAM NAME=_ExtentX VALUE=9022>");
		  out.println("<PARAM NAME=_ExtentY VALUE=6429>");
		  String[] name = new String[30];
		  String[] sum = new String[30];
		  int c = 0;
		  while (rs.next()) {
		  	name[c] = rs.getString("course_id");
		  	sum[c] = rs.getString("sum");
		  	c++;
		  }			  
                  out.println("<PARAM NAME=Columns VALUE=" + c + ">");
		  out.print("<PARAM NAME=ColumnNames VALUE=\"");
		  for (int a = 0; a < c; a++) {
		  	   out.print(name[a] + " ");
		  	} 	  
		  out.println("\">");
		  out.println("<PARAM NAME=ChartType VALUE=1>");
		  out.print("<PARAM NAME=Data[0] VALUE=\"");
		  for (int b = 0; b < c; b++) {
		  	   out.print(sum[b] + " ");
		  	}
		  
		  out.println("\">");					  
		  out.println("<PARAM NAME=HorizontalAxis VALUE=1>");
		  out.println("<PARAM NAME=VerticalAxis VALUE=1>");
		  out.println("<PARAM NAME=hgridStyle VALUE=1>");
		  out.println("<PARAM NAME=vgridStyle VALUE=1>");
		  out.println("<PARAM NAME=ColorScheme VALUE=0>");
		  out.println("<PARAM NAME=BackStyle VALUE=1>");
		  out.println("<PARAM NAME=Scale VALUE=100>");
		  out.println("<PARAM NAME=DisplayLegend VALUE=1>");
		  out.println("<PARAM NAME=BackColor VALUE=16777215>");
		  out.println("<PARAM NAME=ForeColor VALUE=32768>");
		  out.println("<embed src=ABC border=2 title=ABC _extentx=9022 _extenty=6429 columns=5 columnnames=\"COMP305 COMP306 COMP307 COMP308 COMP309\" charttype=1 data[0]=\"20 10 30 50 80\" horizontalaxis=1 verticalaxis=1 hgridstyle=1 vgridstyle=1 colorscheme=0 backstyle=1 scale=100 displaylegend=1 backcolor=16777215 forecolor=32768></embed>");
  	          out.println("</OBJECT>");
	  out.println("</td>");
	out.println("</tr>");
	out.println("</table>");
	out.println("</form>");
	out.println("</body>");
	out.println("</html>");
	
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
	
public void Fin_report(java.io.PrintWriter out, HttpServletRequest req)
    {
    	Connection con=null;
	Statement stmt=null;
	ResultSet rs = null;
    	
    	try {
  	  	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  		con = DriverManager.getConnection("jdbc:odbc:ymca");
    
  		stmt = con.createStatement();
  
  		rs = stmt.executeQuery("SELECT a.course_id , Sum(fee) As sum" +
  		" from course c, application a where c.course_id = a.course_id" +
		" Group By a.course_id");
		
		ResultSetMetaData rsmd = rs.getMetaData();
    		int columnCount = rsmd.getColumnCount();
    		
    	out.println("<html>");

	out.println("<head><center><b>Report Statistic</b></center></head>");

	out.println("<body topmargin=0 leftmargin=0>");
	out.println("<form>");
	out.println("<table border=0 width=500>");
		out.println("<tr><center><b>COURSE VS FEE</b></center></tr>");
		  out.println("<OBJECT ID=iechart1 CLASSID=CLSID:FC25B780-75BE-11CF-8B01-444553540000 border=2"
			      + " STYLE=\"TOP:58pt;LEFT:25pt;ZINDEX:0;\"" 
			      + " codebase=http://activex.microsoft.com/controls/iexplorer/x86/iechart.cab >");
		  out.println("<PARAM NAME=Title VALUE=Statistic>");
		  out.println("<PARAM NAME=_ExtentX VALUE=9022>");
		  out.println("<PARAM NAME=_ExtentY VALUE=6429>");
		  
		  String[] name = new String[30];
		  String[] sum = new String[30];
		  int j = 0;
		  while (rs.next()) {
		  	name[j] = rs.getString("course_id");
		  	sum[j] = rs.getString("sum");
		  	j++;
		  }
		  out.println("<PARAM NAME=Columns VALUE=" + j + ">");
		  out.print("<PARAM NAME=ColumnNames VALUE=\"");
		  for (int k = 0; k < j; k++) {
		  	   out.print(name[k] + " ");
		  	} 	  
		  out.println("\">");
		  out.println("<PARAM NAME=ChartType VALUE=1>");
		  out.print("<PARAM NAME=Data[0] VALUE=\"");
		  for (int n = 0; n < j; n++) {
		  	   out.print(sum[n] + " ");
		  	}
		  
		  out.println("\">");
		  out.println("<PARAM NAME=HorizontalAxis VALUE=1>");
		  out.println("<PARAM NAME=VerticalAxis VALUE=1>");
		  out.println("<PARAM NAME=hgridStyle VALUE=1>");
		  out.println("<PARAM NAME=vgridStyle VALUE=1>");
		  out.println("<PARAM NAME=ColorScheme VALUE=0>");
		  out.println("<PARAM NAME=BackStyle VALUE=1>");
		  out.println("<PARAM NAME=Scale VALUE=100>");
		  out.println("<PARAM NAME=DisplayLegend VALUE=1>");
		  out.println("<PARAM NAME=BackColor VALUE=16777215>");
		  out.println("<PARAM NAME=ForeColor VALUE=32768>");
		  out.println("<embed src=ABC border=2 title=ABC _extentx=9022 _extenty=6429 columns=5 columnnames=\"COMP305 COMP306 COMP307 COMP308 COMP309\" charttype=1 data[0]=\"20 10 30 50 80\" horizontalaxis=1 verticalaxis=1 hgridstyle=1 vgridstyle=1 colorscheme=0 backstyle=1 scale=100 displaylegend=1 backcolor=16777215 forecolor=32768></embed>");
	out.println("</OBJECT>");
	  out.println("</td>");
	out.println("</tr>");
	out.println("</table>");
	out.println("</form>");
	out.println("</body>");
	out.println("</html>");
	
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