//Listing 25-17: Generate-on-Demand Servlet 
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import com.sun.xml.tree.XmlDocument;
import org.xml.sax.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

   
public class DisplayAll extends HttpServlet {
  	 
  private Transformer transformer;
  private File dataDir = new File ("../jsdk2.1/webpages/");
  private String dataUrl = "http://localhost:8080/";
  
  public void init () throws ServletException {
    TransformerFactory tf = TransformerFactory.newInstance();
    StreamSource ss = new StreamSource
        ("displayAll.xsl");
	//-------------------------- cannot change the xsl name with variable ???????????
    try {
      transformer = tf.newTransformer (ss);
    } catch (TransformerConfigurationException tce) {
      throw new ServletException (tce);
    }
  }   
  public void doGet (HttpServletRequest request,
                     HttpServletResponse response)
      throws IOException, ServletException {
    // code that prints a form which is used
    // to select which month to display
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
	String uri = request.getRequestURI();	
                
        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<META HTTP-EQUIV=content-type CONTENT=text/html; charset=big5>");
  	out.println("<TITLE></TITLE>");
	out.println("<body bgcolor=#FFFFFF topmargin=2 leftmargin=2>");	  	
	 	
	out.println("<form method=POST action=\"" + uri + "\">");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
	out.println("<tr>");
    	out.println("<td colspan=3 height=20><b><font face=Arial size=4 color=#666666>Call servlet</font></b></td>");
  	out.println("</tr>");
	out.println("<tr>");
     	out.println("<td width=250 bgcolor=#9B96D8><font face=Arial size=1 color=#FFFFFF>");
 	out.println("<input type=submit name=inputXml value= \"advert\">");
        out.println("</font>");
 	out.println("</td>");
 	out.println("</tr>");
	out.println("</table>");
	out.println("<table border=0 width=500 cellspacing=1 cellpadding=1>");
        out.println("<tr>");
    	out.println("<td width=500 bgcolor=#9B96DD height=20><b><font face=Arial size=3 color=#666666>by click button</font></b></td>");
  	out.println("</tr>");
	out.println("</table>");
	out.println("</body></HEAD>");
        out.println("</HTML>");
  }
   
  public void doPost (HttpServletRequest request,
                      HttpServletResponse response)
        throws IOException, ServletException {	
    // get request parameters ------------------- get input file name here
        String baseFileName = request.getParameter("inputXml");
	//TransformerFactory tf = TransformerFactory.newInstance();
        //StreamSource ss = new StreamSource (baseFileName + ".xsl");
 	
        File xmlSource = new File(dataDir, baseFileName + ".xml");
        File generatedHtml = 
        new File (dataDir, baseFileName + ".html");
   
    // check that source xml document exists
    if (!xmlSource.exists()) {
      sourceNotFound (request, response);
	System.out.println("not found xml source");
      return;
    }
   
    // generate an HTML document if none exists
    // for this month, or if the source is newer
    if (!generatedHtml.exists() ||
        generatedHtml.lastModified() <
        xmlSource.lastModified()) {
   
      StreamSource streamSource = 
          new StreamSource (xmlSource);
      StreamResult streamResult = 
          new StreamResult (generatedHtml);
   
      try {
        transformer.transform (streamSource, streamResult);
      } catch (TransformerException te) {
        throw new ServletException (te);
      }
    }
    // redirect the client to the generated HTML document
    System.out.println(dataUrl + baseFileName + ".html");	
    response.sendRedirect (dataUrl + baseFileName + ".html");
  }
   
  public void sourceNotFound (HttpServletRequest request,
                              HttpServletResponse response)
      throws IOException, ServletException {
    // print an error message, redirect to a static
    // error page or another servlet
	System.out.println("sourceNotFound ...");
  }
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
}


