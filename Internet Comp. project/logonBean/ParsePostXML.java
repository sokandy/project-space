package logonBean;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
import java.io.*;
import java.awt.List;
import java.util.*;

public class ParsePostXML
{
    private NodeList childList;
    private Element users;
    String inputXML = "";
    String tag = "";
    String tag2 = "";
 
 public ParsePostXML(String xmlfile) throws ParseUsersFileException
 {
    Document document;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    tag = xmlfile;
    
    if (tag.equals("Notices"))
       tag2 = "notice";
    if (tag.equals("Services"))
       tag2 = "service";
    if (tag.equals("Jobs"))
       tag2 = "job";
    if (tag.equals("Motors"))
       tag2 = "motor";
    
    inputXML = new String("../webapps/projects/intercomp/" + xmlfile + ".xml");
    
    
    try 
       {
       	DocumentBuilder builder = factory.newDocumentBuilder();

	document = builder.parse(inputXML);
	Element rootElement = document.getDocumentElement();
	//if it's the users element:
        if(rootElement.getNodeName().equalsIgnoreCase(xmlfile))
        {
         //store the element:
         users = rootElement;
        }

       }
       catch(IOException ioe)
        {
            throw new ParseUsersFileException("Could not load the XML file : "
                                              + new File(inputXML).getPath());
        }
        catch(Exception e)
	{
	  throw new ParseUsersFileException("The error is : " + e);
	}
    

    childList = users.getChildNodes();
 } //end ParseUsersXML()
 
 
 
 public void addPost(String username, String title, String subsection, String body, String prio, String day) throws ParseUsersFileException
    {
        //define the file streams:
        FileInputStream fileInput;
        DataInputStream dataInput;
        FileOutputStream fileOutput;
        DataOutputStream dataOutput;
        String inputString = new String("");
        String outputString = null;
        Date df = new Date();

        try
        {
            //open the file for input:
            fileInput = new FileInputStream(inputXML);
            dataInput = new DataInputStream(fileInput);
            //read the entire file in to the input string:
            String input = dataInput.readLine();
            while(input != null)
            {
                inputString += input + "\n";
                input = dataInput.readLine();
            }
            //close the input string:
            dataInput.close();
            fileInput.close();

            //append the existing file to the output string as far as the closing tag:
            outputString = inputString.substring(0, (inputString.lastIndexOf("</" + tag + ">")));
            //append the new user information to the output string:
             outputString += "  <" + tag2 + ">\n";
             outputString += "   <header userID=\"" + username + "\" title=\"" + title + "\" sub_section=\"" + subsection + "\" priority=\"" 
                          + prio + "\" day=\"" + day + "\" stdate=\"" + df + "\"/>\n";
             outputString += "   <body>" + body + "</body>\n";
             outputString += "  </" + tag2 + ">\n</" + tag + ">";
            
            //open the file for writing:
            fileOutput = new FileOutputStream(inputXML);
            dataOutput = new DataOutputStream(fileOutput);
            //write the data to the file:
            dataOutput.writeBytes(outputString);
            //close the output streams:
            dataOutput.close();
            fileOutput.close();
        }
        catch(FileNotFoundException fnf)
        {
            throw new ParseUsersFileException("Could not load the xml file :" + inputXML );
        }
        catch(IOException ioe)
        {
            throw new ParseUsersFileException("Could not write to the xml file : " + inputXML);
        }
    } //end addUser()
    
    
}    
    
    
    
    
    
    
    
    
