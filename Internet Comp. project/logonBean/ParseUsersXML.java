package logonBean;

import logonBean.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.URL;
import java.io.*;
import java.awt.List;

public class ParseUsersXML
{
    private NodeList childList;
    private Element users;
    String inputXML = "";
    
 
 public ParseUsersXML() throws ParseUsersFileException
 {
    Document document;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    
    inputXML = new String("../webapps/projects/intercomp/userTable.xml");
    
    
    try 
       {
       	DocumentBuilder builder = factory.newDocumentBuilder();

	document = builder.parse(inputXML);
	Element rootElement = document.getDocumentElement();
	//if it's the users element:
        if(rootElement.getNodeName().equalsIgnoreCase("userTable"))
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
 
 public boolean checkPassword(String username, String password)
    {
        //for all the elements in the list:
        for(int i = 0;i < childList.getLength();i++ )
        {
            //find the user element:
            if(childList.item(i).getNodeName().equalsIgnoreCase("user"))
            {
                //call the ParseUserNode class to handle the node:
                ParseUserNode theUser = new ParseUserNode(childList.item(i));
                //if the usernames match:
                if(theUser.getAlias().equals(username))
                {
                    //if the passwords match:
                    if(theUser.getPassword().equals(password))
                    {
                        //OK:
                        return true;
                    }
                    else
                    {
                        //passwords don't match:
                        return false;
                    }
                }
            }
        } //end for
        return false;
    } //end checkPassword()
 
 
 
 public boolean isAMember(String username)
    {
        //for all the elements in the list:
        for(int i = 0;i < childList.getLength();i++)
        {
            //find the user element:
            if(childList.item(i).getNodeName().equalsIgnoreCase("user"))
            {
                //call the ParseUserNode class to handle the node:
                ParseUserNode theUser = new ParseUserNode(childList.item(i));
                //if the username matches:
                if(theUser.getAlias().equals(username))
                {
                    return true;
                }
            }
        } //end for
        return false;
    } //end isAMember()
 
 public String getPassword(String username)
    {
        //for all the elements in the list:
        for(int i = 0;i < childList.getLength();i++)
        {
            //find the user element:
            if(childList.item(i).getNodeName().equalsIgnoreCase("user"))
            {
                //call the ParseUserNode class to handle the node:
                ParseUserNode theUser = new ParseUserNode(childList.item(i));
                //if the username matches
                if(theUser.getAlias().equals(username))
                {
                    //return the relevant password:
                    return theUser.getPassword();
                }
            }
        } //end for
        return null;
    } //end getPassword

 
 
 public List getUserList()
    {
        //define the list:
        List theNames = new List();
        //for each element in the node list:
        for(int i = 0; i < childList.getLength(); i++)
        {
            //find the user element:
            if(childList.item(i).getNodeName().equalsIgnoreCase("user"))
            {
                //call the ParseUserNode class to handle the node:
                ParseUserNode theUser = new ParseUserNode(childList.item(i));
                //add the user ID to our list:
                theNames.add(theUser.getAlias());
            }
        } //end for
        return theNames;
    } //end getUserList()
 
 public void addUser(String username, String password, String first, String sure, String phone, String email) throws ParseUsersFileException
    {
        //define the file streams:
        FileInputStream fileInput;
        DataInputStream dataInput;
        FileOutputStream fileOutput;
        DataOutputStream dataOutput;
        String inputString = new String("");
        String outputString = null;

        try
        {
            //open the file for input:
            fileInput = new FileInputStream("../webapps/projects/intercomp/userTable.xml");
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
            outputString = inputString.substring(0, (inputString.lastIndexOf("</userTable>")));
            //append the new user information to the output string:
            outputString += "   <user userID=\"" + username + "\" pwd=\"" + password + "\" first=\"" 
                  + first + "\" sure=\"" + sure + "\">\n";
            outputString += "    <email>" + email + "</email>\n";
            outputString += "    <phone>" + phone + "</phone>\n";  
            outputString += " </user>\n</userTable>";   
            
            
            
            //open the file for writing:
            fileOutput = new FileOutputStream("../webapps/projects/intercomp/userTable.xml");
            dataOutput = new DataOutputStream(fileOutput);
            //write the data to the file:
            dataOutput.writeBytes(outputString);
            //close the output streams:
            dataOutput.close();
            fileOutput.close();
        }
        catch(FileNotFoundException fnf)
        {
            throw new ParseUsersFileException("Could not load the xml file : "
                                              + new File("../webapps/projects/intercomp/userTable.xml").getPath());
        }
        catch(IOException ioe)
        {
            throw new ParseUsersFileException("Could not write to the xml file : "
                                              + new File("../webapps/projects/intercomp/userTable.xml").getPath());
        }
    } //end addUser()
    
    
}    
    
    
    
    
    
    
    
    
